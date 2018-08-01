package com.biyouche.domain.apply;

import java.io.Serializable;

public class SchoolClassRelation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8811909879087605084L;
	
	/**
	 * 主键id
	 */
	private Integer id;
	
	/**
	 * 驾校id
	 */
	private Integer schoolId;
	
	/**
	 * 班级id
	 */
	private Integer classId;

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

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
