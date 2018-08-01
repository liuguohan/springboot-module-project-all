package com.biyouche.mybatis.apply;

import org.apache.ibatis.annotations.Param;

import com.biyouche.domain.apply.model.SchoolDetail;
import com.biyouche.enums.SearchLabelEnum;

/**
 * 驾校自定义sql
 * @author lgh
 *
 */
public class SchoolSqlProvider {

	/**
	 * 查询驾校列表
	 * @param school
	 * @return
	 */
	public String schoolList(SchoolDetail school) {
		String sql = "select id,score,recommend_class_id,area_code,name,image,lat,lng,recommend_class_fee,recommend_class_name,recommend_class_label,recommend_class_active from school where del_status = 0 ";
		if(school.getSelectType()==0){
			sql += "and recommend_status = 1";
		}
		if(school.getSelectType()==2) {
			sql += "order by recommend_class_fee";
		}
        if(school.getSelectType()==3) {
        	sql += "order by score desc";
		}
		return sql;
	}
	
	/**
	 * 查询当前城市驾校信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	public String searchSchoolList(@Param("searchName") String searchName, @Param("cityCode") String cityCode) {
		
		//模糊搜索当前城市已开放区下未删除的驾校信息
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT id, score, image, `name`, recommend_class_name, recommend_class_fee, ");
		sql.append(" (SELECT area_name FROM area WHERE area_no = school.area_code) AS area_name ");
		sql.append(" FROM school ");
		sql.append(" WHERE LOCATE(#{searchName},`name`)>0  AND city_code = #{cityCode} AND del_status = 0 ");
		sql.append(" AND EXISTS(SELECT area_no FROM area WHERE area_no = school.area_code AND area_status = 1) ");
		return sql.toString();
	}
	
	/**
	 * 查询搜索标签驾校信息
	 * @author lgh
	 * @param labelType
	 * @param cityCode
	 * @return
	 */
	public String searchSchoolListByLabel(int labelType, @Param("cityCode") String cityCode) {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT id, score, image, `name`, recommend_class_name, recommend_class_fee, ");
		sql.append(" (SELECT area_name FROM area WHERE area_no = school.area_code) AS area_name ");
		sql.append(" FROM school ");
		sql.append(" WHERE city_code = #{cityCode} AND del_status = 0 ");
		sql.append(" AND EXISTS(SELECT area_no FROM area WHERE area_no = school.area_code AND area_status = 1) ");
		if( SearchLabelEnum.DISTANCE.KEY == labelType ) {
			
			//TODO
		}else if( SearchLabelEnum.SCORE.KEY == labelType ) {
			sql.append(" ORDER BY score DESC ");
		}else if( SearchLabelEnum.PRICE.KEY == labelType ) {
			sql.append(" ORDER BY recommend_class_fee ASC ");
		}else if( SearchLabelEnum.RECOMMAND.KEY == labelType ) {
			sql.append(" AND recommend_status = 1 ");
		}else if( SearchLabelEnum.INDEMNITY.KEY == labelType ) {
			
			//TODO
		}else if( SearchLabelEnum.CREDIT.KEY == labelType ) {
			sql.append(" AND credit_driver_status = 1 ");
		}
		
		return sql.toString();
		
	}
	
	/**
	 * 即时查询当前城市驾校信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	public String quickSearchSchoolList(@Param("searchName") String searchName, @Param("cityCode") String cityCode) {
		
		//模糊搜索当前城市已开放区下未删除的驾校信息
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT id, `name` ");
		sql.append(" FROM school ");
		sql.append(" WHERE LOCATE(#{searchName},`name`)>0  AND city_code = #{cityCode} AND del_status = 0 ");
		sql.append(" AND EXISTS(SELECT area_no FROM area WHERE area_no = school.area_code AND area_status = 1) ");
		return sql.toString();
	}
	
}
