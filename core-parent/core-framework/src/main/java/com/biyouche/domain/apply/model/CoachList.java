package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 教练列表返回参数
 * @author hucong
 *
 */
public class CoachList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6207308129801229307L;
	
	/*主键**/
	private Integer id;
	
	/*姓名**/
	private String name;
	
	/*评分**/
	private Double score;
	
	/*学员人数**/
	private Integer studentsNum;
	
	/*教龄**/
	private Integer coachSchoolAge;
	
	/*教练照片**/
	private String image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}



	public Integer getStudentsNum() {
		return studentsNum;
	}

	public void setStudentsNum(Integer studentsNum) {
		this.studentsNum = studentsNum;
	}

	public Integer getCoachSchoolAge() {
		return coachSchoolAge;
	}

	public void setCoachSchoolAge(Integer coachSchoolAge) {
		this.coachSchoolAge = coachSchoolAge;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
