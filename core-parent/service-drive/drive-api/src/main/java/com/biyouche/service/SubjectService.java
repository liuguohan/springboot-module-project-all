package com.biyouche.service;

import com.biyouche.domain.drive.SubjectComment;
import com.biyouche.domain.drive.Subjects;
import com.biyouche.exception.BussinessException;

import java.util.List;
import java.util.Map;

/**
 * created by pht on 2018/7/27 0027
 */
public interface SubjectService {

    Map<String,Object> subjectDetail(Integer subject_id) throws BussinessException;

    void submitComment(Integer userId, SubjectComment comment) throws BussinessException;

    void praise(Integer useId, Integer comment_id) throws BussinessException;

    List<Subjects> subjectList(Integer subject_type);
}
