package com.biyouche.controller.find;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.FindActivityService;
import com.biyouche.utils.ValidatorUtils;


/**
 * 发现活动模块
 * @author lgh
 *
 */
@RequestMapping("/find/activity")
@RestController
public class FindActivityController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FindActivityController.class);
	
	@Autowired
	private FindActivityService findActivityService;
	
	/**
     * 发现活动模块活动列表
     * @param findId
     * @return
     */
	@GetMapping("/activityList")
    public ResponseObject activityList(Integer findId) {
		try {
			if( findId == null || findId.equals(0) ) {
				throw new BussinessException(230000);
			}
			
        	LOGGER.info("发现活动模块活动列表 >> findId =" + findId);
			return dealSuccess(findActivityService.activityList(findId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现活动模块活动详情
     * @param activityId
     * @return
     */
	@GetMapping("/activityDetail")
    public ResponseObject activityDetail(Integer activityId) {
		try {
			if( activityId == null || activityId.equals(0) ) {
				throw new BussinessException(230019);
			}
			
        	LOGGER.info("发现活动模块活动详情 >> activityId =" + activityId);
			return dealSuccess(findActivityService.activityDetail(activityId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现活动模块立即参与活动初始化
     * @param userId
     * @param activityId
     * @return
     */
	@GetMapping("/toJoinActivity")
    public ResponseObject toJoinActivity(@CurrentUser String userId, Integer activityId) {
		try {
			if( activityId == null || activityId.equals(0) ) {
				throw new BussinessException(230019);
			}
			
        	LOGGER.info("发现活动模块立即参与活动初始化 >> activityId =" + activityId + ",userId =" + userId);
			return dealSuccess(findActivityService.toJoinActivity(Integer.parseInt(userId), activityId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现活动模块立即参与活动
     * @param userId
     * @param activityId
     * @return
     */
	@GetMapping("/joinActivity")
    public ResponseObject joinActivity(@CurrentUser String userId, Integer activityId) {
		try {
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( activityId == null || activityId.equals(0) ) {
				throw new BussinessException(230019);
			}
			
        	LOGGER.info("发现活动模块立即参与活动 >> activityId =" + activityId + ",userId =" + userId);
        	findActivityService.joinActivity(Integer.parseInt(userId), activityId);
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}

}
