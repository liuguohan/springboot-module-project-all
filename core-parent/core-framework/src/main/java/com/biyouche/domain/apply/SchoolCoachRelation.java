package com.biyouche.domain.apply;

import java.io.Serializable;

public class SchoolCoachRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7811648434389170517L;
	
	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 驾校id
	 */
	private Integer schoolId;
	
	/**
	 * 教练id
	 */
	private Integer coachId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
