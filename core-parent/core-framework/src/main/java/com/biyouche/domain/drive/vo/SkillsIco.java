package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 技巧标题
 * @author hc
 *
 */
public class SkillsIco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7589762582855385959L;
	
	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 图标名字
	 */
	private String icon_name;
	
	/**
	 * 图标标签
	 */
	private String icon_label;

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

	public String getIcon_label() {
		return icon_label;
	}

	public void setIcon_label(String icon_label) {
		this.icon_label = icon_label;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
