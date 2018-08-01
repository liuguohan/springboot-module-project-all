package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.apply.VipInsuranceMapper;
import com.biyouche.domain.apply.model.VipInsuranceModel;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.service.VIPInsuranceService;

/**
 * 学车保险实现
 * @author lgh
 *
 */
@Service("vipInsuranceService")
public class VIPInsuranceServiceImpl implements VIPInsuranceService {

	@Autowired
	VipInsuranceMapper vipInsuranceMapper;

	
	@Override
	@Cacheable(key = RedisKeyPrefix.VIP_INSURANCE_LIST, expire = ExpireTime.FIVE_MIN)
	public List<VipInsuranceModel> vipInsuranceList() {

		List<VipInsuranceModel> vipInsuranceList = vipInsuranceMapper.vipPlanList();

		return vipInsuranceList;
	}
	
}
