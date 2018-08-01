package com.biyouche.service;

import com.biyouche.exception.BussinessException;

import java.util.Map;

/**
 * created by pht on 2018/7/26 0026
 */
public interface VideoService {
    Map<String, Object> driveVideoList(Integer subject_type, Integer video_type);

    Map<String, Object> videoDetail(Integer video_id) throws BussinessException;
}
