package com.biyouche.domain.find;

import java.io.Serializable;
import java.math.BigDecimal;

public class FindActivityOrder implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 6893145710064296831L;
	
	/**
	 * 发现活动订单ID
	 */
	private Integer orderId;
	
	/**
	 * 发现活动ID
	 */
	private Integer activityId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 活动费用
	 */
	private BigDecimal activityFee;
	
	/**
	 * 支付状态 0 未支付 1 支付中 2 支付成功 3 支付失败
	 */
	private Integer payStatus;
	
	/**
	 * 支付渠道 0 微信 1 支付宝
	 */
	private Integer payChannel;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;
	
	/**
	 * 支付成功时间
	 */
	private Integer successTime;
	
	/**
	 * 最初创建时间
	 */
	private Integer originTime;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public BigDecimal getActivityFee() {
		return activityFee;
	}

	public void setActivityFee(BigDecimal activityFee) {
		this.activityFee = activityFee;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(Integer payChannel) {
		this.payChannel = payChannel;
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

	public Integer getOriginTime() {
		return originTime;
	}

	public void setOriginTime(Integer originTime) {
		this.originTime = originTime;
	}

	@Override
	public String toString() {
		return "FindActivityOrder [orderId=" + orderId + ", activityId=" + activityId + ", userId=" + userId
				+ ", activityFee=" + activityFee + ", payStatus=" + payStatus + ", payChannel=" + payChannel
				+ ", createTime=" + createTime + ", successTime=" + successTime + ", originTime=" + originTime + "]";
	}

}
