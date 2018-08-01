package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 驾考秘笈详情
 * @author hc
 *
 */
public class DriveSecretDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3147941718993003615L;

	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 发布时间
	 */
	private Integer create_time;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Integer create_time) {
		this.create_time = create_time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
