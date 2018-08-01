package com.biyouche.service;

import com.biyouche.domain.drive.VideoComment;
import com.biyouche.exception.BussinessException;

import java.util.Map;

/**
 * created by pht on 2018/7/26 0026
 */
public interface CommentService {
    void submitComment(Integer userId, VideoComment comment) throws BussinessException;

    void praise(Integer useId, Integer comment_id) throws BussinessException;
}
