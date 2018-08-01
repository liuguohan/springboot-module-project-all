package com.biyouche.constants;

/**
 * 发现模块常量
 * @author lgh
 *
 */
public class FindConstant {

	//状态 0 启用 1 禁用
	public final static int DELSTATUS_VALID = 0;//有效
	public final static int DELSTATUS_INVALID = 1;//无效
	
	//话题类型 0 普通 1 精选
	public final static int THEMETYPE_NORMAL = 0;//普通
	public final static int THEMETYPE_SPECIAL = 1;//精选
	
	//支付状态 0 未支付 1 支付中 2 支付成功 3 支付失败
	public static final int PAY_STATUS_UNPAY = 0;//0 未支付
	public static final int PAY_STATUS_PAYING = 1;//1 支付中
	public static final int PAY_STATUS_PAIED = 2;//2 支付成功
	public static final int PAY_STATUS_PAY_FAIL = 3;//3 支付失败
	
}
