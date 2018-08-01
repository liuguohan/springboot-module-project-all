package com.biyouche.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biyouche.constants.ConfigConstant;
import com.biyouche.constants.FindConstant;
import com.biyouche.dao.find.FindCommunityMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.domain.find.FindCommunityReply;
import com.biyouche.domain.find.FindCommunityTheme;
import com.biyouche.domain.find.model.FindCommunityReplyModel;
import com.biyouche.domain.find.model.FindCommunityThemeModel;
import com.biyouche.domain.find.model.UserTopicPublishModel;
import com.biyouche.domain.find.model.UserTopicReplyModel;
import com.biyouche.domain.user.User;
import com.biyouche.enums.DictTypeEnum;
import com.biyouche.exception.BussinessException;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.service.FindCommunityService;
import com.biyouche.utils.DictUtil;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;

/**
 * 发现资讯模块业务实现
 * @author lgh
 *
 */
@Service("findCommunityService")
public class FindCommunityServiceImpl implements FindCommunityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindCommunityServiceImpl.class);
    
    @Autowired
    private FindCommunityMapper findCommunityMapper;
    
    @Autowired
    private UserMapper userMapper;


	@Override
	@Cacheable(key = RedisKeyPrefix.COMMUNITY_TOPIC_LIST + "#findId", expire = ExpireTime.FIVE_MIN)
	public Map<String, Object> communityTopicList(Integer findId) {
		
		LOGGER.info("发现社区模块话题列表查询库 ......");
		
		List<FindCommunityThemeModel> findCommunityThemeList = findCommunityMapper.communityTopicList(findId, FindConstant.DELSTATUS_VALID);
		List<FindCommunityThemeModel> specialThemeList = new ArrayList<FindCommunityThemeModel>();
		if( ValidatorUtils.isNotEmpty(findCommunityThemeList) ) {
			
			for( FindCommunityThemeModel model : findCommunityThemeList ) {
				
				model.setAvatarUrl(ConfigConstant.getInstance().PIC_URL_PREFIX + model.getAvatarUrl());
				
				//筛选精选话题
				Integer themeType = model.getThemeType();
				themeType = (themeType == null?0:themeType);
				if( themeType.equals(FindConstant.THEMETYPE_SPECIAL) ) {
					specialThemeList.add(model);
				}
			}
		}
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("normalThemeList", findCommunityThemeList);
		result.put("specialThemeList", specialThemeList);
		
		return result;
	}


	@Override
	public Map<String, Object> initCommunityTopicPublishLabel() {
		
		List<Dict> labelList = DictUtil.getDict(DictTypeEnum.COMMUNITY_TOPIC_LABEL.KEY);
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("labelList", labelList);
		return result;
	}


	@Override
	public void communityTopicPublish(FindCommunityTheme theme) throws BussinessException {
		
		//获取用户信息
		
		Integer userId = theme.getUserId();
		ValidatorUtils.communityTopicUserInfoValid(userId);
		
		//发布话题
		
		int result = findCommunityMapper.communityTopicPublish(theme);
		if( result != 1 ) {
			throw new BussinessException(230010);
		}
	}


	@Override
	@Transactional
	public void communityTopicReview(FindCommunityReply reply) throws BussinessException {
		
		//获取用户信息
		
		Integer userId = reply.getUserId();
		ValidatorUtils.communityTopicUserInfoValid(userId);
		
		//发布评论
		
		int result = findCommunityMapper.communityTopicReview(reply);
		if( result != 1 ) {
			throw new BussinessException(230011);
		}
		
		//修改话题回答数
		
		result = findCommunityMapper.updateCommunityThemeReplyNumByThemeId(reply.getThemeId());
		if( result != 1 ) {
			throw new BussinessException(230012);
		}
	}


	@Override
	public Map<String, Object> communityTopicDetail(Integer themeId) {
		
		//阿里云地址前缀
		String aliyunPrefix = ConfigConstant.getInstance().PIC_URL_PREFIX;
		
		//话题信息
		
		FindCommunityTheme theme = findCommunityMapper.selectFindCommunityThemeByThemeId(themeId);
		User themeUser = userMapper.selectUserById(theme.getUserId());
		//话题图片信息
		
		List<String> themeImageList = findCommunityMapper.selectFindCommunityThemeImageByThemeId(themeId, FindConstant.DELSTATUS_VALID);
		for( String themeImage : themeImageList ) {
			themeImage = aliyunPrefix + themeImage;
		}
		
		
		//回复信息
		
		List<FindCommunityReplyModel> findCommunityReplyModelList = findCommunityMapper.communityTopicReplyList(themeId, FindConstant.DELSTATUS_VALID);
		if( ValidatorUtils.isNotEmpty(findCommunityReplyModelList) ) {
			
			for( FindCommunityReplyModel replyModel : findCommunityReplyModelList ) {
				replyModel.setCreateTimeStr(TimeUtils.timeStampToDateStr(replyModel.getCreateTime(), TimeUtils.yyyy_MM_ddHHmm));
				replyModel.setAvatarUrl(aliyunPrefix + replyModel.getAvatarUrl());
				//话题回复图片信息
				
				List<String> replyImageList = findCommunityMapper.selectFindCommunityReplyImageByReplyId(replyModel.getReplyId(), FindConstant.DELSTATUS_VALID);
				for( String replyImage : replyImageList ) {
					replyImage = aliyunPrefix + replyImage;
				}
				replyModel.setReplyImageList(replyImageList);
			}
		}
		
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("avatarUrl", aliyunPrefix + themeUser.getAvatarUrl());
		result.put("nickName", themeUser.getNickName());
		result.put("themeType", theme.getThemeType());
		result.put("createTime", TimeUtils.timeStampToDateStr(theme.getCreateTime(), TimeUtils.yyyy_MM_ddHHmm));
		result.put("themeTitle", theme.getThemeTitle());
		result.put("themeContent", theme.getThemeContent());
		result.put("replyNum", theme.getReplyNum());
		result.put("themeImageList", themeImageList);
		result.put("findCommunityReplyModelList", findCommunityReplyModelList);
		return result;
	}


	@Override
	@Transactional
	public void communityTopicReplyEffective(Integer userId, Integer replyId) throws BussinessException {
		
		//对社区话题回复点赞且仅能点赞一次
		Integer likeId =  findCommunityMapper.selectFindCommunityUserReplyLikeByReplyIdAndUserId(userId, replyId);
		int result = 0;
		if(likeId == null || likeId.equals(0)) {
			result = findCommunityMapper.updateFindCommunityReplyEffectiveNumByReplyId(replyId);
			if( result != 1 ) {
				throw new BussinessException(230013);
			}
			result = findCommunityMapper.insertFindCommunityUserReplyLike(userId, replyId);
			if( result != 1 ) {
				throw new BussinessException(230014);
			}
		}
	
	}


	@Override
	@Transactional
	public void communityTopicReplyIneffective(Integer userId, Integer replyId) throws BussinessException {
		
		//对社区话题回复踩且仅能踩一次
		Integer treadId =  findCommunityMapper.selectFindCommunityUserReplyLikeByReplyIdAndUserId(userId, replyId);
		int result = 0;
		if(treadId == null || treadId.equals(0)) {
			result = findCommunityMapper.updateFindCommunityReplyIneffectiveNumByReplyId(replyId);
			if( result != 1 ) {
				throw new BussinessException(230015);
			}
			result = findCommunityMapper.insertFindCommunityUserReplyTread(userId, replyId);
			if( result != 1 ) {
				throw new BussinessException(230016);
			}
		}
	}


	@Override
	public void communityTopicUpload(Integer themeId, String fileName) throws BussinessException {
		
		int result = findCommunityMapper.communityTopicUpload(themeId, fileName);
		if( result != 1 ) {
			throw new BussinessException(230017);
		}	
	}


	@Override
	public void communityTopicReplyUpload(Integer replyId, String fileName) throws BussinessException {
		
		int result = findCommunityMapper.communityTopicReplyUpload(replyId, fileName);
		if( result != 1 ) {
			throw new BussinessException(230018);
		}
	}


	@Override
	public Map<String, Object> userTopicPublish(Integer userId) {
		
		List<UserTopicPublishModel> userTopicPublishList = findCommunityMapper.userTopicPublish(userId, FindConstant.DELSTATUS_VALID);
		if( ValidatorUtils.isNotEmpty(userTopicPublishList) ) {
			
			for( UserTopicPublishModel model : userTopicPublishList ) {
				
				model.setAvatarUrl(ConfigConstant.getInstance().PIC_URL_PREFIX + model.getAvatarUrl());
				model.setCreateTimeStr(TimeUtils.timeStampToDateStr(model.getCreateTime(), TimeUtils.yyyy_MM_ddHHmm));
			}
		}
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("userTopicPublishList", userTopicPublishList);
		return result;
	}


	@Override
	public Map<String, Object> userTopicReply(Integer userId) {
		
		//阿里云地址前缀
		String aliyunPrefix = ConfigConstant.getInstance().PIC_URL_PREFIX;
		
		List<UserTopicReplyModel> userTopicReplyList = findCommunityMapper.userTopicReply(userId, FindConstant.DELSTATUS_VALID);
		if( ValidatorUtils.isNotEmpty(userTopicReplyList) ) {
			
			for( UserTopicReplyModel model : userTopicReplyList ) {
				
				model.setCreateTimeStr(TimeUtils.timeStampToDateStr(model.getCreateTime(), TimeUtils.yyyy_MM_ddHHmm));
				model.setAvatarUrl(aliyunPrefix + model.getAvatarUrl());
				//话题回复图片信息
				
				List<String> replyImageList = findCommunityMapper.selectFindCommunityReplyImageByReplyId(model.getReplyId(), FindConstant.DELSTATUS_VALID);
				for( String replyImage : replyImageList ) {
					replyImage = aliyunPrefix + replyImage;
				}
				model.setReplyImageList(replyImageList);
			}
		}
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("userTopicReplyList", userTopicReplyList);
		return result;
	}

   
}
