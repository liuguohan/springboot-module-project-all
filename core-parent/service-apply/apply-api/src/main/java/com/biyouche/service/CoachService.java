package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.apply.model.CoachDetail;
import com.biyouche.domain.apply.model.CoachList;

/**
 * 教练服务
 * @author hucong
 *
 */
public interface CoachService {
	
	/**
	 * 查询驾校下所有教练
	 * @param content
	 * @return
	 */
	List<CoachList> coachList(String school_id);
	
	/**
	 * 教练详情
	 * @param content
	 * @return
	 */
	CoachDetail coachDetail(String coach_id);

}
