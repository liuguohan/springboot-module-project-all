package com.biyouche.domain.apply;

import java.io.Serializable;

/**
 * 驾校简介
 * @author lgh
 *
 */
public class SchoolIntroduction implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 5386764340325002307L;
	
	/**
	 * 驾校简介ID
	 */
	private Integer id;
	
	/**
	 * 驾校ID
	 */
	private Integer schoolId;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 删除状态[0未删除;1删除;]
	 */
	private int delStatus;
	
	/**
	 * 创建时间
	 */
	private int createTime;
	
	/**
	 * 更新时间
	 */
	private int updateTime;
	
	/**
	 * 操作人ID
	 */
	private Integer adminId;

	public SchoolIntroduction() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getCreateTime() {
		return createTime;
	}

	public void setCreateTime(int createTime) {
		this.createTime = createTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "SchoolIntroduction [id=" + id + ", schoolId=" + schoolId + ", content=" + content + ", delStatus="
				+ delStatus + ", createTime=" + createTime + ", updateTime=" + updateTime + ", adminId=" + adminId
				+ "]";
	}
	
	

}
