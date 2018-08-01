package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 拿本详情
 * @author hucong
 *
 */
public class NotbookDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5238496393422397748L;

	
	/**
	 *标题 
	 */
	private String title;
	
	/**
	 *内容 
	 */
	private String content;
	
	/**
	 *发布时间 
	 */
	private Integer create_time;
	
	/**
	 *浏览次数 
	 */
	private Integer look_num;

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
