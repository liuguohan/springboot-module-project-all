package com.biyouche.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biyouche.constants.InsuranceConstant;
import com.biyouche.dao.apply.InsuranceOrderMapper;
import com.biyouche.domain.apply.InsuranceOrder;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.InsuranceOrderService;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;

/**
 * 学车保险订单实现
 * @author lgh
 *
 */
@Service("insuranceOrderService")
public class InsuranceOrderServiceImpl implements InsuranceOrderService {

	@Autowired
	InsuranceOrderMapper insuranceOrderMapper;

	@Override
	public void doInsuranceOrder(InsuranceOrder order) throws BussinessException {
		
		//学车保险订单校验
		
		ValidatorUtils.insuranceOrderValid(order);
		
		//业务处理
		//1.如果是第一次购买学车保险，那么直接生成未支付订单，且订单有时效（例：30分钟）
		//2.如果是之前已有购买记录且套餐未过期，新购买的VIP学车保险套餐等级必须要大于之前购买的
		//3.如果之前订单还未支付且订单未过期且和当前选择的是相同等级套餐，则更新之前订单创建时间,不生成新订单,
		//  因此支付时以未过期且未支付成功，创建时间距离当前时间最近的订单为准,
		//4.如果之前已有购买记录且套餐未过期,选择更高套餐时，在回调时将之前使用的订单状态改为无效,新订单改为有效
		
		//查询当前用户学车保险订单记录
		List<InsuranceOrder> beforeOrderList = insuranceOrderMapper.selectInsuranceOrderByUserId(order.getUserId());
		
		
//		int vipBeforeLevelMax = 0;
//		int vipBeforeLevel = 0;
		boolean isContinue = true;
		boolean isHandle = true;
//		List<InsuranceOrder> beforeOrderByVIPLevelMAXList = new ArrayList<InsuranceOrder>();
		InsuranceOrder beforeChosenOrder = null;
		long currentTime = TimeUtils.getCurrentTimeStamp();
		int orderExpireTime = InsuranceConstant.ORDER_EXPIRE_TIME;
		order.setCreateTime(Integer.valueOf(String.valueOf(currentTime)));
		order.setExpireTime(order.getCreateTime() + orderExpireTime);
		
		if( ValidatorUtils.isNotEmpty(beforeOrderList) ) {
			
			//遍历之前该用户生成的所有订单
			for( int i = 0; i < beforeOrderList.size(); i++ ) {
				
				//判断是否有正在使用的套餐
				boolean paySuccess = beforeOrderList.get(i).getPayStatus() == InsuranceConstant.PAY_STATUS_PAIED;
				boolean unExpire = TimeUtils.subtractYear(beforeOrderList.get(i).getSuccessTime(), currentTime) <= InsuranceConstant.INSURANCE_EXPIRE_YEAR;
				boolean valid = beforeOrderList.get(i).getOrderStatus() == InsuranceConstant.ORDER_STATUS_VALID;
				if( paySuccess && unExpire && valid ) {
					isContinue = false;
				}
			}
			
			
			for( int i = 0; i < beforeOrderList.size(); i++ ) {
				
				//如果之前订单里同时含有支付成功未过期的不是更高VIP的套餐和已失效或订单已过期的更高VIP套餐
				//就要判断当前选择套餐是否大于支付成功未过期的VIP套餐,
				//如果是则允许生成订单，否则提示无法继续购买
				boolean paySuccess = beforeOrderList.get(i).getPayStatus() == InsuranceConstant.PAY_STATUS_PAIED;
				boolean unExpire = TimeUtils.subtractYear(beforeOrderList.get(i).getSuccessTime(), currentTime) <= InsuranceConstant.INSURANCE_EXPIRE_YEAR;
				boolean valid = beforeOrderList.get(i).getOrderStatus() == InsuranceConstant.ORDER_STATUS_VALID;
				//之前购买的更高的VIP等级套餐支付成功且套餐在有效期内则提示无法继续购买
				if( paySuccess && unExpire && valid && order.getVipLevel() <= beforeOrderList.get(i).getVipLevel() ) {
					throw new BussinessException(210008);
				}
				
				//如果有正在使用的套餐，不会出现以下未支付订单相同套餐的情况
				if( isContinue ) {
					Integer beforeOrderExpireTime = beforeOrderList.get(i).getExpireTime();
					boolean unpay = beforeOrderList.get(i).getPayStatus() == InsuranceConstant.PAY_STATUS_UNPAY;
					boolean unOrderExpire = (currentTime <= beforeOrderExpireTime )  && (currentTime >= (beforeOrderExpireTime - orderExpireTime));
					
					//如果套餐相同则不生成新订单，用之前未支付且未过期的订单,如果选择套餐小于旧订单，则生成选择套餐订单
					if( unpay && unOrderExpire && order.getVipLevel() == beforeOrderList.get(i).getVipLevel()) {
						isHandle = false;
						beforeChosenOrder = beforeOrderList.get(i);
						beforeChosenOrder.setCreateTime(Integer.valueOf(String.valueOf(currentTime)));
						beforeChosenOrder.setExpireTime(beforeChosenOrder.getCreateTime() + orderExpireTime);
					}
				}
				
					
//				vipBeforeLevel = beforeOrderList.get(i).getVipLevel();
//				vipBeforeLevelMax = Math.max(vipBeforeLevel, vipBeforeLevelMax);
			}
			
	
			
			/**
			//VIP等级最高的套餐放进列表
			for( int i = 0; i < beforeOrderList.size(); i++ ) {
				
				if( beforeOrderList.get(i).getVipLevel().equals(vipBeforeLevelMax) ) {
					beforeOrderByVIPLevelMAXList.add(beforeOrderList.get(i));
				}
			}
			
			int vipLevel = order.getVipLevel();
			if( vipLevel <= vipBeforeLevelMax ) {
				//如果当前选择套餐小于等于之前的最高VIP等级套餐，则进行遍历,处理相关业务
				for( InsuranceOrder beforeOrderByVIPLevelMAX : beforeOrderByVIPLevelMAXList ) {
					
					boolean paySuccess = beforeOrderByVIPLevelMAX.getPayStatus() == InsuranceConstant.PAY_STATUS_PAIED;
					boolean unExpire = TimeUtils.subtractYear(beforeOrderByVIPLevelMAX.getSuccessTime(), currentTime) <= InsuranceConstant.INSURANCE_EXPIRE_YEAR;
					boolean valid = beforeOrderByVIPLevelMAX.getOrderStatus() == InsuranceConstant.ORDER_STATUS_VALID;
					//之前购买的最高VIP等级套餐支付成功且套餐在有效期内则提示无法继续购买
					if( paySuccess && unExpire && valid ) {
						throw new BussinessException(210008);
					}
					
					//如果有正在使用的套餐，不会出现以下未支付订单相同套餐的情况
					if( isContinue ) {
						Integer beforeOrderExpireTime = beforeOrderByVIPLevelMAX.getExpireTime();
						boolean unpay = beforeOrderByVIPLevelMAX.getPayStatus() == InsuranceConstant.PAY_STATUS_UNPAY;
						boolean unOrderExpire = (currentTime <= beforeOrderExpireTime )  && (currentTime >= (beforeOrderExpireTime - orderExpireTime));
						
						//如果套餐相同则不生成新订单，用之前未支付且未过期的订单,如果选择套餐小于旧订单，则生成选择套餐订单
						if( unpay && unOrderExpire && vipLevel == beforeOrderByVIPLevelMAX.getVipLevel()) {
							isHandle = false;
							beforeChosenOrder = beforeOrderByVIPLevelMAX;
							beforeChosenOrder.setCreateTime(Integer.valueOf(String.valueOf(currentTime)));
							beforeChosenOrder.setExpireTime(beforeChosenOrder.getCreateTime() + orderExpireTime);
						}
					}	
					
				}
			}
			*/
		}
		
		
		int result = 0;
		if(isHandle) {
			//学车保险生成订单
			result = insuranceOrderMapper.insertOrder(order);
	
		}else {
			//更新订单
			result = insuranceOrderMapper.updateCreateTime(beforeChosenOrder);
		}
		if( result != 1) {
			throw new BussinessException(210007);
		}
		
		
	}
	
