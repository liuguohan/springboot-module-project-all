package com.biyouche.service;

import java.util.Map;

/**
 * 驾校详情简介
 * @author lgh
 *
 */
public interface IntroductionService {

	/**
	 * 驾校详情简介
	 * @param params
	 */
	Map<String, Object> detail(Map<String, String> params);
	
}
