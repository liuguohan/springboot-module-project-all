package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.CoachClassRelation;

/**
 * 教练班级关联
 * @author hucong
 *
 */
public interface CoachClassRelationMapper {
	
	
	/**
	 * 根据教练id查询班级
	 * @param coachId
	 * @return
	 */
	@Select("select class_id from coach_class_relation where coach_id = #{coachId}")
	@Results({
        @Result(property = "classId", column = "class_id")
       })
	List<CoachClassRelation> classesByCoachId(Integer coachId);

}
