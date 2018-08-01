package com.biyouche.controller.drive;
/**
 * created by pht on 2018/7/27 0027
 */

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.drive.SubjectComment;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 驾考项目相关
 * @program core-parent
 * @date 2018/7/27 0027
 * @author pht
 */

@RestController
@RequestMapping("/subject")
public class SubjectController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private SubjectService subjectService;
    /**
     * 科二科三考试项目详情
     * @param subject_id
     * @return
     */
    @PostMapping("/detail")
    public ResponseObject subjectDetail(Integer subject_id){
        try{
            Map<String,Object> resultMap = subjectService.subjectDetail(subject_id);
            return dealSuccess(resultMap);
        }catch (Exception e){
            return dealException(e);
        }
    }

    /**
     * 考试项目评论
     *
     * @param userId
     * @param comment
     * @return
     */
    @PostMapping("/comment")
    public ResponseObject submitComment(@CurrentUser Integer userId, SubjectComment comment) {
        LOGGER.info("考试项目请求参数:comment = " + comment + ",user_id = " + userId);
        try {
            subjectService.submitComment(userId, comment);
            LOGGER.info("考试项目评论响应参数:" + dealSuccess().info);
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
        LOGGER.info("考试项目评论点赞请求参数:userId = " + useId + ",comment_id = " + comment_id);
        try {
            subjectService.praise(useId, comment_id);
            LOGGER.info("考试项目评论点赞响应参数:" + dealSuccess().info);
            return dealSuccess();
        } catch (Exception e) {
            return dealException(e);
        }
    }

}
