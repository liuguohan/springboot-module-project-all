package com.biyouche.domain.find.model;

import java.io.Serializable;

/**
 * 个人中心-我的发布
 * @author lgh
 *
 */
public class UserTopicPublishModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 2731327533077081904L;

	/**
	 * 社区话题ID
	 */
	private Integer themeId;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 用户头像
	 */
	private String avatarUrl;
	
	/**
	 * 话题标题
	 */
	private String themeTitle;
	
	/**
	 * 话题内容
	 */
	private String themeContent;
	
	/**
	 * 回答数
	 */
	private Integer replyNum;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;
	
	/**
	 * 创建时间格式化
	 */
	private String createTimeStr;

	public Integer getThemeId() {
		return themeId;
	}

	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getThemeContent() {
		return themeContent;
	}

	public void setThemeContent(String themeContent) {
		this.themeContent = themeContent;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
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
		return "UserTopicPublishModel [themeId=" + themeId + ", nickName=" + nickName + ", avatarUrl=" + avatarUrl
				+ ", themeTitle=" + themeTitle + ", themeContent=" + themeContent + ", replyNum=" + replyNum
				+ ", createTime=" + createTime + ", createTimeStr=" + createTimeStr + "]";
	}


	
}
