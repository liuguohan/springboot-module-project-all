package com.biyouche.domain.find;

import java.io.Serializable;

/**
 * 发现社区回答表
 * @author lgh
 *
 */
public class FindCommunityReply implements Serializable {


	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -276160210963497559L;

	/**
	 * 发现社区回答ID
	 */
	private Integer replyId;
	
	/**
	 * 社区话题ID
	 */
	private Integer themeId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 社区回答内容
	 */
	private String replyContent;
	
	/**
	 * 点赞数
	 */
	private Integer effectiveNum;
	
	/**
	 * 踩数
	 */
	private Integer ineffectiveNum;
	
	/**
	 * 状态 0 启用 1 禁用
	 */
	private Integer delStatus;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Integer getEffectiveNum() {
		return effectiveNum;
	}

	public void setEffectiveNum(Integer effectiveNum) {
		this.effectiveNum = effectiveNum;
	}

	public Integer getIneffectiveNum() {
		return ineffectiveNum;
	}

	public void setIneffectiveNum(Integer ineffectiveNum) {
		this.ineffectiveNum = ineffectiveNum;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "FindCommunityReply [replyId=" + replyId + ", themeId=" + themeId + ", userId=" + userId
				+ ", replyContent=" + replyContent + ", effectiveNum=" + effectiveNum + ", ineffectiveNum="
				+ ineffectiveNum + ", delStatus=" + delStatus + ", createTime=" + createTime + "]";
	}

	
	
}
