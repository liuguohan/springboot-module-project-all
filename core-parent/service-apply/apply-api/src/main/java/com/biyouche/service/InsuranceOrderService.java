package com.biyouche.service;

import java.util.Map;

import com.biyouche.domain.apply.InsuranceOrder;
import com.biyouche.exception.BussinessException;


/**
 * 学车保险订单业务
 * @author lgh
 *
 */
public interface InsuranceOrderService {

	/**
	 * 学车保险订单生成
	 * @param order
	 * @return
	 */
	void doInsuranceOrder(InsuranceOrder order) throws BussinessException;
	
	/**
	 * 学车保险订单详情
	 * @param userId
	 * @return
	 * @throws BussinessException
	 */
	Map<String, Object> insuranceOrderDetail(Integer userId) throws BussinessException;
	
	/**
	 * 学车保险异步回调
	 * @throws BussinessException
	 */
	void insuranceOrderNotify() throws BussinessException;
	
}
