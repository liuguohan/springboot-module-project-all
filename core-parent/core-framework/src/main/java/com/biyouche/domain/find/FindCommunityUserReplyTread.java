package com.biyouche.domain.find;

import java.io.Serializable;

/**
 * 发现社区模块用户踩关联表
 * @author lgh
 *
 */
public class FindCommunityUserReplyTread implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5723113889542910058L;

	/**
	 * 发现社区模块用户踩关联ID
	 */
	private Integer treadId;
	
	/**
	 * 发现社区回答ID
	 */
	private Integer replyId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;

	public Integer getTreadId() {
		return treadId;
	}

	public void setTreadId(Integer treadId) {
		this.treadId = treadId;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "FindCommunityUserReplyTread [treadId=" + treadId + ", replyId=" + replyId + ", userId=" + userId + "]";
	}
	
	
}
