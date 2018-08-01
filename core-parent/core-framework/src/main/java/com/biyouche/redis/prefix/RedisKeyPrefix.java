package com.biyouche.redis.prefix;

/**
 * redis 项目前缀
 * @author lgh
 *
 */
public class RedisKeyPrefix {

	private RedisKeyPrefix(){}
	
	public final static String DEMOPREFIX = "biyouche:";

	public final static String USER_TOKEN_PREFIX = "userToken:accessId:";

	
	/**
	 * vip学车保险套餐
	 */
	public final static String VIP_INSURANCE_LIST = "insuranceController:vipInsuranceService:vipInsuranceList";
	
	/**
	 * 首页搜索标签驾校信息
	 */
	public final static String SEARCH_SCHOOL_LIST_BY_LABEL = "indexController:indexService:searchSchoolListByLabel:";
	
	/**
	 * 发现模块初始化
	 */
	public final static String FIND_INITIALIZATION = "findController:findService:findInitialization";
	
	/**
	 * 发现资讯子模块文章列表
	 */
	public final static String SUBMODULE_ARTICLE_LIST = "findInfoController:findInfoService:submoduleArticleList:";
	
	/**
	 * 发现资讯子模块文章详情
	 */
	public final static String SUBMODULE_ARTICLE_DETAIL = "findInfoController:findInfoService:submoduleArticleDetail:";
	
	/**
	 * 发现社区模块话题列表
	 */
	public final static String COMMUNITY_TOPIC_LIST = "findCommunityController:findCommunityService:communityTopicList:";
	
	/**
	 * 发现活动模块活动列表
	 */
	public final static String ACTIVITY_LIST = "findActivityController:findActivityService:activityList:";
	
	/**
	 * 发现活动模块活动详情
	 */
	public final static String ACTIVITY_DETAIL = "findActivityController:findActivityService:activityDetail:";
	
}
