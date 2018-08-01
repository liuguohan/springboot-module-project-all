package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import com.biyouche.domain.apply.model.VipInsuranceModel;
import com.biyouche.mybatis.apply.VipInsuranceSqlProvider;

/**
 * VIP学车保险
 * @author lgh
 *
 */
public interface VipInsuranceMapper {

	/**
	 * vip方案展示
	 * @return
	 */
	@SelectProvider(type = VipInsuranceSqlProvider.class, method = "vipPlanList")
	@Results({
		@Result(property = "vipId", column = "vip_id" ),
		@Result(property = "vipLevel", column = "vip_level"),
		@Result(property = "vipName", column = "vip_name"),
		@Result(property = "vipFee", column = "vip_fee"),
		@Result(property = "retakeNumber", column = "retake_number"),
		@Result(property = "cash", column = "cash"),
		@Result(property = "fund", column = "fund")
	})
    List<VipInsuranceModel> vipPlanList();
	
}
