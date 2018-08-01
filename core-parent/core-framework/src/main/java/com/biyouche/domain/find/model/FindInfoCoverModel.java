package com.biyouche.domain.find.model;

import java.io.Serializable;

/**
 * 发现资讯封面模块
 * @author lgh
 *
 */
public class FindInfoCoverModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3029898681518017737L;

	/**
	 * 发现资讯ID
	 */
	private Integer infoId;
	
	/**
	 * 发现ID
	 */
	private Integer findId;
	
	/**
	 * 文章标题
	 */
	private String infoTitle;
	
	/**
	 * 封面图片地址
	 */
	private String infoCover;
	
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

	public Integer getFindId() {
		return findId;
	}

	public void setFindId(Integer findId) {
		this.findId = findId;
	}

	public String getInfoTitle() {
		return infoTitle;
	}

	public void setInfoTitle(String infoTitle) {
		this.infoTitle = infoTitle;
	}

	public String getInfoCover() {
		return infoCover;
	}

	public void setInfoCover(String infoCover) {
		this.infoCover = infoCover;
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
		return "FindInfoCoverModel [infoId=" + infoId + ", findId=" + findId + ", infoTitle=" + infoTitle
				+ ", infoCover=" + infoCover + ", createTime=" + createTime + ", createTimeStr=" + createTimeStr + "]";
	}
	
	
	
}
