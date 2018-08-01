package com.biyouche.dao.apply;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.SchoolIntroduction;

/**
 * 驾校详情简介
 * @author lgh
 *
 */
public interface SchoolIntroductionMapper {

	/**
	 * 驾校详情简介
	 * @param schoolId
	 * @param delStatus
	 * @return
	 */
	@Select("SELECT content FROM school_introduction WHERE school_id = #{schoolId} AND del_status = #{delStatus} LIMIT 1")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "schoolId", column = "school_id"),
            @Result(property = "content",column = "content"),
            @Result(property = "delStatus",column = "del_status"),
            @Result(property = "createTime",column = "create_time"),
            @Result(property = "updateTime",column = "update_time"),
            @Result(property = "adminId",column = "admin_id"),
    })
    SchoolIntroduction detail(@Param("schoolId") int schoolId, @Param("delStatus") int delStatus);
	
}
