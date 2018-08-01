package com.biyouche.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.constants.Constants;
import com.biyouche.dao.apply.SchoolIntroductionMapper;
import com.biyouche.domain.apply.SchoolIntroduction;
import com.biyouche.service.IntroductionService;

/**
 * 驾校详情简介实现
 * @author lgh
 *
 */
@Service("introductionService")
public class IntroductionServiceImpl implements IntroductionService {

	@Autowired
	private SchoolIntroductionMapper schoolIntroductionMapper;
	
	@Override
	public Map<String, Object> detail(Map<String, String> params) {
		
		int schoolId = Integer.parseInt(String.valueOf(params.get("schoolId")));
		
		SchoolIntroduction introduce = schoolIntroductionMapper.detail(schoolId, Constants.DEL_STATUS_NO);
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("introduce", introduce);
		
		return result;
	}

}
