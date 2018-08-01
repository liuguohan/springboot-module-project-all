package com.biyouche.controller.find;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.FindService;


/**
 * 发现模块
 * @author lgh
 *
 */
@RequestMapping("/find")
@RestController
public class FindController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FindController.class);
	
	@Autowired
	private FindService findService;
	
	/**
     * 发现模块初始化
     * 
     * @return
     */
	@GetMapping("/findInitialization")
    public ResponseObject findInitialization() {
		try {
	        	
        	LOGGER.info("发现模块初始化...... ");
			return dealSuccess(findService.findInitialization());	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	
	

}
