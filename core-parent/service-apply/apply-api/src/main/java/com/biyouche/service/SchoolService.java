package com.biyouche.service;

import java.util.List;
import java.util.Map;
import com.biyouche.domain.apply.model.SchoolData;
import com.biyouche.domain.apply.model.SchoolDetail;

/**
 * 驾校服务接口
 * @author hucong
 *
 */
public interface SchoolService {
	
	/**
	 * 驾校列表
	 * @param school
	 * @return
	 */
	List<SchoolData> schoolList(String lat1,String lng1,String select_type1);
	
	
	/**
	 * 驾校详情
	 * @param id
	 * @return
	 */
	SchoolDetail schoolDetail(String lat1,String lng1,String school_id1);
	
	
	/**
	 * 学车贷驾校列表
	 * @param school
	 * @return
	 */
	List<SchoolData> schoolCreditList(String lat1,String lng1);
	
	/**
	 * 学车贷驾校名字
	 * @return
	 */
	List<Map<String,Object>> schoolCreditName(String school_name);

}
