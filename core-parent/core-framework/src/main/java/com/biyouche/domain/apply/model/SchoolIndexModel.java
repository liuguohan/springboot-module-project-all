package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 首页驾校搜索数据
 * @author lgh
 *
 */
public class SchoolIndexModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7601331917054869600L;

	/**
	 * 驾校ID
	 */
	private Integer schoolId;
	
	/**
	 * 驾校评分
	 */
	private double schoolScore;
	
	/**
	 * 驾校照片
	 */
	private String schoolImage;
	
	/**
	 * 驾校名
	 */
	private String schoolName;
	
	/**
	 * 驾校区
	 */
	private String schoolAreaName;
	
	/**
	 * 驾校推荐班级名
	 */
	private String schoolClassName;
	
	/**
	 * 驾校推荐班级学费
	 */
	private Integer schoolClassFee;

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public double getSchoolScore() {
		return schoolScore;
	}

	public void setSchoolScore(double schoolScore) {
		this.schoolScore = schoolScore;
	}

	public String getSchoolImage() {
		return schoolImage;
	}

	public void setSchoolImage(String schoolImage) {
		this.schoolImage = schoolImage;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAreaName() {
		return schoolAreaName;
	}

	public void setSchoolAreaName(String schoolAreaName) {
		this.schoolAreaName = schoolAreaName;
	}

	public String getSchoolClassName() {
		return schoolClassName;
	}

	public void setSchoolClassName(String schoolClassName) {
		this.schoolClassName = schoolClassName;
	}

	public Integer getSchoolClassFee() {
		return schoolClassFee;
	}

	public void setSchoolClassFee(Integer schoolClassFee) {
		this.schoolClassFee = schoolClassFee;
	}

	@Override
	public String toString() {
		return "SchoolIndexModel [schoolId=" + schoolId + ", schoolScore=" + schoolScore + ", schoolImage="
				+ schoolImage + ", schoolName=" + schoolName + ", schoolAreaName=" + schoolAreaName
				+ ", schoolClassName=" + schoolClassName + ", schoolClassFee=" + schoolClassFee + "]";
	}
	
	
	
}
