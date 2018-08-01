package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.SchoolCoachRelation;

/**
 * 驾校教练关联表
 * @author hucong
 *
 */
public interface SchoolCoachRelationMapper {
	
	
	@Select("select coach_id from school_coach_relation where school_id = #{schoolId}")
	@Results({
        @Result(property = "coachId", column = "coach_id")
       })
	List<SchoolCoachRelation> coachsByschoolId(Integer schoolId);
	

}
