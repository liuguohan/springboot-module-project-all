package com.biyouche.dao.find;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.find.FindCommunityReply;
import com.biyouche.domain.find.FindCommunityTheme;
import com.biyouche.domain.find.model.FindCommunityReplyModel;
import com.biyouche.domain.find.model.FindCommunityThemeModel;
import com.biyouche.domain.find.model.UserTopicPublishModel;
import com.biyouche.domain.find.model.UserTopicReplyModel;
import com.biyouche.mybatis.find.FindCommunitySqlProvider;

/**
 * 发现社区模块业务
 * @author lgh
 *
 */
public interface FindCommunityMapper {

	/**
	 * 发现社区模块话题列表
	 * @param findId
	 * @param delStatus
	 * @return
	 */
	@SelectProvider(type = FindCommunitySqlProvider.class, method = "communityTopicList")
	@Results({
        @Result(property = "themeId", column = "theme_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "avatarUrl", column = "avatar_url"),
        @Result(property = "themeType", column = "theme_type"),
        @Result(property = "themeTitle", column = "theme_title"),
        @Result(property = "themeContent", column = "theme_content"),
        @Result(property = "themeLabel", column = "theme_label"),
        @Result(property = "replyNum", column = "reply_num")
       })
	List<FindCommunityThemeModel> communityTopicList(@Param("findId") Integer findId, @Param("delStatus") int delStatus);
	
	/**
	 * 发现社区模块话题发布
	 * @param theme
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_theme` (`find_id`, `user_id`, `theme_type`, `theme_title`, `theme_content`, `theme_label`, `reply_num`, `del_status`, `create_time`) VALUES "
			+ "(#{findId}, #{userId}, '0', #{themeTitle}, #{themeContent}, #{themeLabel}, '0', '0', UNIX_TIMESTAMP()) ")
	int communityTopicPublish(FindCommunityTheme theme);
	
	/**
	 * 发现社区模块话题评论
	 * @param reply
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_reply` (`theme_id`, `user_id`, `reply_content`, `effective_num`, `ineffective_num`, `del_status`, `create_time`) VALUES "
			+ "(#{themeId}, #{userId}, #{replyContent}, '0', '0', '0', UNIX_TIMESTAMP()) ")
	int communityTopicReview(FindCommunityReply reply);
	
	/**
	 * 根据社区话题ID修改发现社区话题回答数
	 * @param themeId
	 * @return
	 */
	@Update(" UPDATE find_community_theme SET reply_num = reply_num + 1 WHERE theme_id = #{themeId} ")
	int updateCommunityThemeReplyNumByThemeId(Integer themeId);
	
	/**
	 * 根据社区话题ID获取发现社区话题表信息
	 * @param themeId
	 * @return
	 */
	@Select(" SELECT * FROM find_community_theme WHERE theme_id = #{themeId} AND del_status = 0 ")
	@Results({
        @Result(property = "themeId", column = "theme_id"),
        @Result(property = "findId", column = "find_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "themeType", column = "theme_type"),
        @Result(property = "themeTitle", column = "theme_title"),
        @Result(property = "themeContent", column = "theme_content"),
        @Result(property = "themeLabel", column = "theme_label"),
        @Result(property = "replyNum", column = "reply_num"),
        @Result(property = "delStatus", column = "del_status"),
        @Result(property = "createTime", column = "create_time")
       })
	FindCommunityTheme selectFindCommunityThemeByThemeId(Integer themeId);
	
	/**
	 * 发现社区模块话题回答列表
	 * @param themeId
	 * @param delStatus
	 * @return
	 */
	@SelectProvider(type = FindCommunitySqlProvider.class, method = "communityTopicReplyList")
	@Results({
		@Result(property = "replyId", column = "reply_id"),
        @Result(property = "themeId", column = "theme_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "avatarUrl", column = "avatar_url"),
        @Result(property = "replyContent", column = "reply_content"),
        @Result(property = "effectiveNum", column = "effective_num"),
        @Result(property = "ineffectiveNum", column = "ineffective_num"),
        @Result(property = "createTime", column = "create_time")
       })
	List<FindCommunityReplyModel> communityTopicReplyList(@Param("themeId") Integer themeId, @Param("delStatus") int delStatus);
	
	/**
	 * 根据用户ID和回答ID获取发现社区模块用户点赞关联表ID
	 * @param userId
	 * @param replyId
	 * @return
	 */
	@Select(" SELECT like_id FROM find_community_user_reply_like WHERE user_id = #{userId} AND reply_id = #{replyId} ")
	Integer selectFindCommunityUserReplyLikeByReplyIdAndUserId(@Param("userId") Integer userId, @Param("replyId") Integer replyId);
	
	/**
	 * 用户对回答点赞
	 * @param replyId
	 * @return
	 */
	@Update(" UPDATE find_community_reply SET effective_num = effective_num + 1 WHERE reply_id = #{replyId} ")
	int updateFindCommunityReplyEffectiveNumByReplyId(Integer replyId);
	
	/**
	 * 生成用户对回复点赞关联
	 * @param userId
	 * @param replyId
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_user_reply_like` (`reply_id`, `user_id`) VALUES (#{userId}, #{replyId}) ")
	int insertFindCommunityUserReplyLike(@Param("userId") Integer userId, @Param("replyId") Integer replyId);
	
	/**
	 * 根据用户ID和回答ID获取发现社区模块用户踩关联表ID
	 * @param userId
	 * @param replyId
	 * @return
	 */
	@Select(" SELECT tread_id FROM find_community_user_reply_tread WHERE user_id = #{userId} AND reply_id = #{replyId} ")
	Integer selectFindCommunityUserReplyTreadByReplyIdAndUserId(@Param("userId") Integer userId, @Param("replyId") Integer replyId);
	
	/**
	 * 用户对回答踩
	 * @param replyId
	 * @return
	 */
	@Update(" UPDATE find_community_reply SET ineffective_num = ineffective_num + 1 WHERE reply_id = #{replyId} ")
	int updateFindCommunityReplyIneffectiveNumByReplyId(Integer replyId);
	
	/**
	 * 生成用户对回复踩关联
	 * @param userId
	 * @param replyId
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_user_reply_tread` (`reply_id`, `user_id`) VALUES (#{userId}, #{replyId}) ")
	int insertFindCommunityUserReplyTread(@Param("userId") Integer userId, @Param("replyId") Integer replyId);
	
	/**
	 * 发现社区模块话题发布图片上传
	 * @param themeId
	 * @param fileName
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_theme_image` (`theme_id`, `image_url`, `image_type`, `del_status`, `create_time`, `update_time`, `admin_id`) VALUES "
			+ "(#{themeId}, #{fileName}, '0', '0', UNIX_TIMESTAMP(), '0', '0') ")
	int communityTopicUpload(@Param("themeId") Integer themeId, @Param("fileName") String fileName);
	
	/**
	 * 发现社区模块话题回复图片上传
	 * @param replyId
	 * @param fileName
	 * @return
	 */
	@Insert(" INSERT INTO `find_community_reply_image` (`reply_id`, `image_url`, `image_type`, `del_status`, `create_time`, `update_time`, `admin_id`) VALUES "
			+ "(#{replyId}, #{fileName}, '0', '0', UNIX_TIMESTAMP(), '0', '0') ")
	int communityTopicReplyUpload(@Param("replyId") Integer replyId, @Param("fileName") String fileName);
	
	/**
	 * 根据话题ID获取图片信息
	 * @param themeId
	 * @param delStatus
	 * @return
	 */
	@Select(" SELECT image_url FROM find_community_theme_image WHERE theme_id = #{themeId} AND image_type = 0 AND del_status = #{delStatus} ")
	List<String> selectFindCommunityThemeImageByThemeId(@Param("themeId") Integer themeId, @Param("delStatus") int delStatus);
	
	/**
	 * 根据话题回复ID获取图片信息
	 * @param replyId
	 * @param delStatus
	 * @return
	 */
	@Select(" SELECT image_url FROM find_community_reply_image WHERE reply_id = #{replyId} AND image_type = 0 AND del_status = #{delStatus} ")
	List<String> selectFindCommunityReplyImageByReplyId(@Param("replyId") Integer replyId, @Param("delStatus") int delStatus);
	
	/**
	 * 我的发布
	 * @param userId
	 * @param delStatus
	 * @return
	 */
	@SelectProvider(type = FindCommunitySqlProvider.class, method = "userTopicPublish")
	@Results({
        @Result(property = "themeId", column = "theme_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "avatarUrl", column = "avatar_url"),
        @Result(property = "themeTitle", column = "theme_title"),
        @Result(property = "themeContent", column = "theme_content"),
        @Result(property = "replyNum", column = "reply_num"),
        @Result(property = "createTime", column = "create_time")
       })
	List<UserTopicPublishModel> userTopicPublish(@Param("userId") Integer userId, @Param("delStatus") int delStatus);
	
	/**
	 * 我的回复
	 * @param userId
	 * @param delStatus
	 * @return
	 */
	@SelectProvider(type = FindCommunitySqlProvider.class, method = "userTopicReply")
	@Results({
		@Result(property = "replyId", column = "reply_id"),
        @Result(property = "themeId", column = "theme_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "avatarUrl", column = "avatar_url"),
        @Result(property = "themeTitle", column = "theme_title"),
        @Result(property = "replyContent", column = "reply_content"),
        @Result(property = "createTime", column = "create_time")
       })
	List<UserTopicReplyModel> userTopicReply(@Param("userId") Integer userId, @Param("delStatus") int delStatus);
	
}
