package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 班级详情
 * @author hucong
 *
 */
public class ClassDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885425562524477718L;
	
	/*主键**/
	private Integer id;
	
	/*班级名称**/
	private String className;
	
	/*学费**/
	private Double tuitionFee;
	
	/*班级标签**/
	private String classLabel;
	
	/*报名电话**/
	private String registrationPhone;
	
	/*班级简介**/
	private String classIntroduce;
	
	/*练车人数**/
	private Integer studentsNum;
	
	/*接送方式**/
	private String transportationWay;

	/*拿本时间(天)**/
	private Integer takeTime;
	
	/*练车时间**/
	private String practiceTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Double getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(Double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public String getClassLabel() {
		return classLabel;
	}

	public void setClassLabel(String classLabel) {
		this.classLabel = classLabel;
	}

	public String getRegistrationPhone() {
		return registrationPhone;
	}

	public void setRegistrationPhone(String registrationPhone) {
		this.registrationPhone = registrationPhone;
	}

	public String getClassIntroduce() {
		return classIntroduce;
	}

	public void setClassIntroduce(String classIntroduce) {
		this.classIntroduce = classIntroduce;
	}

	public Integer getStudentsNum() {
		return studentsNum;
	}

	public void setStudentsNum(Integer studentsNum) {
		this.studentsNum = studentsNum;
	}

	public String getTransportationWay() {
		return transportationWay;
	}

	public void setTransportationWay(String transportationWay) {
		this.transportationWay = transportationWay;
	}

	public Integer getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Integer takeTime) {
		this.takeTime = takeTime;
	}

	public String getPracticeTime() {
		return practiceTime;
	}

	public void setPracticeTime(String practiceTime) {
		this.practiceTime = practiceTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ClassDetail [id=" + id + ", className=" + className + ", tuitionFee=" + tuitionFee + ", classLabel="
				+ classLabel + ", registrationPhone=" + registrationPhone + ", classIntroduce=" + classIntroduce
				+ ", studentsNum=" + studentsNum + ", transportationWay=" + transportationWay + ", takeTime=" + takeTime
				+ ", practiceTime=" + practiceTime + "]";
	}
	
	
	
}
