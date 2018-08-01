package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import com.biyouche.domain.apply.model.QuickSchoolIndexModel;
import com.biyouche.domain.apply.model.SchoolCreditName;
import com.biyouche.domain.apply.model.SchoolData;
import com.biyouche.domain.apply.model.SchoolDetail;
import com.biyouche.domain.apply.model.SchoolIndexModel;
import com.biyouche.mybatis.apply.SchoolSqlProvider;

/**
 * 驾校接口
 * @author hucong
 *
 */
public interface SchoolMapper {
	
	/**
	 * 查询驾校列表
	 * @param school
	 * @return
	 */
	@SelectProvider(type = SchoolSqlProvider.class, method = "schoolList")
	@Results({
        @Result(property = "recommendClassId", column = "recommend_class_id"),
        @Result(property = "areaCode", column = "area_code"),
        @Result(property = "recommendClassFee", column = "recommend_class_fee"),
        @Result(property = "recommendClassName", column = "recommend_class_name")
       })
	public List<SchoolData> schoolList(SchoolDetail school);

	
	/**
	 * 驾校详情
	 * @param id
	 * @return
	 */
	@Select("select image,name,score,ranking,pass_rate,address,label,lat,lng,school_level from school where id = #{id}")
	@Results({
        @Result(property = "passRate", column = "pass_rate"),
        @Result(property = "schoolLevel", column = "school_level")
       })
	public SchoolDetail schoolDetail(Integer id);
	
	/**
	 * 查询当前城市驾校信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	@SelectProvider(type = SchoolSqlProvider.class, method = "searchSchoolList")
	@Results({
        @Result(property = "schoolId", column = "id"),
        @Result(property = "schoolScore", column = "score"),
        @Result(property = "schoolImage", column = "image"),
        @Result(property = "schoolName", column = "name"),
        @Result(property = "schoolAreaName", column = "area_name"),
        @Result(property = "schoolClassName", column = "recommend_class_name"),
        @Result(property = "schoolClassFee", column = "recommend_class_fee")
       })
	List<SchoolIndexModel> searchSchoolList(@Param("searchName") String searchName, @Param("cityCode") String cityCode);
	
	/**
	 * 查询搜索标签驾校信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	@SelectProvider(type = SchoolSqlProvider.class, method = "searchSchoolListByLabel")
	@Results({
        @Result(property = "schoolId", column = "id"),
        @Result(property = "schoolScore", column = "score"),
        @Result(property = "schoolImage", column = "image"),
        @Result(property = "schoolName", column = "name"),
        @Result(property = "schoolAreaName", column = "area_name"),
        @Result(property = "schoolClassName", column = "recommend_class_name"),
        @Result(property = "schoolClassFee", column = "recommend_class_fee")
       })
	List<SchoolIndexModel> searchSchoolListByLabel(int labelType, @Param("cityCode") String cityCode);
	
	/**
	 * 即时查询当前城市驾校信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	@SelectProvider(type = SchoolSqlProvider.class, method = "quickSearchSchoolList")
	@Results({
        @Result(property = "schoolId", column = "id"),
        @Result(property = "schoolName", column = "name")
       })
	List<QuickSchoolIndexModel> quickSearchSchoolList(@Param("searchName") String searchName, @Param("cityCode") String cityCode);

	/**
	 * 学车贷驾校列表
	 * @param school
	 * @return
	 */
	@Select("select id,score,recommend_class_id,area_code,name,image,lat,lng,recommend_class_fee,recommend_class_name from school where credit_driver_status = 0 and del_status = 0 ")
	@Results({
        @Result(property = "recommendClassId", column = "recommend_class_id"),
        @Result(property = "areaCode", column = "area_code"),
        @Result(property = "recommendClassFee", column = "recommend_class_fee"),
        @Result(property = "recommendClassName", column = "recommend_class_name")
       })
	 List<SchoolData> schoolCreditList();
	
	
	/**
	 * 学车贷驾校列表姓名
	 * @return
	 */
	@Select("select id,name from school where credit_driver_status = 0 and del_status = 0 ")
    List<SchoolCreditName> schoolCreditSort();
	
	/**
	 * 根据驾校名字查询驾校
	 * @return
	 */
	@Select("select id,name from school where credit_driver_status = 0 and del_status = 0 and name like  CONCAT('%',#{name},'%')")
	List<SchoolCreditName> selectSchoolCreditByName(String name);
	
	/**
	 * 查询驾校名字
	 * @param schoolId
	 * @return
	 */
	@Select("select name from school where id = #{schoolId}")
	String schoolName(Integer schoolId);
	
	
}