package com.biyouche.dao.find;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.find.model.FindModel;

/**
 * 发现模块
 * @author lgh
 *
 */
public interface FindMapper {

	/**
	 * 发现模块初始化
	 * @return
	 */
	@Select(" SELECT find_id, find_name, pid, sort FROM find WHERE del_status = #{delStatus} ")
	@Results({
        @Result(property = "findId", column = "find_id"),
        @Result(property = "findName", column = "find_name"),
        @Result(property = "pid", column = "pid"),
        @Result(property = "sort", column = "sort")
       })
	List<FindModel> findInitialization(int delStatus);
	
}
