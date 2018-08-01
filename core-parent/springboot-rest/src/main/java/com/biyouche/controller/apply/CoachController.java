package com.biyouche.controller.apply;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.model.CoachDetail;
import com.biyouche.domain.apply.model.CoachList;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.CoachService;

/**
 * @author hucong
 *
 */
@RestController
@RequestMapping("/coach")
public class CoachController extends BaseController{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CoachController.class);
	
	@Autowired
	private CoachService coachService;
	
	 
	/**
	 * 获取驾校的教练列表
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/coachList")
	public ResponseObject coachList(String school_id) {
		LOGGER.info("获取驾校的教练列表"+school_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<CoachList> coachList = coachService.coachList(school_id);
    		dealSuccess.content.put("coach_list", coachList);
    		return dealSuccess;   
    	}catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
	 * 获取驾校的教练列表
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/coachDetail")
	public ResponseObject coachDetail(String coach_id) {
		LOGGER.info("教练详情"+coach_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		CoachDetail coachDetail = coachService.coachDetail(coach_id);
    		dealSuccess.content.put("coach_detail", coachDetail);
    		return dealSuccess;    
    	}catch (Exception e) {
			return dealException(e);
		}
	}

}
