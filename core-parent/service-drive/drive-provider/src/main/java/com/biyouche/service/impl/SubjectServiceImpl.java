package com.biyouche.service.impl;

/**
 * created by pht on 2018/7/27 0027
 */

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.drive.CommentMapper;
import com.biyouche.dao.drive.SubjectMapper;
import com.biyouche.dao.drive.VideoMapper;
import com.biyouche.domain.drive.SubjectComment;
import com.biyouche.domain.drive.Subjects;
import com.biyouche.domain.drive.vo.CommentVo;
import com.biyouche.domain.drive.vo.RecommendVO;
import com.biyouche.domain.drive.vo.SubjectVO;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.SubjectService;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import groovy.util.IFileNameFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/27 0027
 */
@Service("subjectService")
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 科目二科三考试项目详情
     * @param subject_id
     * @return
     */
    @Override
    public Map<String, Object> subjectDetail(Integer subject_id) throws BussinessException {
        if (ValidatorUtils.isNull(subject_id)){
            throw new BussinessException(220003);
        }
        //查询详情
        SubjectVO vo = subjectMapper.selectDetailById(subject_id);
        Map<String,Object> resultMap = JSON.parseObject(JSON.toJSONString(vo), Map.class);

        //推荐列表
        List<RecommendVO> recommendList = videoMapper.getRecommend();
        resultMap.put("recommend_list",recommendList);

        //评论列表
        List<CommentVo> commentList = commentMapper.selectListBySubjectId(subject_id);
        resultMap.put("comment_list",commentList);

        return resultMap;
    }

    /**
     * 考试项目评论
     * @param userId
     * @param comment
     */
    @Override
    public void submitComment(Integer userId, SubjectComment comment) throws BussinessException {
        //校验登录状态
        if (ValidatorUtils.isNull(userId)){
            throw new BussinessException(200013);
        }
        //校验视频
        if (ValidatorUtils.isNull(comment.getSubject_id())){
            throw new BussinessException(220003);
        }

        //添加评论记录
        comment.setUser_id(userId);
        comment.setCreate_time(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        int cow = commentMapper.insertSubjectComment(comment);
        if (cow == 0){
            throw new BussinessException(220001);
        }
    }

    /**
     * 给评论点赞
     * @param useId
     * @param comment_id
     */
    @Override
    public void praise(Integer useId, Integer comment_id) throws BussinessException {
        //校验登录
        if (ValidatorUtils.isNull(useId)){
            throw new BussinessException(200013);
        }
        //检验评论id
        if (ValidatorUtils.isNull(comment_id)){
            throw new BussinessException(220002);
        }

        //更新评论点赞数
        commentMapper.updateSubjectPraiseNum(comment_id);
    }

    /**
     * 考试项目详解列表
     * @param subject_type
     * @return
     */
    @Override
    public List<Subjects> subjectList(Integer subject_type) {
        List<Subjects> subjectsList = subjectMapper.selectListByType(subject_type);
        return subjectsList;
    }
}
