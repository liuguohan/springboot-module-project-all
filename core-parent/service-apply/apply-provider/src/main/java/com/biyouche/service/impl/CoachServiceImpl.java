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
import com.biyouche.dao.apply.CoachClassRelationMapper;
import com.biyouche.dao.apply.CoachMapper;
import com.biyouche.dao.apply.SchoolCoachRelationMapper;
import com.biyouche.domain.apply.CoachClassRelation;
import com.biyouche.domain.apply.SchoolCoachRelation;
import com.biyouche.domain.apply.model.ClassDetail;
import com.biyouche.domain.apply.model.CoachDetail;
import com.biyouche.domain.apply.model.CoachList;
import com.biyouche.service.CoachService;

/**
 * 教练服务实现层
 * @author hucong
 *
 */
@Service("coachService")
public class CoachServiceImpl implements CoachService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(CoachServiceImpl.class);
	 
	 @Autowired
	 private CoachMapper coachDao;
	 
	 @Autowired
	 private ClassMapper classDao;
	 
	 @Autowired
	 private SchoolCoachRelationMapper schoolCoachRelationralationDao;
	 
	 @Autowired
	 private CoachClassRelationMapper  coachClassRelationDao;

	/**
	 * 查询驾校下所有教练
	 * @param content
	 * @return
	 */
	@Override
	public List<CoachList> coachList(String school_id) {
		List<CoachList> coachList = new ArrayList<CoachList>();
		Integer schoolId = Integer.parseInt(school_id);
		List<SchoolCoachRelation> coachIds = schoolCoachRelationralationDao.coachsByschoolId(schoolId);
		for(int i=0;i<coachIds.size();i++) {
			CoachList coach = coachDao.coach(coachIds.get(i).getCoachId());
			coachList.add(coach);
		}
		return coachList;
	}

	/**
	 * 教练详情
	 * @param content
	 * @return
	 */
	@Override
	public CoachDetail coachDetail(String coach_id) {
		Integer id = Integer.parseInt(coach_id);
		CoachDetail coachDetail = coachDao.coachDetail(id);
		List<ClassDetail> classes = new ArrayList<ClassDetail>();
		//查询教练带的班级
		List<CoachClassRelation> classlist = coachClassRelationDao.classesByCoachId(id);
		for(int i=0;i<classlist.size();i++) {
			LOGGER.info("班级id****"+classlist.get(i).getClassId());
			ClassDetail classDetail = classDao.classDetail(classlist.get(i).getClassId());
			LOGGER.info("班级详情**"+classDetail);
			if(classDetail!=null) {
				classes.add(classDetail);
			}
			
		}
		coachDetail.setClasses(classes);
		return coachDetail;
	}

}
