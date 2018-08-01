package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.SchoolClassRelation;

/**
 * 驾校班级关联
 * @author hucong
 *
 */
public interface SchoolClassRelationMapper {
	
	/**
	 * 根据驾校id查询班级id
	 * @param schoolId
	 * @return
	 */
	@Select("select class_id from school_class_relation where school_id = #{schoolId}")
	@Results({
        @Result(property = "classId", column = "class_id")
       })
	List<SchoolClassRelation> classesBySchoolId(Integer schoolId);

}
