package com.biyouche.domain.apply.model;

import java.io.Serializable;
import java.util.List;

/**
 * 教练详情实体类
 * @author hucong
 *
 */
public class CoachDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6207308129801229307L;
	
	
	/*姓名**/
	private String name;
	
	/*评分**/
	private Double score;
	
	/*学员人数**/
	private Integer studentsNum;
	
	/*班级id**/
	private Integer classId;
	
	/*教练标签**/
	private String coachLabel;
	
	/*报名人数**/
	private Integer registrationNum;
	
	/*教练性别[0男;1女;]**/
	private Integer coachSex;

	/*教练年龄**/
	private Integer coachAge;
	
	/*教龄**/
	private Integer coachSchoolAge;
	
	/*准驾车型id**/
	private String driverTypeId;
	
	/*训练车型**/
	private String vehicleModel;
	
	/*训练车牌**/
	private String plateNumber;
	
	/*教练照片**/
	private String image;
	
	/*班级名称**/
	private String className;
	
	/*班级标签**/
	private String classLabel;
	
	/*学费**/
	private Double tuitionFee;
	
	/*报名人数**/
	private Integer classStudentsNum;

	/**
	 * 教练所带的班级
	 */
	private List<ClassDetail> classes;

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

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getCoachLabel() {
		return coachLabel;
	}

	public void setCoachLabel(String coachLabel) {
		this.coachLabel = coachLabel;
	}

	public Integer getRegistrationNum() {
		return registrationNum;
	}

	public void setRegistrationNum(Integer registrationNum) {
		this.registrationNum = registrationNum;
	}

	public Integer getCoachSex() {
		return coachSex;
	}

	public void setCoachSex(Integer coachSex) {
		this.coachSex = coachSex;
	}

	public Integer getCoachAge() {
		return coachAge;
	}

	public void setCoachAge(Integer coachAge) {
		this.coachAge = coachAge;
	}

	public Integer getCoachSchoolAge() {
		return coachSchoolAge;
	}

	public void setCoachSchoolAge(Integer coachSchoolAge) {
		this.coachSchoolAge = coachSchoolAge;
	}

	public String getDriverTypeId() {
		return driverTypeId;
	}

	public void setDriverTypeId(String driverTypeId) {
		this.driverTypeId = driverTypeId;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassLabel() {
		return classLabel;
	}

	public void setClassLabel(String classLabel) {
		this.classLabel = classLabel;
	}

	public Double getTuitionFee() {
		return tuitionFee;
	}

	public void setTuitionFee(Double tuitionFee) {
		this.tuitionFee = tuitionFee;
	}

	public Integer getClassStudentsNum() {
		return classStudentsNum;
	}

	public void setClassStudentsNum(Integer classStudentsNum) {
		this.classStudentsNum = classStudentsNum;
	}

	public List<ClassDetail> getClasses() {
		return classes;
	}

	public void setClasses(List<ClassDetail> classes) {
		this.classes = classes;
	}

	
}
