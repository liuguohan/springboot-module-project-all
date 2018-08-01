package com.biyouche.domain.find.model;

import java.io.Serializable;

/**
 * 发现模块
 * @author lgh
 *
 */
public class FindModel implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 7594055390819739909L;

	/**
	 * 发现ID
	 */
	private Integer findId;
	
	/**
	 * 名称
	 */
	private String findName;
	
	/**
	 * 父ID
	 */
	private Integer pid;
	
	/**
	 * 排序
	 */
	private Integer sort;

	public Integer getFindId() {
		return findId;
	}

	public void setFindId(Integer findId) {
		this.findId = findId;
	}

	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	@Override
	public String toString() {
		return "FindModel [findId=" + findId + ", findName=" + findName + ", pid=" + pid + ", sort=" + sort + "]";
	}
	
	
	
}
