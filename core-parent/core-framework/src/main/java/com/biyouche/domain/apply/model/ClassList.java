package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 驾校班级列表
 * @author hucong
 *
 */
public class ClassList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7885425562524477718L;

	/*班级id**/
	private Integer id;
	
	/*班级名称**/
	private String className;
	
	/*班级标签**/
	private String classLabel;
	
	/*班级活动**/
	private String classActive;

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

	public String getClassLabel() {
		return classLabel;
	}

	public void setClassLabel(String classLabel) {
		this.classLabel = classLabel;
	}

	public String getClassActive() {
		return classActive;
	}

	public void setClassActive(String classActive) {
		this.classActive = classActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
