package com.biyouche.controller.apply;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.dao.apply.SchoolMapper;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.PraiseService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.annotation.LoginRequired;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.model.ClassList;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.PraiseService;

import java.util.Map;

/**
 * 评价接口
 * @author hucong
 *
 */
@RestController
@RequestMapping("/praise")
public class PraiseController extends BaseController{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PraiseController.class);


	@Autowired
	private PraiseService praiseService;


	/**
	 * 用户绑定驾校
	 * @author hucong
	 * @return
	 */
	@LoginRequired
	@PostMapping("/bindingSt")
	public ResponseObject bindingSt(String accessId,String school_id,String deviceType,@CurrentUser Integer user_id) {
		LOGGER.info("用户绑定驾校"+accessId+"--"+deviceType+"--"+school_id+"--"+user_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		int binding = praiseService.binding(accessId,school_id,deviceType,user_id);
    		dealSuccess.content.put("binding", binding);
    		return dealSuccess;
    	}catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 写点评
	 * @author hucong
	 * @return
	 */
	@LoginRequired
	@PostMapping("/writePraise")
	public ResponseObject writePraise(String accessId,String deviceType,@CurrentUser Integer user_id) {
		LOGGER.info("写点评"+accessId+"--"+deviceType+"--"+user_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		String schoolName = praiseService.writePraise(accessId,deviceType, user_id);
    		dealSuccess.content.put("school_name", schoolName);
    		return dealSuccess;
    	}catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 提交评价
	 * @author hucong
	 * @return
	 */
	//@LoginRequired
	@PostMapping("/submitPraise")
	public ResponseObject submitPraise(String accessId,String deviceType,String driver_speed,String environmental,String evaluation_content,String level,String school_id,String teaching_service,@CurrentUser Integer user_id) {
		LOGGER.info("提交评价"+accessId+"--"+deviceType+"--"+driver_speed+"--"+environmental+"--"+evaluation_content+"--"+level+"--"+school_id+"--"+teaching_service+"--"+user_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		int submitPraise = praiseService.submitPraise(accessId,deviceType,driver_speed,environmental,evaluation_content,level,school_id,teaching_service,user_id);
    		dealSuccess.content.put("submit_praise", submitPraise);
    		return dealSuccess;
    	}catch (Exception e) {
			return dealException(e);
		}
	}

	/**
	 * 驾校评论列表
	 * @param userId 当前登录用户id(可不登录)
	 * @param schoolId 驾校id
	 * @return
	 */
	@PostMapping("/evaluation_list")
	public ResponseObject evaluationList(@CurrentUser Integer userId,Integer schoolId){

		LOGGER.info("驾校评价列表请求参数:userId:" + userId + "school_id:" + schoolId );
		try{
			Map<String,Object> resultMap = praiseService.evaluationList(userId,schoolId);
			LOGGER.info("驾校评价列表响应参数:" + resultMap);
			return dealSuccess(resultMap);
		}catch (Exception e){
			return dealException(e);
		}
	}
	@PostMapping("/salute")
	public ResponseObject salute(@CurrentUser Integer userId,Integer id){

		LOGGER.info("驾校评价点赞请求参数:userId:" + userId + ",evaluation_id:" + id );
		try{
			praiseService.salute(userId,id);
			LOGGER.info("驾校评价点赞列表响应参数:" + dealSuccess().info);
			return dealSuccess();
		}catch (Exception e){
			return dealException(e);
		}
	}



}
