package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 首页教练即时搜索数据
 * @author lgh
 *
 */
public class QuickCoachIndexModel implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2478852116973538198L;

	/**
	 * 教练ID
	 */
	private Integer coachId;
	
	/**
	 * 教练名
	 */
	private String coachName;
	
	/**
	 * 教练驾校名
	 */
	private String coachSchoolName;
	

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public String getCoachSchoolName() {
		return coachSchoolName;
	}

	public void setCoachSchoolName(String coachSchoolName) {
		this.coachSchoolName = coachSchoolName;
	}

	@Override
	public String toString() {
		return "QuickCoachIndexModel [coachId=" + coachId + ", coachName=" + coachName + ", coachSchoolName="
				+ coachSchoolName + "]";
	}
	
	
}
