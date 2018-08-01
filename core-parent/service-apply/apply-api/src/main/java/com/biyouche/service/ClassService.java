package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.apply.model.ClassDetail;
import com.biyouche.domain.apply.model.ClassList;

/**
 * 驾校班级接口
 * @author hucong
 *
 */
public interface ClassService {
	
	
	/**
	 * 驾校班级列表
	 * @param school_id
	 * @return
	 */
	List<ClassList> classList(String content);
	
	/**
	 * 驾校班级详情
	 * @param content
	 * @return
	 */
	ClassDetail classDetail(String content);
	

}
