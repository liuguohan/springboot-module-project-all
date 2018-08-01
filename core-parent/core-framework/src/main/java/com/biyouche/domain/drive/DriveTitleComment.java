package com.biyouche.domain.drive;

import java.io.Serializable;

/**
 * 科目一 科目四题目评论
 * @author hc
 *
 */
public class DriveTitleComment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6845307771930767494L;

	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 用户ID
	 */
	private Integer userId;
	
	/**
	 * 题目编号
	 */
	private String titleNo;
	
	/**
	 * 科目类型[1:科目一  4:科目四]
	 */
	private Integer subjectType;
	
	/**
	 * 评论
	 */
	private String comment;
	
	/**
	 * 点赞个数
	 */
	private Integer praiseNum;
	
	/**
	 * 评论时间
	 */
	private Integer createTime;
	
	/**
	 * 删除状态[0启用  1删除]
	 */
	private Integer delStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getTitleNo() {
		return titleNo;
	}

	public void setTitleNo(String titleNo) {
		this.titleNo = titleNo;
	}

	public Integer getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(Integer subjectType) {
		this.subjectType = subjectType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
	
}
