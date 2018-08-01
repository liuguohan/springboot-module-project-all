package com.biyouche.domain.find.model;

import java.io.Serializable;

/**
 * 发现资讯详情模块
 * @author lgh
 *
 */
public class FindInfoDetailModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1138723175721532260L;

	/**
	 * 发现资讯ID
	 */
	private Integer infoId;
	
	/**
	 * 文章标题
	 */
	private String infoTitle;
	
	/**
	 * 文章内容
	 */
	private String infoContent;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;
	
	/**
	 * 创建时间格式化
	 */
	private String createTimeStr;

	public Integer getInfoId() {
		return infoId;
	}

	public void setInfoId(Integer infoId) {
		this.infoId = infoId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoContent() {
		return infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	@Override
	public String toString() {
		return "FindInfoDetailModel [infoId=" + infoId + ", infoTitle=" + infoTitle + ", infoContent=" + infoContent
				+ ", createTime=" + createTime + ", createTimeStr=" + createTimeStr + "]";
	}
	
	
	
}
