package com.biyouche.domain.user;

import java.io.Serializable;

/**
 * 用户驾考需求
 * @author hucong
 *
 */
public class UserSurvey implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4063611724930870301L;
	
	/**
	 * 调研表id
	 */
	private Integer surveyId;
	
	/**
	 * 用户id
	 */
	private Integer userId;
	
	/**
	 * 性别[0: 男 1:女]
	 */
	private Integer sex;
	
	/**
	 * 是否完成驾校报名[0:已经报名驾校 1:未报名驾校]
	 */
	private Integer applyStatus;
	
	/**
	 * 驾考目的[0:计划买车 1:有车没本 2:纯为拿本]
	 */
	private Integer driverPurpose;
	
	/**
	 * 驾驶证类型[0:C1 1:C2]
	 */
	private Integer ddriverType;

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(Integer applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Integer getDriverPurpose() {
		return driverPurpose;
	}

	public void setDriverPurpose(Integer driverPurpose) {
		this.driverPurpose = driverPurpose;
	}

	public Integer getDdriverType() {
		return ddriverType;
	}

	public void setDdriverType(Integer ddriverType) {
		this.ddriverType = ddriverType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
