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
import com.biyouche.domain.apply.model.ClassDetail;
import com.biyouche.domain.apply.model.ClassList;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.ClassService;

/**
 * 驾校班级列表
 * @author hucong
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(CoachController.class);
	
	@Autowired
	private ClassService classService;
	
	/**
	 * 获取驾校的班级列表
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/classList")
	public ResponseObject classList(String school_id) {
		LOGGER.info("获取驾校的班级列表"+school_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<ClassList> classList = classService.classList(school_id);
    		dealSuccess.content.put("class_list", classList);
    		return dealSuccess;   
    	}catch (Exception e) {
			return dealException(e);
		}
		
	}
	
	/**
	 * 获取班级详情
	 * @author hucong
	 * @return  Map
	 */
	@PostMapping("/classDetail")
	public ResponseObject classDetail(String class_id) {
		LOGGER.info("获取驾校的班级列表"+class_id);
		try {
    		ResponseObject dealSuccess = dealSuccess();
    		ClassDetail classDetail = classService.classDetail(class_id);
    		dealSuccess.content.put("class_Detail", classDetail);
    		return dealSuccess;   
    	}catch (Exception e) {
			return dealException(e);
		}
		
	}

}
