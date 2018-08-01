package com.biyouche.service;

import java.util.Map;

/**
 * 首页-搜索驾校/教练
 * @author lgh
 *
 */
public interface IndexService {

	/**
	 * 获取搜索驾校/教练标签
	 * @return
	 */
	Map<String, Object> obtainCondition();
	
	/**
	 * 搜索驾校/教练列表
	 * @param params
	 * @return
	 */
	Map<String, Object> searchSchoolOrCoachList(Map<String, String> params);
	
	/**
	 * 即时搜索驾校/教练列表
	 * @param params
	 * @return
	 */
	Map<String, Object> quickSearchSchoolOrCoachList(Map<String, String> params);

	/**
	 * 报名模块首页
	 * @param city_name
	 * @return
	 */
    Map<String,Object> applyIndex(String lat,String lng);
}
