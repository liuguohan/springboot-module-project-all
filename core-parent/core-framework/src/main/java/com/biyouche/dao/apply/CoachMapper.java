package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.biyouche.domain.apply.model.CoachDetail;
import com.biyouche.domain.apply.model.CoachIndexModel;
import com.biyouche.domain.apply.model.CoachList;
import com.biyouche.domain.apply.model.QuickCoachIndexModel;
import com.biyouche.mybatis.apply.CoachSqlProvider;

/**
 * 教练接口
 * @author hucong
 *
 */
public interface CoachMapper {

	/**
	 * 查询驾校下所有教练
	 * @param schoolId
	 * @return list
	 */
	@Select("select id,name,score,students_num,coach_school_age,image from school_coach where school_id = #{schoolId} and del_status = 0 ORDER BY students_num desc")
	@Results({
         @Result(property = "studentsNum", column = "students_num"),
         @Result(property = "coachSchoolAge", column = "coach_school_age")
        })
	List<CoachList> coachList(Integer schoolId);
	
	/**
	 * 根据id找到教练列表
	 * @param id
	 * @return
	 */
	@Select("select id,name,score,students_num,coach_school_age,image from school_coach where id = #{id} and del_status = 0")
	@Results({
         @Result(property = "studentsNum", column = "students_num"),
         @Result(property = "coachSchoolAge", column = "coach_school_age")
        })
	CoachList coach(Integer id);
	
	/**
	 * 教练详情
	 * @param id
	 * @return CoachDetail
	 */
	@Select("select name,score,students_num,coach_label,registration_num,coach_sex,coach_age,coach_school_age,driver_type_id,vehicle_model,plate_number,image from school_coach where id = #{id}")
	@Results({
        @Result(property = "studentsNum", column = "students_num"),
        @Result(property = "coachLabel", column = "coach_label"),
        @Result(property = "registrationNum", column = "registration_num"),
        @Result(property = "coachSex", column = "coach_sex"),
        @Result(property = "coachAge", column = "coach_age"),
        @Result(property = "coachSchoolAge", column = "coach_school_age"),
        @Result(property = "driverTypeId", column = "driver_type_id"),
        @Result(property = "vehicleModel", column = "vehicle_model"),
        @Result(property = "plateNumber", column = "plate_number")
       })
	CoachDetail coachDetail(Integer id);
	
	/**
	 * 查询当前城市教练信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	@SelectProvider(type = CoachSqlProvider.class, method = "searchCoachList")
	@Results({
        @Result(property = "coachId", column = "id"),
        @Result(property = "coachScore", column = "score"),
        @Result(property = "coachImage", column = "image"),
        @Result(property = "coachName", column = "name"),
        @Result(property = "coachSchoolName", column = "school_name"),
        @Result(property = "coachStudentsNum", column = "students_num"),
        @Result(property = "coachClassFee", column = "recommend_class_fee")
       })
	List<CoachIndexModel> searchCoachList(@Param("searchName") String searchName, @Param("cityCode") String cityCode);
	
	/**
	 * 即时查询当前城市教练信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	@SelectProvider(type = CoachSqlProvider.class, method = "searchCoachList")
	@Results({
        @Result(property = "coachId", column = "id"),
        @Result(property = "coachName", column = "name"),
        @Result(property = "coachSchoolName", column = "school_name")
       })
	List<QuickCoachIndexModel> quickSearchCoachList(@Param("searchName") String searchName, @Param("cityCode") String cityCode);
}
