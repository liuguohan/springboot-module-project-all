package com.biyouche.controller.area;

import java.util.List;

import com.biyouche.service.area.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.domain.area.Area;
import com.biyouche.response.ResponseObject;

/**
 * @author hucong
 *
 */
@RestController
@RequestMapping("/area")
public class AreaController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AreaController.class);
	
	@Autowired
	private AreaService areaService;
	
   /**
    * 获取地区编码
	* @author hucong
	* @param 
    * @return Map
    * @throws Exception 
    */
	@PostMapping("/areaList")
	public ResponseObject subArea(@RequestBody String content) {
		LOGGER.info("获取地区编码"+content);
    	try {
    		ResponseObject dealSuccess = dealSuccess();
    		List<Area> areas = areaService.subArea(content);
    		dealSuccess.content.put("area_list", areas);
    		return dealSuccess;
    	        
    	}catch (Exception e) {
			return dealException(e);
		}
	}

}
