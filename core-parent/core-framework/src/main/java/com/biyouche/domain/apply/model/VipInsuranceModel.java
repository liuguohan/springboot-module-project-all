package com.biyouche.domain.apply.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * VIP保险套餐
 * @author lgh
 *
 */
public class VipInsuranceModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4630673214822404397L;
	
	/**
	 * 会员ID
	 */
	private Integer vipId;
	
	/**
	 * 会员等级
	 */
	private Integer vipLevel;
	
	/**
	 * 会员名称
	 */
	private String vipName;
	
	/**
	 * 会员支付费用
	 */
	private BigDecimal vipFee;
	
	/**
	 * 补考次数
	 */
	private Integer retakeNumber;
	
	/**
	 * 现金
	 */
	private BigDecimal cash;
	
	/**
	 * 购车基金
	 */
	private BigDecimal fund;

	public Integer getVipId() {
		return vipId;
	}

	public void setVipId(Integer vipId) {
		this.vipId = vipId;
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

	public BigDecimal getVipFee() {
		return vipFee;
	}

	public void setVipFee(BigDecimal vipFee) {
		this.vipFee = vipFee;
	}

	public Integer getRetakeNumber() {
		return retakeNumber;
	}

	public void setRetakeNumber(Integer retakeNumber) {
		this.retakeNumber = retakeNumber;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public BigDecimal getFund() {
		return fund;
	}

	public void setFund(BigDecimal fund) {
		this.fund = fund;
	}

	@Override
	public String toString() {
		return "VipInsuranceModel [vipId=" + vipId + ", vipLevel=" + vipLevel + ", vipName=" + vipName + ", vipFee="
				+ vipFee + ", retakeNumber=" + retakeNumber + ", cash=" + cash + ", fund=" + fund + "]";
	}
	
	

}
