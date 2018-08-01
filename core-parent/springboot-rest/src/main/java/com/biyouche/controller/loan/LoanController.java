package com.biyouche.controller.loan;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.loan.LearnLoan;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.LoanService;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/loan")
public class LoanController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
    @Autowired
    private LoanService loanService;

    /**
     * 信用学车接口
     *
     * @return
     */
    @PostMapping("/toApplyLoan")
    public ResponseObject toApplyLoan(@CurrentUser Integer userId) {
        try {
            Map<String, Object> resultMap = loanService.toApplyLoan(userId);
            LOGGER.info("信用学车响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 学车贷申请提交
     *
     * @param userId
     * @param learnLoan
     * @return
     */
    @PostMapping("/submitApply")
    public ResponseObject submitApply(@CurrentUser Integer userId, LearnLoan learnLoan) {
        LOGGER.info("学车贷申请提交请求参数:" + learnLoan);
        try {
            learnLoan.setUserId(userId);
            loanService.submitApply(learnLoan);
            LOGGER.info("信用学车响应参数:" + dealSuccess().info);
            return dealSuccess();
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 学车贷审核结果
     * @param userId
     * @return
     */
    @PostMapping("/auditResult")
    public ResponseObject auditResult(@CurrentUser Integer userId){
        try{
            Map<String,Object> resultMap = loanService.auditResult(userId);
            LOGGER.info("学车贷审核结果响应参数:" + resultMap);
            return dealSuccess(resultMap);
        }catch (Exception e){
            return dealException(e);
        }
    }

    /**
     * 去开卡页面
     * @param userId
     * @return
     */
    @PostMapping("/toApplyCard")
    public ResponseObject toApplyCard(@CurrentUser Integer userId){
        LOGGER.info("去开卡页面请求参数:userId = " + userId);
        try{
            Map<String,Object> resultMap = loanService.toApplyCard(userId);
            LOGGER.info("去开卡页面响应参数:" + resultMap);
            return dealSuccess(resultMap);
        }catch (Exception e){
            return dealException(e);
        }

    }
}
