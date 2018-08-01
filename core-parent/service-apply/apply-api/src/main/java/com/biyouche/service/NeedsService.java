package com.biyouche.service;

import com.biyouche.domain.apply.Needs;
import com.biyouche.domain.apply.NeedsCancel;
import com.biyouche.exception.BussinessException;

import java.util.List;
import java.util.Map;

public interface NeedsService {
    List<Map<String, Object>> factorList();

    Map<String, Object> applyNeeds(Integer user_id) throws BussinessException;

    Map<String, Object> submitNeeds(Needs content) throws BussinessException;

    Map<String, Object> feedback();

    Map<String, Object> cancelNeeds();

    void confirmCancel(NeedsCancel needsCancel,Integer userId) throws BussinessException;
}
