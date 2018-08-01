package com.biyouche.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.apply.ClassMapper;
import com.biyouche.dao.apply.SchoolClassRelationMapper;
import com.biyouche.domain.apply.SchoolClassRelation;
import com.biyouche.domain.apply.model.ClassDetail;
import com.biyouche.domain.apply.model.ClassList;
import com.biyouche.service.ClassService;

/**
 * 班级服务层
 * @author hucong
 *
 */
@Service("classService")
public class ClassServiceImpl implements ClassService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(CoachServiceImpl.class);
	 
	 @Autowired
	 private ClassMapper classDao;
	 
	 @Autowired
	 private SchoolClassRelationMapper schoolClassRelationDao;

   /**
	* 查询驾校下所有教练
	* @param content
	* @return
	*/
	@Override
	public List<ClassList> classList(String school_id) {
		List<ClassList> classList = new ArrayList<ClassList>();
		Integer schoolId = Integer.parseInt(school_id);
		List<SchoolClassRelation> classes = schoolClassRelationDao.classesBySchoolId(schoolId);
		if(classes.size()>0) {
			for(int i=0;i<classes.size();i++) {
				ClassList classByid = classDao.classByid(classes.get(i).getClassId());
				if(classByid!=null) {
					classList.add(classByid);
				}
			}
		}
		return classList;
	}

	/**
	* 班级详情
	* @param content
	* @return
	*/
	@Override
	public ClassDetail classDetail(String class_id) {
		Integer classId = Integer.parseInt(class_id);
		ClassDetail classDetail = classDao.classDetail(classId);
		return classDetail;
	}
	 
	 
	 
	 
}
