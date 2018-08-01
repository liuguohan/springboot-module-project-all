package com.biyouche.service;

import java.util.Map;

/**
 * created by pht on 2018/7/27 0027
 */
public interface SubjectIndexService {
    Map<String,Object> subject2or3(Integer subject_type);

    Map<String,Object> subject1or4(Integer subject_type);
}
