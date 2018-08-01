package com.biyouche.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.constants.FindConstant;
import com.biyouche.dao.find.FindMapper;
import com.biyouche.domain.find.model.FindModel;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.service.FindService;

/**
 * 发现模块业务实现
 * @author lgh
 *
 */
@Service("findService")
public class FindServiceImpl implements FindService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindServiceImpl.class);
    
    @Autowired
    private FindMapper findMapper;

	@Override
	@Cacheable(key = RedisKeyPrefix.FIND_INITIALIZATION, expire = ExpireTime.ONE_HOUR)
	public Map<String, Object> findInitialization() {
		
		LOGGER.info("发现模块初始化查询库信息 ......");
		
		List<FindModel> findList = findMapper.findInitialization(FindConstant.DELSTATUS_VALID);
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("findList", findList);
		
		return result;
	}

   
}
