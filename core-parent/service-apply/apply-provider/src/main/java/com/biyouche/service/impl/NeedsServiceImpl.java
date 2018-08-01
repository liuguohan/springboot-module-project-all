package com.biyouche.service.impl;

import com.biyouche.constants.UserConstant;
import com.biyouche.dao.apply.ApplyMapper;
import com.biyouche.dao.apply.NeedsCancelMapper;
import com.biyouche.dao.apply.NeedsMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.apply.Needs;
import com.biyouche.domain.apply.NeedsCancel;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.redis.utils.RedisTempleteUtils;
import com.biyouche.service.NeedsService;
import com.biyouche.utils.DictUtil;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("needsService")
public class NeedsServiceImpl implements NeedsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NeedsServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NeedsMapper needsMapper;
    @Autowired
    private NeedsCancelMapper needsCancelMapper;
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 获取学车需求因素列表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> factorList() {
        LOGGER.info("获取学车需求因素列表......");
        return getDictMap("needs_factor");
    }

    /**
     * 需求申请提交页面展示
     *
     * @param userId 选择因素的id
     * @return
     */
    @Override
    public Map<String, Object> applyNeeds(Integer userId) throws BussinessException {
        LOGGER.info("学车需求页面请求参数:无");
        Map<String, Object> needsMap = new LinkedHashMap<>();
        User user = new User();
        //判断用户是否登录
        if (!ValidatorUtils.isNull(userId)) {
            //通过用户id获取用户
            user = userMapper.selectUserById(userId);
        }
        needsMap.put("user_id", ValidatorUtils.isNull(userId) ? 0 : userId);
        needsMap.put("user_name", ValidatorUtils.isNull(user.getNickName()) ? "" : user.getNickName());
        needsMap.put("phone", ValidatorUtils.isNull(user.getLoginMobile()) ? "" : user.getLoginMobile());
        //获取驾驶证类型列表
        needsMap.put("license_type", getDictMap("driving_license_type"));
        return needsMap;
    }

    /**
     * 学车需求提交
     *
     * @param needs
     */
    @Override
    public Map<String, Object> submitNeeds(Needs needs) throws BussinessException {
        LOGGER.info("学车需求提交请求参数:" + needs.toString());
        //添加数据到数据库
        needs.setCreateTime(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        needsMapper.addNeeds(needs);
        if (ValidatorUtils.isNull(needs.getNeedsId())) {
            throw new BussinessException(210001);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("needsId", needs.getNeedsId());
        return map;
    }

    /**
     * 学车需求反馈
     *
     * @return
     */
    @Override
    public Map<String, Object> feedback() {
        LOGGER.info("学车需求反馈请求参数:无");
        Map<String, Object> valueMap = new HashMap<>();
        //报名成功用户数目,从redis中取
        String successNum = RedisTempleteUtils.getStr("apply_success_num");
        if (ValidatorUtils.isNull(successNum)) {
            //从数据库(学车订单表(暂无:2018/7/19))取
            successNum = needsMapper.selectSuccessNum(UserConstant.LEARN_APPLY_STATUS_SUCCESS) + "";
            //存入redis
            RedisTempleteUtils.set("apply_success_num", successNum, 0);
        }

        valueMap.put("applySuccessTotalNum", successNum);
        return valueMap;
    }

    /**
     * 学车需求取消
     */
    @Override
    public Map<String, Object> cancelNeeds() {
        LOGGER.info("学车需求取消页面请求参数:无");
        //取字典取消原因
        Map<String, Object> reasonMap = new HashMap<>();
        reasonMap.put("reason_list", getDictMap("needs_cancel_reason"));
        return reasonMap;
    }

    /**
     * 确认取消
     *
     * @param needsCancel
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void confirmCancel(NeedsCancel needsCancel, Integer userId) throws BussinessException {
        LOGGER.info("学车需求确认取消请求参数:" + needsCancel.toString());
        Integer needsId = needsCancel.getNeedsId();
        Integer applyId = needsCancel.getApplyId();
        Integer schoolId = needsCancel.getSchoolId();
        //非驾校内咨询情况下取消
        if (!ValidatorUtils.isNull(needsId)) {
            //取消原因
            Needs needs = needsMapper.selectByUserIdAndNeedsId(userId, needsId);
            if (!ValidatorUtils.isNull(needs)) {
                needsCancel.setSchoolId(ValidatorUtils.isNull(needs.getSchoolId()) ? 0 : needs.getSchoolId());
            }
            //删除需求数据
            needsMapper.deleteById(needsId);
        }
        //针对驾校的咨询
        if (!ValidatorUtils.isNull(applyId)) {
            needsCancel.setSchoolId(ValidatorUtils.isNull(schoolId) ? 0 : schoolId);
            //删除申请数据
            applyMapper.deleteById(applyId);
        }
        //
        //备份取消原因
        needsCancel.setSchoolId(ValidatorUtils.isNull(needsCancel.getSchoolId()) ? 0 : needsCancel.getSchoolId());
        needsCancel.setNeedsId(ValidatorUtils.isNull(needsCancel.getNeedsId()) ? 0 : needsCancel.getNeedsId());
        needsCancel.setApplyId(ValidatorUtils.isNull(needsCancel.getApplyId()) ? 0 : needsCancel.getApplyId());
        needsCancel.setCancelTime(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        needsCancel.setUserId(ValidatorUtils.isNull(userId) ? 0 : userId);
        int cancel = needsCancelMapper.addCancel(needsCancel);
        if (cancel == 0) {
            throw new BussinessException(210002);
        }
    }

    /**
     * 返回字典列表时的封装
     *
     * @param dictName 字典名
     * @return
     */
    private List<Map<String, Object>> getDictMap(String dictName) {
        List<Dict> licenseType = DictUtil.getDict(dictName);
        List<Map<String, Object>> list = new ArrayList<>();
        for (Dict dict : licenseType) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("itemId", dict.getItemId());
            map.put("itemName", dict.getItemName());
            map.put("itemValue", dict.getItemValue());
            list.add(map);
        }
        return list;
    }
}
