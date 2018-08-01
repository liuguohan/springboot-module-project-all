package com.biyouche.service;

import java.util.Map;

import com.biyouche.exception.BussinessException;

/**
 * 发现模块业务
 * @author lgh
 *
 */
public interface FindActivityService {

	/**
	 * 发现活动模块活动列表
	 * @param findId
	 * @return
	 */
	Map<String, Object> activityList(Integer findId);
	
	/**
	 * 发现活动模块活动详情
	 * 
	 * @param activityId
	 * @return
	 */
	Map<String, Object> activityDetail(Integer activityId);
	
	/**
	 * 发现活动模块立即参与活动初始化
	 * @param userId
	 * @param activityId
	 * @return
	 */
	Map<String, Object> toJoinActivity(Integer userId, Integer activityId);
	
	/**
	 * 发现活动模块立即参与活动
	 * 
	 * @param userId
	 * @param activityId
	 * @throws BussinessException
	 */
	void joinActivity(Integer userId, Integer activityId) throws BussinessException;
	
}
