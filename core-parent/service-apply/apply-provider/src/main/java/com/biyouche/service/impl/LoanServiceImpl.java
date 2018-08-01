package com.biyouche.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.constants.ConfigConstant;
import com.biyouche.constants.UserConstant;
import com.biyouche.dao.loan.LoanMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.domain.loan.LearnLoan;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.LoanService;
import com.biyouche.utils.DictUtil;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;

@Service("loanService")
public class LoanServiceImpl implements LoanService {


    private final static Logger LOGGER = LoggerFactory.getLogger(LoanServiceImpl.class);

    @Autowired
    private LoanMapper loanMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 学车贷申请页面
     *
     * @param userId 当前用户id
     * @return
     */
    @Override
    public Map<String, Object> toApplyLoan(Integer userId) throws BussinessException {
        //判断用户是否登录
        if (ValidatorUtils.isNull(userId)) {
            throw new BussinessException(200013);
        }
        //判断该用户是否已提交申请
        int cow = loanMapper.selectTotalNum(userId, UserConstant.LOAN_STATUS_UNPASS);
        //有申请
        if (cow > 0) {
            //不容许申请,客户端调用相应接口
            throw new BussinessException(210004);
        }
        Map<String, Object> resultMap = new HashMap<>();
        //获取用户信息
        User user = userMapper.selectUserById(userId);
        resultMap.put("user_name", user.getNickName());
        resultMap.put("phone", user.getLoginMobile());
        //获取驾证类型
        resultMap.put("license_type_list", getDictMap("driving_license_type"));
        return resultMap;
    }

    @Override
    public void submitApply(LearnLoan learnLoan) throws BussinessException {
        //判断是否登录
        if (ValidatorUtils.isNull(learnLoan.getUserId())) {
            throw new BussinessException(200013);
        }
        //设置创建时间
        learnLoan.setCreateTime(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        //保存数据
        int cow = loanMapper.insertLoan(learnLoan);
        if (cow == 0) {
            throw new BussinessException(210005);
        }
    }

    /**
     * 学车贷报名审核结果
     *
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> auditResult(Integer userId) throws BussinessException {

        //判断是否登录
        if (ValidatorUtils.isNull(userId)) {
            throw new BussinessException(200013);
        }
        //查询报名信息
        LearnLoan learnLoan = loanMapper.selectByUserId(userId, UserConstant.PAY_STATUS_WAIT);
        if (ValidatorUtils.isNull(learnLoan) || ValidatorUtils.isNull(learnLoan.getLoanId())) {
            throw new BussinessException(210006);
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("audit_status", learnLoan.getStatus());
        resultMap.put("loan_id", learnLoan.getLoanId());
        return resultMap;
    }

    /**
     * 去开卡页面
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> toApplyCard(Integer userId) throws BussinessException{
        //判断是否登录
        if (ValidatorUtils.isNull(userId)){
            throw new BussinessException(200013);
        }
        //将需要支付的金额返回回去
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("pay_amount", ConfigConstant.getInstance().CARD_PAY_AMOUNT);
        return resultMap;
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
