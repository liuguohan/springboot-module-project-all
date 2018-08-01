package com.biyouche.dao.find;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.find.model.FindInfoCoverModel;
import com.biyouche.domain.find.model.FindInfoDetailModel;

/**
 * 发现资讯模块
 * @author lgh
 *
 */
public interface FindInfoMapper {

	/**
	 * 发现资讯子模块文章列表
	 * @return
	 */
	@Select(" SELECT info_id, find_id, info_title, info_cover, create_time FROM find_info WHERE find_id = #{findId} AND del_status = #{delStatus} ")
	@Results({
        @Result(property = "infoId", column = "info_id"),
        @Result(property = "findId", column = "find_id"),
        @Result(property = "infoTitle", column = "info_title"),
        @Result(property = "infoCover", column = "info_cover"),
        @Result(property = "createTime", column = "create_time")
       })
	List<FindInfoCoverModel> submoduleArticleList(@Param("findId") Integer findId, @Param("delStatus") int delStatus);
	
	/**
	 * 发现资讯子模块文章详情
	 * @return
	 */
	@Select(" SELECT info_id, find_id, info_title, info_content, create_time FROM find_info WHERE info_id = #{infoId} AND del_status = #{delStatus} ")
	@Results({
        @Result(property = "infoId", column = "info_id"),
        @Result(property = "infoTitle", column = "info_title"),
        @Result(property = "infoContent", column = "info_title"),
        @Result(property = "createTime", column = "create_time")
       })
	FindInfoDetailModel submoduleArticleDetail(@Param("infoId") Integer infoId, @Param("delStatus") int delStatus);
	
}
