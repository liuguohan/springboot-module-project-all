package com.biyouche.domain.apply;

import java.io.Serializable;

public class CoachClassRelation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8328675130984020887L;
	
    /**
     * 主键id
     */
    private Integer id;
	
	/**
	 * 教练ID
	 */
	private Integer coachId;
	
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

	public Integer getCoachId() {
		return coachId;
	}

	public void setCoachId(Integer coachId) {
		this.coachId = coachId;
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
