package com.biyouche.controller.apply;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.IntroductionService;
import com.biyouche.utils.ValidatorUtils;

/**
 * 驾校详情简介
 * @author lgh
 *
 */
@RestController
@RequestMapping("/introduce")
public class IntroductionController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(IntroductionController.class);
	
    @Autowired
    private IntroductionService introductionService;
    
    /**
     * 驾校详情简介
     * 
     * @param schoolId
     * @author lgh
     * @return
     */
	@GetMapping("/detail")
    public ResponseObject detail(String schoolId) {
		 try {
	        	
        	if( ValidatorUtils.isEmpty(schoolId) ) {
        		throw new BussinessException(210020);
        	}
        	
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("schoolId", schoolId);

        	LOGGER.info("驾校详情简介请求参数内容: " + params.toString());
			return dealSuccess(introductionService.detail(params));			
		} catch (Exception e) {
			return dealException(e);
		}
		
	}
	
	
	
}
