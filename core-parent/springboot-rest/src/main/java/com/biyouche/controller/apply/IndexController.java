package com.biyouche.controller.apply;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.IndexService;

/**
 * 首页搜索
 * @author lgh
 *
 */
@RequestMapping("/index")
@RestController
public class IndexController extends BaseController {

	private final static Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private IndexService indexService;
	
	/**
     * 搜索驾校/教练初始化
     * 
     * @author lgh
     * @return
     */
	@GetMapping("/toSearchSchoolOrCoach")
    public ResponseObject toSearchSchoolOrCoach() {
		try {
	        	
        	LOGGER.info("搜索驾校/教练初始化...... ");
			return dealSuccess(indexService.obtainCondition());	
		} catch (Exception e) {
			return dealException(e);
		}
		
	}
	
	/**
     * 搜索驾校/教练
     * 
     * @author lgh
	 * @param cityCode
	 * @param searchName
	 * @param labelType
	 * @return
	 */
	@GetMapping("/searchSchoolOrCoach")
    public ResponseObject searchSchoolOrCoach(String cityCode, String searchName, String labelType) {
		 try {
        	
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("cityCode", cityCode);
        	params.put("searchName", searchName);
        	params.put("labelType", labelType);

        	LOGGER.info("搜索驾校/教练请求参数内容: " + params.toString());
			return dealSuccess(indexService.searchSchoolOrCoachList(params));	
		} catch (Exception e) {
			return dealException(e);
		}
		
	}
	
	/**
	 * 即时搜索驾校/教练
	 * 
	 * @author lgh
	 * @param cityCode
	 * @param searchName
	 * @return
	 */
	@GetMapping("/quickSearchSchoolOrCoach")
    public ResponseObject quickSearchSchoolOrCoach(String cityCode, String searchName) {
		 try {
        	
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("cityCode", cityCode);
        	params.put("searchName", searchName);

        	LOGGER.info("即时搜索驾校/教练请求参数内容: " + params.toString());
			return dealSuccess(indexService.quickSearchSchoolOrCoachList(params));	
		} catch (Exception e) {
			return dealException(e);
		}
		
	}

	/**
	 * 报名首页
	 * @param lat 纬度
	 * @param lng 经度
	 * @return
	 */
	@PostMapping("applyIndex")
	public ResponseObject index(String lat,String lng){
		try{
			Map<String,Object> resultMap = indexService.applyIndex(lat,lng);
			return dealSuccess(resultMap);
		}catch (Exception e){
			return dealException(e);
		}
	}
	
}
