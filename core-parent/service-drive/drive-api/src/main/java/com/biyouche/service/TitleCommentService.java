package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.DriveTitleComment;
import com.biyouche.domain.drive.vo.TitleCommentVo;

/**
 * 科一 科四题目评论接口
 * @author hc
 *
 */
public interface TitleCommentService {
	
	
	/**
	 * 题目评论列表
	 * @return
	 */
	List<TitleCommentVo> titleCommentList(Integer subject_type, String title_no);
	
	/**
	 * 点赞
	 * @param id
	 * @return
	 */
	int titlePraise(Integer id);
	
	/**
	 * 评价
	 * @param comment
	 * @return
	 */
	int addTitleComment(DriveTitleComment comment);

}
