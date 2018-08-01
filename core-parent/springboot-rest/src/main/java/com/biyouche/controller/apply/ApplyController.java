package com.biyouche.controller.apply;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.Apply;
import com.biyouche.domain.apply.Needs;
import com.biyouche.domain.apply.NeedsCancel;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.ApplyService;
import com.biyouche.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 学车需求
 */
@RestController
@RequestMapping("/apply")
public class ApplyController extends BaseController {

    @Autowired
    private ApplyService applyService;


    /**
     * 申请提交页面
     *
     * @param userId
     * @return
     */
    @PostMapping("/toApply")
    public ResponseObject applyNeeds(@CurrentUser Integer userId) {
        try {
            Map<String, Object> resultMap = applyService.toApply(userId);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 确认提交
     * @param userId
     * @param apply
     * @return
     */
    @PostMapping("/submit")
    public ResponseObject submitNeeds(@CurrentUser Integer userId, Apply apply) {

        try {
            //未登录就是存0
            apply.setUserId(ValidatorUtils.isNull(userId) ? 0 : userId);
            Map<String, Object> resultMap = applyService.submit(apply);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }
}
