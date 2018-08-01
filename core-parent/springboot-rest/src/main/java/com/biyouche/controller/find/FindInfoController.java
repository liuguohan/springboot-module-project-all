package com.biyouche.controller.find;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.controller.BaseController;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.FindInfoService;

/**
 * 发现资讯模块
 * @author lgh
 *
 */
@RequestMapping("/find/info")
@RestController
public class FindInfoController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FindInfoController.class);

	@Autowired
	private FindInfoService infoService;
	
	/**
     * 发现资讯子模块文章列表
     * @param findId
     * @return
     */
	@GetMapping("/submoduleArticleList")
    public ResponseObject submoduleArticleList(Integer findId) {
		try {
	        
			if( findId == null || findId.equals(0) ) {
				throw new BussinessException(230000);
			}
			
        	LOGGER.info("发现资讯子模块文章列表 >> findId =" + findId);
			return dealSuccess(infoService.submoduleArticleList(findId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
	 * 发现资讯子模块文章详情
	 * @param infoId
	 * @return
	 */
	@GetMapping("/submoduleArticleDetail")
    public ResponseObject submoduleArticleDetail(Integer infoId) {
		try {
	        
			if( infoId == null || infoId.equals(0) ) {
				throw new BussinessException(230001);
			}
			
        	LOGGER.info("发现资讯子模块文章详情 >> infoId =" + infoId);
			return dealSuccess(infoService.submoduleArticleDetail(infoId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
}
