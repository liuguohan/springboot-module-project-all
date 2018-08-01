package com.biyouche.constants;

public class InsuranceConstant {

	//套餐状态 0 无效 1 有效(仅在替换更高套餐时变更值）
	public static final int ORDER_STATUS_INVALID = 0;//0 无效
	public static final int ORDER_STATUS_VALID = 1;//1 有效

	
	//支付状态 0 未支付 1 支付中 2 支付成功 3 支付失败
	public static final int PAY_STATUS_UNPAY = 0;//0 未支付
	public static final int PAY_STATUS_PAYING = 1;//1 支付中
	public static final int PAY_STATUS_PAIED = 2;//2 支付成功
	public static final int PAY_STATUS_PAY_FAIL = 3;//3 支付失败
	
	//订单过期时间（单位秒）
	public static final int ORDER_EXPIRE_TIME = 30 * 60;
	//套餐有效期（单位年）
	public static final int INSURANCE_EXPIRE_YEAR = 1;
}
