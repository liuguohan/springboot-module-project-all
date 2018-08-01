package com.biyouche.domain.find;

import java.io.Serializable;

/**
 * 发现社区话题表
 * @author lgh
 *
 */
public class FindCommunityTheme implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -1179650281102479451L;

	/**
	 * 社区话题ID
	 */
	private Integer themeId;
	
	/**
	 * 发现ID
	 */
	private Integer findId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 话题类型 0 普通 1 精选
	 */
	private Integer themeType;
	
	/**
	 * 话题标题
	 */
	private String themeTitle;
	
	/**
	 * 话题内容
	 */
	private String themeContent;
	
	/**
	 * 标签数组
	 */
	private String themeLabel;
	
	/**
	 * 回答数
	 */
	private Integer replyNum;
	
	/**
	 * 状态 0 启用 1 禁用
	 */
	private Integer delStatus;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public Integer getFindId() {
		return findId;
	}

	public void setFindId(Integer findId) {
		this.findId = findId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getThemeType() {
		return themeType;
	}

	public void setThemeType(Integer themeType) {
		this.themeType = themeType;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public String getThemeContent() {
		return themeContent;
	}

	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}

	public String getThemeLabel() {
		return themeLabel;
	}

	public void setThemeLabel(String themeLabel) {
		this.themeLabel = themeLabel;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
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
		return "FindCommunityTheme [themeId=" + themeId + ", findId=" + findId + ", userId=" + userId + ", themeType="
				+ themeType + ", themeTitle=" + themeTitle + ", themeContent=" + themeContent + ", themeLabel="
				+ themeLabel + ", replyNum=" + replyNum + ", delStatus=" + delStatus + ", createTime=" + createTime
				+ "]";
	}

	
}
