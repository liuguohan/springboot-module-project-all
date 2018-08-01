package com.biyouche.domain.drive;

import java.io.Serializable;

/**
 * 考试技巧表
 * @author hc
 *
 */
public class DriveSkills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7702420144819212361L;

	/**
	 * 主键ID
	 */
	private Integer id;
	
	/**
	 * 科目类型[2:科目二  3:科目三]
	 */
	private Integer subject_type;
	
	/**
	 * 图标
	 */
	private String icon;
	
	/**
	 * 图标名字
	 */
	private String iconName;
	
	/**
	 * 图标标签
	 */
	private String iconLabel;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 发布时间
	 */
	private Integer createTime;
	
	/**
	 * 更新时间
	 */
	private Integer updateTime;
	
	/**
	 * 发布人
	 */
	private Integer adminId;
	
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

	public Integer getSubject_type() {
		return subject_type;
	}

	public void setSubject_type(Integer subject_type) {
		this.subject_type = subject_type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getIconLabel() {
		return iconLabel;
	}

	public void setIconLabel(String iconLabel) {
		this.iconLabel = iconLabel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
