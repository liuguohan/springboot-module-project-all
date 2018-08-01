package com.biyouche.mybatis.apply;

import org.apache.ibatis.annotations.Param;

/**
 * 教练自定义sql
 * @author lgh
 *
 */
public class CoachSqlProvider {

	
	/**
	 * 查询当前城市教练信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	public String searchCoachList(@Param("searchName") String searchName, @Param("cityCode") String cityCode) {
		
		//模糊搜索当前城市已开放驾校下未删除的教练信息
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT id, score, image, `name`, recommend_class_name, recommend_class_fee, ");
		sql.append(" (SELECT `name` FROM school WHERE id = (SELECT school_id FROM school_coach_relation WHERE coach_id = coach.id ORDER BY school_id ASC LIMIT 1) AND city_code = #{cityCode} AND del_status = 0) AS school_name ");
		sql.append(" FROM school_coach coach ");
		sql.append(" WHERE del_status = 0 ");
		sql.append(" AND EXISTS(SELECT area_no FROM area WHERE area_no = ");
		sql.append(" (SELECT `area_code` FROM school WHERE id = (SELECT school_id FROM school_coach_relation WHERE coach_id = coach.id ORDER BY school_id ASC LIMIT 1) AND city_code = #{cityCode} AND del_status = 0) ");
		sql.append(" AND area_status = 1) AND LOCATE(#{searchName}, `name`) > 0 ");
		return sql.toString();
	}
	
	/**
	 * 即时查询当前城市教练信息
	 * @author lgh
	 * @param searchName
	 * @param cityCode
	 * @return
	 */
	public String quickSearchCoachList(@Param("searchName") String searchName, @Param("cityCode") String cityCode) {
		
		//模糊搜索当前城市已开放驾校下未删除的教练信息
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT id, `name`, ");
		sql.append(" (SELECT `name` FROM school WHERE id = (SELECT school_id FROM school_coach_relation WHERE coach_id = coach.id ORDER BY school_id ASC LIMIT 1) AND city_code = #{cityCode} AND del_status = 0) AS school_name ");
		sql.append(" FROM school_coach coach ");
		sql.append(" WHERE del_status = 0 ");
		sql.append(" AND EXISTS(SELECT area_no FROM area WHERE area_no = ");
		sql.append(" (SELECT `area_code` FROM school WHERE id = (SELECT school_id FROM school_coach_relation WHERE coach_id = coach.id ORDER BY school_id ASC LIMIT 1) AND city_code = #{cityCode} AND del_status = 0) ");
		sql.append(" AND area_status = 1) AND LOCATE(#{searchName}, `name`) > 0 ");
		return sql.toString();
	}
	
}
