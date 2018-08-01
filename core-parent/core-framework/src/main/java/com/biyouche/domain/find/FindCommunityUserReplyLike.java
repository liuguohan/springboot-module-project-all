package com.biyouche.domain.find;

import java.io.Serializable;

/**
 * 发现社区模块用户点赞关联表
 * @author lgh
 *
 */
public class FindCommunityUserReplyLike implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 672232820406742884L;

	
	/**
	 * 发现社区模块用户点赞关联ID
	 */
	private Integer likeId;
	
	/**
	 * 发现社区回答ID
	 */
	private Integer replyId;
	
	/**
	 * 用户ID
	 */
	private Integer userId;

	public Integer getLikeId() {
		return likeId;
	}

	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
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
		return "FindCommunityUserReplyLike [likeId=" + likeId + ", replyId=" + replyId + ", userId=" + userId + "]";
	}
	
	
	
}