	@Override
	public Map<String, Object> insuranceOrderDetail(Integer userId) throws BussinessException {
		
		//查询当前用户学车保险订单记录
		List<InsuranceOrder> beforeOrderList = insuranceOrderMapper.selectInsuranceOrderByUserId(userId);
		
		long currentTime = TimeUtils.getCurrentTimeStamp();
		InsuranceOrder usableOrder = null;
		if( ValidatorUtils.isNotEmpty(beforeOrderList) ) {
			
			//遍历之前该用户生成的所有订单
			for( int i = 0; i < beforeOrderList.size(); i++ ) {
				
				//判断是否有正在使用的套餐
				boolean paySuccess = beforeOrderList.get(i).getPayStatus() == InsuranceConstant.PAY_STATUS_PAIED;
				boolean unExpire = TimeUtils.subtractYear(beforeOrderList.get(i).getSuccessTime(), currentTime) <= InsuranceConstant.INSURANCE_EXPIRE_YEAR;
				boolean valid = beforeOrderList.get(i).getOrderStatus().equals(InsuranceConstant.ORDER_STATUS_VALID);
				if( paySuccess && unExpire && valid ) {
					usableOrder = beforeOrderList.get(i);
				}
			}
		}
		
		if( usableOrder == null ) {
			throw new BussinessException(210013);
		}
		
		long successTime = Long.parseLong(String.valueOf(usableOrder.getSuccessTime()));
		long endTime = TimeUtils.addYear(successTime, 1);
		String cardNo = usableOrder.getCardNo();
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("vipFee", usableOrder.getVipFee() );
		result.put("startTime", TimeUtils.timeStampToDateStr(successTime) );
		result.put("endTime", TimeUtils.timeStampToDateStr(endTime) );
		result.put("userName", usableOrder.getUserName() );
		result.put("sex", ValidatorUtils.getSexByCardNo(cardNo) );
		result.put("age", ValidatorUtils.getAgeByCardNo(cardNo) );
		result.put("birthDay", ValidatorUtils.getBirthDayByCardNo(cardNo) );
		result.put("cardNo", ValidatorUtils.encryptCardNo(cardNo) );
		result.put("mobilePhone", usableOrder.getMobilePhone() );
		result.put("certNumber", null );//TODO
		result.put("vipName", usableOrder.getVipName() );
		result.put("vipRetakeNumber", usableOrder.getVipRetakeNumber() );
		result.put("vipCash", usableOrder.getVipCash() );
		result.put("vipFund", usableOrder.getVipFund() );
		return result;
	}
	
