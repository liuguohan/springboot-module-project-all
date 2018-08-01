package com.biyouche.domain.area;

import java.io.Serializable;

/**
  * 省市区库
  * @author hucong
  *
  */
public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7520669607360587564L;
	
	/**
	 * 地区编号
	 */
	private String area_no;
	
	/**
	 * 当前名称
	 */
	private String area_name;
	

	public String getArea_no() {
		return area_no;
	}

	public void setArea_no(String area_no) {
		this.area_no = area_no;
	}

	public String getArea_name() {
		return area_name;
	}

	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}

	
	

}
