package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 拿本标题
 * @author hucong
 *
 */
public class NotbookIco implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9146646507153436516L;

	/**
	 *主键ID 
	 */
	private Integer id;
	
	/**
	 *图标
	 */
	private String icon;
	
	/**
	 *图标名字 
	 */
	private String icon_name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon_name() {
		return icon_name;
	}

	public void setIcon_name(String icon_name) {
		this.icon_name = icon_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

}
