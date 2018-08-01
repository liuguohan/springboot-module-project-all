package com.biyouche.dao.apply;

import java.util.List;


import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.model.ClassDetail;
import com.biyouche.domain.apply.model.ClassList;

/**
 * 班级
 * @author hucong
 *
 */
public interface ClassMapper {
	
	/**
	 * 班级详情
	 * @return
	 * 
	 */
	@Select("select class_name,tuition_fee,class_label,registration_phone,class_introduce,students_num,transportation_way,take_time,practice_time from school_class where id = #{id}")
	@Results({
        @Result(property = "className", column = "class_name"),
        @Result(property = "tuitionFee", column = "tuition_fee"),
        @Result(property = "classLabel", column = "class_label"),
        @Result(property = "registrationPhone", column = "registration_phone"),
        @Result(property = "classIntroduce", column = "class_introduce"),
        @Result(property = "studentsNum", column = "students_num"),
        @Result(property = "transportationWay", column = "transportation_way"),
        @Result(property = "takeTime", column = "take_time"),
        @Result(property = "practiceTime", column = "practice_time")
       })
	ClassDetail classDetail(Integer id);
	
	/**
	 * 驾校班级列表
	 * @param school_id
	 * @return
	 */
	@Select("select id,class_name,class_label,class_active from school_class where school_id = #{school_id} and del_status = 0")
	@Results({
        @Result(property = "className", column = "class_name"),
        @Result(property = "classLabel", column = "class_label"),
        @Result(property = "classActive", column = "class_active")
       })
	List<ClassList> classList(Integer school_id);

	@Select("select id,class_name,class_label,class_active from school_class where id = #{id} and del_status = 0")
	@Results({
        @Result(property = "className", column = "class_name"),
        @Result(property = "classLabel", column = "class_label"),
        @Result(property = "classActive", column = "class_active")
       })
	ClassList classByid(Integer id);
}
