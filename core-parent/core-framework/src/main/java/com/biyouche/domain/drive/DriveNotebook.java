package com.biyouche.domain.drive;

import java.io.Serializable;

/**
 * 拿本栏目表
 * @author hucong
 *
 */
public class DriveNotebook implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5859178632038366388L;

	/**
	 *主键ID 
	 */
	private Integer id;
	
	/**
	 *图标
	 */
	private String icon;
	
	/**
	 *图标名字 
	 */
	private String iconName;
	
	/**
	 *标题 
	 */
	private String title;
	
	/**
	 *内容 
	 */
	private String content;
	
	/**
	 *发布时间 
	 */
	private Integer createTime;
	
	/**
	 *更新时间  
	 */
	private Integer updateTime;
	
	/**
	 *发布人 
	 */
	private Integer adminId;
	
	/**
	 *删除状态[0启用  1删除]
	 */
	private Integer delStatus;
	
	/**
	 *浏览次数 
	 */
	private Integer lookNum;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getLookNum() {
		return lookNum;
	}

	public void setLookNum(Integer lookNum) {
		this.lookNum = lookNum;
	}
	
	
}
