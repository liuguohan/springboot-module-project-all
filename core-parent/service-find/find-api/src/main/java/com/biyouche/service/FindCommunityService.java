package com.biyouche.service;

import java.util.Map;

import com.biyouche.domain.find.FindCommunityReply;
import com.biyouche.domain.find.FindCommunityTheme;
import com.biyouche.exception.BussinessException;

/**
 * 发现社区模块业务
 * @author lgh
 *
 */
public interface FindCommunityService {

	/**
	 * 发现资讯子模块文章列表
	 * @param findId
	 * @return
	 */
	Map<String, Object> communityTopicList(Integer findId);
	
	/**
	 * 发现社区模块话题发布标签初始化
	 * @return
	 */
	Map<String, Object> initCommunityTopicPublishLabel();
	
	/**
	 * 发现社区模块话题发布
	 * @param theme
	 * @return
	 */
	void communityTopicPublish(FindCommunityTheme theme) throws BussinessException;
	
	/**
	 * 发现社区模块话题评论
	 * @param reply
	 */
	void communityTopicReview(FindCommunityReply reply) throws BussinessException;
	
	/**
	 * 发现社区模块话题详情
	 * @param themeId
	 * @return
	 */
	Map<String, Object> communityTopicDetail(Integer themeId);
	
	/**
	 * 发现社区模块话题点赞回答
	 * 
	 * @param userId
	 * @param replyId
	 * @return
	 */
	void communityTopicReplyEffective(Integer userId, Integer replyId) throws BussinessException;
	
	/**
	 * 发现社区模块话题踩回答
	 * 
	 * @param userId
	 * @param replyId
	 * @return
	 */
	void communityTopicReplyIneffective(Integer userId, Integer replyId) throws BussinessException;
	
	/**
	 * 发现社区模块话题发布图片上传
	 * @param themeId
	 * @param fileName
	 */
	void communityTopicUpload(Integer themeId, String fileName) throws BussinessException;
	
	/**
	 * 发现社区模块话题回复图片上传
	 * @param themeId
	 * @param fileName
	 */
	void communityTopicReplyUpload(Integer replyId, String fileName) throws BussinessException;
	
	/**
	 * 我的发布
	 * @param userId
	 * @return
	 */
	Map<String, Object> userTopicPublish(Integer userId);
	
	/**
	 * 我的回复
	 * @param userId
	 * @return
	 */
	Map<String, Object> userTopicReply(Integer userId);
}
