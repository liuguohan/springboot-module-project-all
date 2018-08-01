package com.biyouche.domain.drive.vo;

import java.io.Serializable;

/**
 * 题目列表
 * @author hc
 *
 */
public class TitleCommentVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8969099719537229780L;
	
	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 用户ID
	 */
	private Integer user_id;
	
	/**
	 * 评论
	 */
	private String comment;
	
	/**
	 * 点赞个数
	 */
	private Integer praise_num;
	
	/**
	 * 用户昵称
	 */
	private String nick_name;
	
	/**
	 * 用户头像
	 */
	private String avatar_url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPraise_num() {
		return praise_num;
	}

	public void setPraise_num(Integer praise_num) {
		this.praise_num = praise_num;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
