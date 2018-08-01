package com.biyouche.controller.apply;

import com.alibaba.fastjson.JSON;
import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.Needs;
import com.biyouche.domain.apply.NeedsCancel;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.NeedsService;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学车需求
 */
@RestController
@RequestMapping("/needs")
public class NeedsController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NeedsController.class);
    @Autowired
    private NeedsService needsService;

    /**
     * 学车需求,加载需求因素
     *
     * @return
     */
    @PostMapping("/factors")
    public ResponseObject chooseFactors(@CurrentUser Integer userId) {
        try {
            List<Map<String, Object>> factorList = needsService.factorList();
            ResponseObject dealSuccess = dealSuccess();
            dealSuccess.content.put("user_id", ValidatorUtils.isNull(userId) ? 0 : userId);
            dealSuccess.content.put("factor_list", factorList);
            LOGGER.info("学车需求因素响应参数:content:" + dealSuccess.content + ",info:" + dealSuccess.info);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 需求提交页面
     * @param userId
     * @return
     */
    @PostMapping("/applyNeeds")
    public ResponseObject applyNeeds(@CurrentUser Integer userId) {
        try {
            Map<String, Object> needsMap = needsService.applyNeeds(userId);
            LOGGER.info("学车需求提交页面响应参数:" + needsMap);
            return dealSuccess(needsMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 学车需求提交
     * @param userId
     * @param needs
     * @return
     */
    @PostMapping("/submitNeeds")
    public ResponseObject submitNeeds(@CurrentUser Integer userId, Needs needs) {
        try {
            //未登录就是存0
            needs.setUserId(ValidatorUtils.isNull(userId) ? 0 : userId);
            LOGGER.info("学车需求提交请求参数:" + needs.toString());
            Map<String, Object> resultMap = needsService.submitNeeds(needs);
            LOGGER.info("学车需求提交响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 需求提交反馈
     *
     * @return
     */
    @PostMapping("/feedback")
    public ResponseObject feedback() {
        try {
            Map<String, Object> feedbackMap = needsService.feedback();
            LOGGER.info("需求提交反馈响应参数:" + feedbackMap);
            return dealSuccess(feedbackMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 跳转取消需求申请页面
     *
     * @return
     */
    @PostMapping("/cancelNeeds")
    public ResponseObject cancelNeeds() {
        try {
            Map<String, Object> resultMap = needsService.cancelNeeds();
            LOGGER.info("跳转取消需求申请页面响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * @param userId      用户id
     * @param needsCancel 取消原因
     * @return
     */
    @PostMapping("/confirmCancel")
    public ResponseObject confirmCancel(@CurrentUser Integer userId, NeedsCancel needsCancel) {
        try {
            LOGGER.info("学车需求确认取消请求参数:" + needsCancel.toString());
            needsService.confirmCancel(needsCancel, ValidatorUtils.isNull(userId) ? 0 : userId);
            LOGGER.info("学车需求确认取消响应参数:" + dealSuccess());
            return dealSuccess();
        } catch (Exception e) {
            return dealException(e);
        }
    }
}
