package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.TitleCommentMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.drive.DriveTitleComment;
import com.biyouche.domain.drive.vo.TitleCommentVo;
import com.biyouche.domain.user.User;
import com.biyouche.service.TitleCommentService;

/**
 * 科一 科四题目评论业务
 * @author hc
 *
 */
@Service("titleCommentService")
public class TitleCommentServiceImpl implements TitleCommentService{

	@Autowired
	private TitleCommentMapper titleCommentDao;
	
	@Autowired
	private UserMapper userDao;
	
	
	@Override
	public List<TitleCommentVo> titleCommentList(Integer subject_type, String title_no) {
		
		List<TitleCommentVo> list = titleCommentDao.titleCommentList(subject_type, title_no);
		//查询用户头像信息和昵称
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				User user = userDao.selectUserById(list.get(i).getUser_id());
				if(user!=null) {
					list.get(i).setAvatar_url(user.getAvatarUrl());
					list.get(i).setNick_name(user.getNickName());
				}
			}
		}
		
		return list;
	}


	@Override
	public int titlePraise(Integer id) {
		int praise = titleCommentDao.praise(id);
		return praise;
	}


	@Override
	public int addTitleComment(DriveTitleComment comment) {
		int addComment = titleCommentDao.addComment(comment);
		return addComment;
	}

}
