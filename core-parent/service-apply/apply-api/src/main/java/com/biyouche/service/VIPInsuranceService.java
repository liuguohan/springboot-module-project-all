package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.apply.model.VipInsuranceModel;

/**
 * VIP保险套餐业务
 * @author lgh
 *
 */
public interface VIPInsuranceService {

	/**
	 * VIP学车保险列表
	 * @return
	 */
	List<VipInsuranceModel> vipInsuranceList();
	
}
