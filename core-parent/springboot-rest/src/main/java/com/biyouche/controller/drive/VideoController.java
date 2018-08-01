package com.biyouche.controller.drive;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.drive.VideoComment;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.CommentService;
import com.biyouche.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 视频相关接口
 */
@RestController
@RequestMapping("/video")
public class VideoController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;
    @Autowired
    private CommentService commentService;

    /**
     * 科目二科目三视频列表(包含学车视频与视频精选)
     *
     * @param subject_type 科目类型 (0:科二,1:科三)
     * @param video_type   视频类型(0:学车视频,1:视频精选)
     * @return
     * @author pht
     */
    @PostMapping("/videoList")
    public ResponseObject driveVideoList(Integer subject_type, Integer video_type) {
        try {
            LOGGER.info(subject_type == 0 ? "科目二" : "科目三" + (video_type == 0 ? "学车视频" : "视频精选") + "列表请求参数:" + "subject_type = " + subject_type + ",video_type = " + video_type);
            Map<String, Object> resultMap = videoService.driveVideoList(subject_type, video_type);
            LOGGER.info(subject_type == 0 ? "科目二" : "科目三" + (video_type == 0 ? "学车视频" : "视频精选") + "列表响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 视频详情
     *
     * @param video_id
     * @return
     * @author pht
     */
    @PostMapping("/videoDetail")
    public ResponseObject videoDetail(Integer video_id) {
        LOGGER.info("视频详情请求参数:video_id" + video_id);
        try {
            Map<String, Object> resultMap = videoService.videoDetail(video_id);
            LOGGER.info("视频详情响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 视频评论
     *
     * @param userId
     * @param comment
     * @return
     */
    @PostMapping("/comment")
    public ResponseObject submitComment(@CurrentUser Integer userId, VideoComment comment) {
        LOGGER.info("视频评论请求参数:comment = " + comment + ",user_id = " + userId);
        try {
            commentService.submitComment(userId, comment);
            LOGGER.info("视频评论响应参数:" + dealSuccess().info);
            return dealSuccess();
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 给评论点赞
     *
     * @param useId
     * @param comment_id
     * @return
     */
    @PostMapping("/commentPraise")
    public ResponseObject commentPraise(@CurrentUser Integer useId, Integer comment_id) {
        LOGGER.info("视频评论点赞请求参数:userId = " + useId + ",comment_id = " + comment_id);
        try {
            commentService.praise(useId, comment_id);
            LOGGER.info("视频评论点赞响应参数:" + dealSuccess().info);
            return dealSuccess();
        } catch (Exception e) {
            return dealException(e);
        }
    }
}
