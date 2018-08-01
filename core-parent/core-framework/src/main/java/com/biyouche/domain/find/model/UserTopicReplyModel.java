package com.biyouche.domain.find.model;

import java.io.Serializable;
import java.util.List;

/**
 * 个人中心-我的回复
 * @author lgh
 *
 */
public class UserTopicReplyModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = -4825864643118170354L;

	/**
	 * 发现社区回答ID
	 */
	private Integer replyId;
	
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
	 * 社区话题标题
	 */
	private String themeTitle;
	
	/**
	 * 社区回答内容
	 */
	private String replyContent;
	
	/**
	 * 创建时间
	 */
	private Integer createTime;
	
	/**
	 * 创建时间格式化
	 */
	private String createTimeStr;
	
	/**
	 * 话题回复图片信息
	 */
	private List<String> replyImageList;

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

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
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

	public List<String> getReplyImageList() {
		return replyImageList;
	}

	public void setReplyImageList(List<String> replyImageList) {
		this.replyImageList = replyImageList;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	@Override
	public String toString() {
		return "FindCommunityReplyModel [replyId=" + replyId + ", themeId=" + themeId + ", nickName=" + nickName
				+ ", avatarUrl=" + avatarUrl + ", themeTitle=" + themeTitle + ", replyContent=" + replyContent
				+ ", createTime=" + createTime + ", createTimeStr=" + createTimeStr + ", replyImageList="
				+ replyImageList + "]";
	}
	
}
