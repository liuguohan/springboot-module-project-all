package com.biyouche.service.impl;

/**
 * created by pht on 2018/7/26 0026
 */

import com.biyouche.dao.drive.CommentMapper;
import com.biyouche.dao.drive.VideoMapper;
import com.biyouche.domain.drive.VideoComment;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.CommentService;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @program core-parent
 * @date 2018/7/26 0026
 * @author pht
 */
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private VideoMapper videoMapper;
    /**
     * 评论
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public void submitComment(Integer userId, VideoComment comment) throws BussinessException {

        //校验登录状态
        if (ValidatorUtils.isNull(userId)){
            throw new BussinessException(200013);
        }
        //校验视频
        if (ValidatorUtils.isNull(comment.getVideo_id())){
            throw new BussinessException(220000);
        }

        //添加评论记录
        comment.setUser_id(userId);
        comment.setCreate_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        int cow = commentMapper.insertComment(comment);
        if (cow == 0){
            throw new BussinessException(220001);
        }
        //更新视频评论数
        videoMapper.updateCommentNum(comment.getVideo_id());
    }

    /**
     * 给评论点赞
     * @param useId
     * @param comment_id
     */
    @Override
    public void praise(Integer useId, Integer comment_id) throws BussinessException{
        //校验登录
        if (ValidatorUtils.isNull(useId)){
            throw new BussinessException(200013);
        }
        //检验评论id
        if (ValidatorUtils.isNull(comment_id)){
            throw new BussinessException(220002);
        }

        //更新评论点赞数
        commentMapper.updatePraiseNum(comment_id);
    }
}
