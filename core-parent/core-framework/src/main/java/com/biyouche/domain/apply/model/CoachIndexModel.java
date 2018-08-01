package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 首页教练搜索数据
 * @author lgh
 *
 */
public class CoachIndexModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -6116149097659470357L;

	/**
	 * 教练ID
	 */
	private Integer coachId;
	
	/**
	 * 教练评分
	 */
	private double coachScore;
	
	/**
	 * 教练照片
	 */
	private String coachImage;
	
	/**
	 * 教练名
	 */
	private String coachName;
	
	/**
	 * 教练驾校名
	 */
	private String coachSchoolName;
	
	/**
	 * 教练学员人数
	 */
	private String coachStudentsNum;
	
	/**
	 * 教练推荐班级名
	 */
	private Integer coachClassFee;

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public double getCoachScore() {
		return coachScore;
	}

	public void setCoachScore(double coachScore) {
		this.coachScore = coachScore;
	}

	public String getCoachImage() {
		return coachImage;
	}

	public void setCoachImage(String coachImage) {
		this.coachImage = coachImage;
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

	public String getCoachStudentsNum() {
		return coachStudentsNum;
	}

	public void setCoachStudentsNum(String coachStudentsNum) {
		this.coachStudentsNum = coachStudentsNum;
	}

	public Integer getCoachClassFee() {
		return coachClassFee;
	}

	public void setCoachClassFee(Integer coachClassFee) {
		this.coachClassFee = coachClassFee;
	}

	@Override
	public String toString() {
		return "CoachIndexModel [coachId=" + coachId + ", coachScore=" + coachScore + ", coachImage=" + coachImage
				+ ", coachName=" + coachName + ", coachSchoolName=" + coachSchoolName + ", coachStudentsNum="
				+ coachStudentsNum + ", coachClassFee=" + coachClassFee + "]";
	}
	
	
}
