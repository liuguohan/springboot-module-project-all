package com.biyouche.service.impl;

import com.biyouche.dao.apply.ApplyMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.apply.Apply;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.service.ApplyService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service("applyService")
public class ApplyServiceImpl implements ApplyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplyServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApplyMapper applyMapper;

    /**
     * 申请页面
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> toApply(Integer userId) throws BussinessException{
        LOGGER.info("申请页面请求参数:无");
        Map<String, Object> applyMap = new LinkedHashMap<>();
        //判断用户是否登录
        User user = new User();
        if (!ValidatorUtils.isNull(userId)) {
            //通过用户id获取用户
             user = userMapper.selectUserById(userId);
        }
        applyMap.put("user_id", ValidatorUtils.isNull(userId) ? 0 : userId);
        applyMap.put("user_name", ValidatorUtils.isNull(user.getNickName()) ? "" : user.getNickName());
        applyMap.put("phone", ValidatorUtils.isNull(user.getLoginMobile()) ? "" : user.getLoginMobile());
        return applyMap;
    }

    /**
     * 申请提交
     * @param apply
     * @return
     */
    @Override
    public Map<String, Object> submit(Apply apply) throws BussinessException {
        LOGGER.info("学车申请提交请求参数:" + apply.toString());
        //添加数据到数据库
        apply.setApplyTime(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        applyMapper.addApply(apply);
        if (ValidatorUtils.isNull(apply.getApplyId())) {
            throw new BussinessException(210000);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("applyId", apply.getApplyId());
        map.put("schoolId", apply.getSchoolId());
        return map;

    }
}
