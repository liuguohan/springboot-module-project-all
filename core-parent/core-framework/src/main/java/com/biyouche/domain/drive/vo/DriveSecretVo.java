package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 驾考秘笈列表
 * @author hc
 *
 */
public class DriveSecretVo  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8800834722633473306L;

	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 封面图
	 */
	private String image;
	
	/**
	 * 预览数
	 */
	private Integer look_num;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getLook_num() {
		return look_num;
	}

	public void setLook_num(Integer look_num) {
		this.look_num = look_num;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
