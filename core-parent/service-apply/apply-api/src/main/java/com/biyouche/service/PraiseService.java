package com.biyouche.service;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.exception.BussinessException;

import java.util.Map;

/**
 * 评价服务
 * @author hucong
 *
 */
public interface PraiseService {

	/**
	 * 驾校评论列表
	 * @param userId
	 * @param schoolId
	 * @return
	 */
    Map<String,Object> evaluationList(Integer userId, Integer schoolId);
	/**
	 * 用户绑定驾校
	 * @param user_id
	 * @return
	 */
	int binding(String accessId,String school_id,String deviceType,Integer user_id);

	/**
	 * 写点评
	 * @param content
	 * @param user_id
	 * @return String
	 */
	String writePraise(String accessId,String deviceType,Integer user_id) throws BussinessException;

	/**
	 * 提交评价
	 * @param content
	 * @param user_id
	 * @return
	 */
	int submitPraise(String accessId,String deviceType,String driver_speed,String environmental,String evaluation_content,String level,String school_id,String teaching_service,Integer user_id);

	void salute(Integer userId, Integer id) throws BussinessException;
}
