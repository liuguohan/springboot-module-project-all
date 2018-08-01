package com.biyouche.domain.apply.model;

import java.io.Serializable;

/**
 * 学车贷驾校名字列表
 * @author hucong
 *
 */
public class SchoolCreditName implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 169170242098173309L;

	/**
	 * 驾校id
	 */
	private Integer id;
	
	/**
	 * 驾校名字
	 */
	private String name;

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SchoolCreditName [id=" + id + ", name=" + name + "]";
	}

	
}
