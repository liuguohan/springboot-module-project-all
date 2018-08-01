package com.biyouche.controller.apply;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.apply.model.SchoolData;
import com.biyouche.domain.apply.model.SchoolDetail;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.SchoolService;

/**
 * 驾校请求接口
 * @author hucong
 *
 */
@RestController
@RequestMapping("/school")
public class SchoolController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SchoolController.class);
	
	@Autowired
	private SchoolService schoolService;
	
	/**
	 * 获取驾校列表
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/schoolList")
	public ResponseObject schoolList(String lat,String lng,String select_type) {
		LOGGER.info("获取驾校列表"+lat+"--"+lng+"--"+select_type);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<SchoolData> schoolList = schoolService.schoolList(lat,lng,select_type);
    		dealSuccess.content.put("school_list", schoolList);
    		return dealSuccess;   
    	}catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
	 * 获取驾校详情
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/schoolDetail")
	public ResponseObject coachDetail(String lat,String lng,String school_id) {
		LOGGER.info("驾校详情"+lat+"--"+lng+"--"+school_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		SchoolDetail schoolDetail = schoolService.schoolDetail(lat,lng,school_id);
    		dealSuccess.content.put("school_detail", schoolDetail);
    		return dealSuccess;    
    	}catch (Exception e) {
			return dealException(e);
		}
	}

	
	/**
	 * 获取学车贷驾校列表
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/schoolCreditList")
	public ResponseObject schoolCreditList(String lat,String lng) {
		LOGGER.info("学车贷驾校列表"+lat+"--"+lng);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<SchoolData> schoolCreditList = schoolService.schoolCreditList(lat,lng);
    		dealSuccess.content.put("school_credit_list", schoolCreditList);
    		return dealSuccess;    
    	}catch (Exception e) {
			return dealException(e);
		}
		
	}
	
	
	/**
	 * 获取学车贷驾校名字
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/schoolCreditNmae")
	public ResponseObject schoolCreditNmae(String school_name) {
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<Map<String, Object>> schoolCreditName = schoolService.schoolCreditName(school_name);
    		dealSuccess.content.put("school_credit_name", schoolCreditName);
    		return dealSuccess;    
    	}catch (Exception e) {
			return dealException(e);
		}
	}
}
