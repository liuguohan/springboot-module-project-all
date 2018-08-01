package com.biyouche.service;

import java.util.Map;

import com.biyouche.exception.BussinessException;

/**
 * 发现资讯模块业务
 * @author lgh
 *
 */
public interface FindInfoService {

	/**
	 * 发现资讯子模块文章列表
	 * @param findId
	 * @return
	 */
	Map<String, Object> submoduleArticleList(Integer findId);
	
	/**
	 * 发现资讯子模块文章详情
	 * @param infoId
	 * @return
	 */
	Map<String, Object> submoduleArticleDetail(Integer infoId) throws BussinessException;
	
}
