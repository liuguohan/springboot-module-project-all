package com.biyouche.controller.drive;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.drive.DriveTitleComment;
import com.biyouche.domain.drive.vo.TitleCommentVo;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.TitleCommentService;

/**
 * 题目相关接口
 * @author hc
 *
 */
@RestController
@RequestMapping("/title")
public class TitleController extends BaseController{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TitleController.class);
	
	@Autowired
	private TitleCommentService titleCommentService;
	
	
	 /**
     * 题目评价列表
     * @return
     * @author hucong
     */
    @PostMapping("titleCommentList")
    public ResponseObject titleCommentList(Integer subject_type, String title_no) {
        try {
        	LOGGER.info("题目评价列表");
        	ResponseObject dealSuccess = dealSuccess();
        	List<TitleCommentVo> title_comment_list = titleCommentService.titleCommentList(subject_type, title_no);
        	dealSuccess.content.put("title_comment_list", title_comment_list);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    /**
     * 题目评价点赞
     * @return
     * @author hucong
     */
    @PostMapping("titleCommentPraise")
    public ResponseObject titleCommentPraise(Integer title_comment_id) {
        try {
        	LOGGER.info("题目评价点赞");
        	ResponseObject dealSuccess = dealSuccess();
            titleCommentService.titlePraise(title_comment_id);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }
    
    /**
     * 评价题目
     * @return
     * @author hucong
     */
    @PostMapping("addTitleComment")
    public ResponseObject addTitleComment(@CurrentUser Integer user_id,String title_no,Integer subject_type,String comment) {
    	DriveTitleComment titleComment = null;
    	if(user_id==null) {
    		throw new BussinessException(200013);
    	}
        try {
        	LOGGER.info("题目评价");
        	ResponseObject dealSuccess = dealSuccess();
        	titleComment = new DriveTitleComment();
        	titleComment.setSubjectType(subject_type);
        	titleComment.setUserId(user_id);
        	titleComment.setTitleNo(title_no);
        	titleComment.setComment(comment);
        	titleCommentService.addTitleComment(titleComment);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }
    }

}