	@Override
	@Transactional
	public void insuranceOrderNotify() throws BussinessException {
		// TODO 
		
		//获取指定记录未过期且未支付成功，创建时间距离当前时间最近的订单
		InsuranceOrder order = insuranceOrderMapper.selectLastestUnpayInsuranceOrder();//TODO 参数待确定
		
		Integer userId = 0;
		//查询当前用户学车保险订单记录
		List<InsuranceOrder> beforeOrderList = insuranceOrderMapper.selectInsuranceOrderByUserId(userId);
		
		long currentTime = TimeUtils.getCurrentTimeStamp();
		InsuranceOrder usableOrder = null;
		if( ValidatorUtils.isNotEmpty(beforeOrderList) ) {
			
			//遍历之前该用户生成的所有订单
			for( int i = 0; i < beforeOrderList.size(); i++ ) {
				
				//判断是否有正在使用的套餐
				boolean paySuccess = beforeOrderList.get(i).getPayStatus() == InsuranceConstant.PAY_STATUS_PAIED;
				boolean unExpire = TimeUtils.subtractYear(beforeOrderList.get(i).getSuccessTime(), currentTime) <= InsuranceConstant.INSURANCE_EXPIRE_YEAR;
				boolean valid = beforeOrderList.get(i).getOrderStatus() == InsuranceConstant.ORDER_STATUS_VALID;
				if( paySuccess && unExpire && valid ) {
					usableOrder = beforeOrderList.get(i);
				}
			}
		}
		
		//如果有正在使用的学车保险套餐,那么将旧套餐状态改为无效
		if( usableOrder != null ) {
			usableOrder.setOrderStatus(InsuranceConstant.ORDER_STATUS_INVALID);
			//TODO 修改入库
		}
		
		//
		boolean result = true;
		if( result ) {
			order.setPayChannel(0);
			order.setSuccessTime(Integer.parseInt(String.valueOf(TimeUtils.getCurrentTimeStamp())));
			order.setPayStatus(InsuranceConstant.PAY_STATUS_PAIED);
			order.setOrderStatus(InsuranceConstant.ORDER_STATUS_VALID);
		}else {
			order.setPayStatus(InsuranceConstant.PAY_STATUS_PAY_FAIL);
		}
		//TODO 修改入库
		
	}

	
	public static void main(String[] args) {
		
		
//		System.out.println(Math.max(2, 3));

		//1532152818
		//1532154618
//		long currentTime = TimeUtils.getCurrentTimeStamp();
//		System.out.println(Integer.valueOf(String.valueOf(currentTime)));
//		System.out.println(Integer.valueOf(String.valueOf(currentTime)) + InsuranceConstant.ORDER_EXPIRE_TIME);
//		System.out.println(Math.abs(TimeUtils.subtractSecond(1700,0)));
		
//		long currentTime = 2000;
//		long beforeOrderExpireTime = 3600;
//		boolean unOrderExpire = (currentTime <= beforeOrderExpireTime )  && (currentTime >= (beforeOrderExpireTime - InsuranceConstant.ORDER_EXPIRE_TIME));
//		System.out.println(unOrderExpire);
		
	}
	
		

	
	
}
