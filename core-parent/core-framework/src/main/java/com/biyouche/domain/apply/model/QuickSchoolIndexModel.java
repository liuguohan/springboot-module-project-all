package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 首页驾校即时搜索数据
 * @author lgh
 *
 */
public class QuickSchoolIndexModel implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3712153982542049211L;

	/**
	 * 驾校ID
	 */
	private Integer schoolId;
	
	/**
	 * 驾校名
	 */
	private String schoolName;
	

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	@Override
	public String toString() {
		return "QuickSchoolIndexModel [schoolId=" + schoolId + ", schoolName=" + schoolName + "]";
	}
	
	
	
}
