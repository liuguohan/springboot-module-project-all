package com.biyouche.controller.find;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.constants.ConfigConstant;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.find.FindCommunityReply;
import com.biyouche.domain.find.FindCommunityTheme;
import com.biyouche.enums.OssKeyEnum;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.FindCommunityService;
import com.biyouche.utils.ImageUtil;
import com.biyouche.utils.ValidatorUtils;

/**
 * 发现社区模块
 * @author lgh
 *
 */
@RequestMapping("/find/community")
@RestController
public class FindCommunityController extends BaseController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FindCommunityController.class);

	@Autowired
	private FindCommunityService findCommunityService;
	
	/**
     * 发现社区模块话题列表
     * @param findId
     * @return
     */
	@GetMapping("/communityTopicList")
    public ResponseObject communityTopicList(Integer findId) {
		try {
	        
			if( findId == null || findId.equals(0) ) {
				throw new BussinessException(230000);
			}
			
        	LOGGER.info("发现社区模块话题列表 >> findId =" + findId);
			return dealSuccess(findCommunityService.communityTopicList(findId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题发布标签初始化
     * @param userId
     * @return
     */
	@GetMapping("/initCommunityTopicPublishLabel")
    public ResponseObject initCommunityTopicPublishLabel(@CurrentUser String userId) {
		try {
	        
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			
        	LOGGER.info("发现社区模块话题发布标签初始化 >> userId =" + userId);
			return dealSuccess(findCommunityService.initCommunityTopicPublishLabel());	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题发布
     * @param userId
     * @param theme
     * @return
     */
	@PostMapping("/communityTopicPublish")
    public ResponseObject communityTopicPublish(@CurrentUser String userId, FindCommunityTheme theme) {
		try {
	        
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( theme.getFindId() == null || theme.getFindId().equals(0) ) {
				throw new BussinessException(230000);
			}
			if( ValidatorUtils.isEmpty( theme.getThemeTitle() )) {
				throw new BussinessException(230003);
			}
			if( ValidatorUtils.isEmpty( theme.getThemeContent() )) {
				throw new BussinessException(230004);
			}
			theme.setUserId(Integer.parseInt(userId));
			
        	LOGGER.info("发现社区模块话题发布 >> userId =" + userId + ",findId =" + theme.getFindId() + ",themeTitle =" + theme.getThemeTitle() + 
        			",themeContent =" + theme.getThemeTitle() + ",themeLabel=" + theme.getThemeLabel());
        	
        	findCommunityService.communityTopicPublish(theme);
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题详情
     * @param themeId
     * @return
     */
	@GetMapping("/communityTopicDetail")
    public ResponseObject communityTopicDetail(Integer themeId) {
		try {
	        
			if( themeId == null || themeId.equals(0) ) {
				throw new BussinessException(230005);
			}
			
        	LOGGER.info("发现社区模块话题详情 >> themeId =" + themeId);
			return dealSuccess(findCommunityService.communityTopicDetail(themeId));	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题评论
     * @param userId
     * @param reply
     * @return
     */
	@PostMapping("/communityTopicReplyReview")
    public ResponseObject communityTopicReplyReview(@CurrentUser String userId, FindCommunityReply reply) {
		try {
	        
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( reply.getThemeId() == null || reply.getThemeId().equals(0) ) {
				throw new BussinessException(230005);
			}
			if( ValidatorUtils.isEmpty( reply.getReplyContent() )) {
				throw new BussinessException(230006);
			}
			reply.setUserId(Integer.parseInt(userId));
			
        	LOGGER.info("发现社区模块话题评论 >> userId =" + userId + ",themeId =" + reply.getThemeId() + 
        			",replyContent =" + reply.getReplyContent());
        	
        	findCommunityService.communityTopicReview(reply);
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题点赞回答
     * @param userId
     * @param replyId
     * @return
     */
	@GetMapping("/communityTopicReplyEffective")
    public ResponseObject communityTopicReplyEffective(@CurrentUser String userId, String replyId) {
		try {
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( ValidatorUtils.isEmpty( replyId )) {
				throw new BussinessException(230007);
			}
			
        	LOGGER.info("发现社区模块话题点赞回答 >> replyId =" + replyId + ",userId =" + userId);
        	findCommunityService.communityTopicReplyEffective(Integer.parseInt(userId), Integer.parseInt(replyId));
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
     * 发现社区模块话题踩回答
     * @param userId
     * @param replyId
     * @return
     */
	@GetMapping("/communityTopicReplyIneffective")
    public ResponseObject communityTopicReplyIneffective(@CurrentUser String userId, String replyId) {
		try {
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( ValidatorUtils.isEmpty( replyId )) {
				throw new BussinessException(230007);
			}
			
        	LOGGER.info("发现社区模块话题踩回答 >> replyId =" + replyId + ",userId =" + userId);
        	findCommunityService.communityTopicReplyIneffective(Integer.parseInt(userId), Integer.parseInt(replyId));
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
	 * 发现社区模块话题发布图片上传
	 * @param userId
	 * @param themeId
	 * @param picType
	 * @param files
	 * @return
	 */
	@GetMapping("/communityTopicUpload")
    public ResponseObject communityTopicUpload(@CurrentUser String userId, Integer themeId, String picType, MultipartFile[] files) {
		try {
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( themeId == null || themeId.equals(0) ) {
				throw new BussinessException(230005);
			}
			if( ValidatorUtils.isEmpty( picType )) {
				throw new BussinessException(230008);
			}
			OssKeyEnum enums = OssKeyEnum.getKey(picType);
			if(enums==null){
				throw new BussinessException(230009);
			}
			
        	LOGGER.info("发现社区模块话题发布图片上传 >> themeId =" + themeId + ",picType =" + picType);
    		
        	List<String> pictureList = new ArrayList<String>();
    		for (MultipartFile f : files) {
    			//上传文件处理
    			String fileName = ImageUtil.upload(themeId, enums, f);
    			//业务处理
    			findCommunityService.communityTopicUpload(themeId, fileName);
    			pictureList.add(ConfigConstant.getInstance().PIC_URL_PREFIX + fileName);
    		}
    		
    		Map<String, Object> result = new LinkedHashMap<String, Object>();
    		result.put("pictureList", pictureList);
			return dealSuccess(result);	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	/**
	 * 发现社区模块话题回复图片上传
	 * @param userId
	 * @param replyId
	 * @param picType
	 * @param files
	 * @return
	 */
	@GetMapping("/communityTopicReplyUpload")
    public ResponseObject communityTopicReplyUpload(@CurrentUser String userId, Integer replyId, String picType, MultipartFile[] files) {
		try {
			if( ValidatorUtils.isEmpty( userId )) {
				throw new BussinessException(210003);
			}
			if( replyId == null || replyId.equals(0) ) {
				throw new BussinessException(230007);
			}
			if( ValidatorUtils.isEmpty( picType )) {
				throw new BussinessException(230008);
			}
			OssKeyEnum enums = OssKeyEnum.getKey(picType);
			if(enums==null){
				throw new BussinessException(230009);
			}
			
        	LOGGER.info("发现社区模块话题发布图片上传 >> replyId =" + replyId + ",picType =" + picType);
        	List<String> pictureList = new ArrayList<String>();
    		for (MultipartFile f : files) {
    			//上传文件处理
    			String fileName = ImageUtil.upload(replyId, enums, f);
    			//业务处理
    			findCommunityService.communityTopicUpload(replyId, fileName);
    			pictureList.add(ConfigConstant.getInstance().PIC_URL_PREFIX + fileName);
    		}
    		
    		Map<String, Object> result = new LinkedHashMap<String, Object>();
    		result.put("pictureList", pictureList);
			return dealSuccess();	
		} catch (Exception e) {
			return dealException(e);
		}
	}
	
	
}
