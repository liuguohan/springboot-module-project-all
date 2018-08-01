package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 拿本以后详情
 * @author hucong
 *
 */
public class NotbookAfterDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1064107652000543127L;

	
	/**
	 *标题 
	 */
	private String title;
	
	/**
	 *内容
	 */
	private String content;
	
	/**
	 * 发布时间
	 */
	private Integer createTime;

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

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
