package com.biyouche.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.apply.SchoolMapper;
import com.biyouche.dao.area.AreaMapper;
import com.biyouche.domain.apply.model.SchoolCreditName;
import com.biyouche.domain.apply.model.SchoolData;
import com.biyouche.domain.apply.model.SchoolDetail;
import com.biyouche.service.SchoolService;
import com.biyouche.utils.MapUtils;
import com.biyouche.utils.Sort;
import com.biyouche.utils.ZimuUtil;

@Service("schoolService")
@SuppressWarnings("rawtypes")
public class SchoolServiceImpl implements SchoolService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolServiceImpl.class);
	
	@Autowired
	private SchoolMapper schoolDao;
	
	@Autowired
	private AreaMapper areaDao;

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<SchoolData> schoolList(String lat1,String lng1,String select_type1) {
		//查询类型默认是推荐[0 推荐驾校 1 距离最近 2 价格最低 3 评分最好]
		Integer selectType = Integer.parseInt(select_type1);
		if(selectType==null||"".equals(selectType)) {
			selectType = 0;
		}
		//纬度
		Double lat = Double.parseDouble(lat1);
		//经度
		Double lng = Double.parseDouble(lng1);
		SchoolDetail school = new SchoolDetail();
		school.setSelectType(selectType);
		List<SchoolData> list = schoolDao.schoolList(school);
		for(int i=0;i<list.size();i++) {
			double distance = MapUtils.GetDistance(Double.parseDouble(list.get(i).getLat()), Double.parseDouble(list.get(i).getLng()), lat, lng);
			list.get(i).setDistance(distance);
			list.get(i).setAreaCodeName(areaDao.areaName(list.get(i).getAreaCode()));
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.biyouche.service.SchoolService#schoolDetail(java.lang.String)
	 */
	@Override
	public SchoolDetail schoolDetail(String lat1,String lng1,String school_id1) {
		Integer schoolId = Integer.parseInt(school_id1);
		//纬度
		Double lat = Double.parseDouble(lat1);
		//经度
		Double lng = Double.parseDouble(lng1);
		SchoolDetail detail = schoolDao.schoolDetail(schoolId);
		double distance = MapUtils.GetDistance(Double.parseDouble(detail.getLat()), Double.parseDouble(detail.getLng()), lat, lng);
		detail.setDistance(distance);
		detail.setAreaCodeName(areaDao.areaName(detail.getAreaCode()));
		return detail;
	}

	/**
	 * 学车贷驾校列表
	 * @param school
	 * @return
	 */
	@Override
	public List<SchoolData> schoolCreditList(String lat1,String lng1) {
		//纬度
		Double lat = Double.parseDouble(lat1);
		//经度
		Double lng = Double.parseDouble(lng1);
		List<SchoolData> list = schoolDao.schoolCreditList();
		for(int i=0;i<list.size();i++) {
			double distance = MapUtils.GetDistance(Double.parseDouble(list.get(i).getLat()), Double.parseDouble(list.get(i).getLng()), lat, lng);
			list.get(i).setDistance(distance);
			list.get(i).setAreaCodeName(areaDao.areaName(list.get(i).getAreaCode()));
		}
		return list;
	}

	/**
	 * 学车贷驾校名字
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public List<Map<String,Object>> schoolCreditName(String school_name) {
		List<SchoolCreditName> list = null;
		String name = school_name;
		if(!"".equals(name)&!"null".equals(name)&null!=name) {
			list = schoolDao.selectSchoolCreditByName(name);
		}else {
		    list = schoolDao.schoolCreditSort();
		}
		ArrayList list1 = new ArrayList();
		
		for(int j=0;j<list.size();j++) {
			list1.add(list.get(j).getName());
		}
		Sort obj1 = new Sort();    
		Map map=obj1.sort(list1);  
	    String[] zimu = ZimuUtil.zimu();
	    List<Map<String,Object>> response = new ArrayList<Map<String,Object>>();
	    for(int i=0;i<zimu.length;i++) {
	    	  Map<String,Object> param = new HashMap<String, Object>();
	    	  ArrayList b =  (ArrayList) map.get(zimu[i]);
	    	  if(b.size()>0) {
	    		  param.put("zimu", zimu[i]);
		    	  param.put("param", map.get(zimu[i]));
		    	  response.add(param);
	    	  }  
	        }
		return response;
	}
	
	
	

}
