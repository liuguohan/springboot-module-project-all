package com.biyouche.domain.apply;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 学车保障订单表
 * @author lgh
 *
 */
public class InsuranceOrder implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -7501654336439590632L;

	/**
	 * 学车保险订单ID
	 */
	private Integer orderId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 填写姓名
	 */
	private String userName;
	
	/**
	 * 填写手机号
	 */
	private String mobilePhone;
	
	/**
	 * 填写身份证
	 */
	private String cardNo;
	
	/**
	 * VIP等级
	 */
	private Integer vipLevel;
	
	/**
	 * VIP名称
	 */
	private String vipName;
	
	/**
	 * VIP保险套餐补考次数
	 */
	private Integer vipRetakeNumber;
	
	/**
	 * VIP保险套餐赔偿现金
	 */
	private BigDecimal vipCash;
	
	/**
	 * VIP保险套餐赔偿基金
	 */
	private BigDecimal vipFund;
	
	/**
	 * VIP费用
	 */
	private BigDecimal vipFee;
	
	/**
	 * 支付渠道 0 微信 1 支付宝 2 花呗分期
	 */
	private Integer payChannel;
	
	/**
	 * 支付状态 0 未支付 1 支付中 2 支付成功 3 支付失败
	 */
	private Integer payStatus;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;
	
	/**
	 * 支付成功时间
	 */
	private Integer successTime;
	
	/**
	 * 过期时间
	 */
	private Integer expireTime;
	
	/**
	 * 最初创建时间
	 */
	private Integer originTime;
	
	/**
	 * 套餐状态 0 无效 1 有效(仅在替换更高套餐时变更值）
	 */
	private Integer orderStatus;
	

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	public String getVipName() {
		return vipName;
	}

	public void setVipName(String vipName) {
		this.vipName = vipName;
	}

	public Integer getVipRetakeNumber() {
		return vipRetakeNumber;
	}

	public void setVipRetakeNumber(Integer vipRetakeNumber) {
		this.vipRetakeNumber = vipRetakeNumber;
	}

	public BigDecimal getVipCash() {
		return vipCash;
	}

	public void setVipCash(BigDecimal vipCash) {
		this.vipCash = vipCash;
	}

	public BigDecimal getVipFund() {
		return vipFund;
	}

	public void setVipFund(BigDecimal vipFund) {
		this.vipFund = vipFund;
	}

	public BigDecimal getVipFee() {
		return vipFee;
	}

	public void setVipFee(BigDecimal vipFee) {
		this.vipFee = vipFee;
	}

	public Integer getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getSuccessTime() {
		return successTime;
	}

	public void setSuccessTime(Integer successTime) {
		this.successTime = successTime;
	}

	public Integer getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Integer expireTime) {
		this.expireTime = expireTime;
	}

	public Integer getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Integer originTime) {
		this.originTime = originTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "InsuranceOrder [orderId=" + orderId + ", userId=" + userId + ", userName=" + userName + ", mobilePhone="
				+ mobilePhone + ", cardNo=" + cardNo + ", vipLevel=" + vipLevel + ", vipName=" + vipName
				+ ", vipRetakeNumber=" + vipRetakeNumber + ", vipCash=" + vipCash + ", vipFund=" + vipFund + ", vipFee="
				+ vipFee + ", payChannel=" + payChannel + ", payStatus=" + payStatus + ", createTime=" + createTime
				+ ", successTime=" + successTime + ", expireTime=" + expireTime + ", originTime=" + originTime
				+ ", orderStatus=" + orderStatus + "]";
	}



}
