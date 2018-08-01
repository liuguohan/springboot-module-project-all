package com.biyouche.mybatis.find;

import org.apache.ibatis.annotations.Param;

/**
 * 发现社区模块自定义sql
 * @author lgh
 *
 */
public class FindCommunitySqlProvider {

	/**
	 * 发现社区模块话题列表
	 * @param findId
	 * @param delStatus
	 * @return
	 */
	public String communityTopicList(@Param("findId") Integer findId, @Param("delStatus") int delStatus) {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT theme.theme_id, theme.theme_type, theme.theme_title, theme.theme_content, theme.theme_label,theme.reply_num, `user`.nick_name, `user`.avatar_url ");
		sql.append(" FROM find_community_theme theme INNER JOIN `user` ON theme.user_id = `user`.user_id ");
		sql.append(" WHERE del_status = #{delStatus} AND find_id = #{findId} ");
		sql.append(" ORDER BY theme.create_time DESC ");
		return sql.toString();
	}
	
	/**
	 * 发现社区模块话题回答列表
	 * @param themeId
	 * @param delStatus
	 * @return
	 */
	public String communityTopicReplyList(@Param("themeId") Integer themeId, @Param("delStatus") int delStatus) {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT reply.reply_id, reply.theme_id, reply.reply_content, reply.effective_num, reply.ineffective_num, reply.create_time, `user`.avatar_url, `user`.nick_name ");
		sql.append(" FROM find_community_reply reply INNER JOIN `user` ON reply.user_id = `user`.user_id ");
		sql.append(" WHERE del_status = #{delStatus} AND theme_id = #{themeId} ");
		sql.append(" ORDER BY reply.create_time DESC ");
		return sql.toString();
	}
	
	/**
	 * 我的发布
	 * @param userId
	 * @param delStatus
	 * @return
	 */
	public String userTopicPublish(@Param("userId") Integer userId, @Param("delStatus") int delStatus) {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT theme.theme_id, theme.theme_title, theme.theme_content, theme.reply_num, theme.create_time, `user`.nick_name, `user`.avatar_url ");
		sql.append(" FROM find_community_theme theme INNER JOIN `user` ON theme.user_id = `user`.user_id ");
		sql.append(" WHERE del_status = #{delStatus} AND theme.user_id = #{userId} ");
		sql.append(" ORDER BY theme.create_time DESC ");
		return sql.toString();
	}
	
	/**
	 * 我的回复
	 * @param userId
	 * @param delStatus
	 * @return
	 */
	public String userTopicReply(@Param("userId") Integer userId, @Param("delStatus") int delStatus) {
		
		StringBuffer sql = new StringBuffer(100);
		sql.append(" SELECT reply.reply_id, reply.theme_id, theme.theme_title, reply.reply_content, reply.create_time, `user`.avatar_url, `user`.nick_name ");
		sql.append(" FROM find_community_reply reply INNER JOIN `user` ON reply.user_id = `user`.user_id ");
		sql.append(" INNER JOIN find_community_theme theme ON reply.theme_id = theme.theme_id ");
		sql.append(" WHERE reply.user_id = #{userId} AND reply.del_status = #{delStatus} AND theme.del_status = #{delStatus} ");
		sql.append(" ORDER BY reply.create_time DESC ");
		return sql.toString();
	}
	
}
