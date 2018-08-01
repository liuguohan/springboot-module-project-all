package com.biyouche.service;

import com.biyouche.domain.apply.Apply;
import com.biyouche.domain.apply.Needs;
import com.biyouche.exception.BussinessException;

import java.util.Map;

public interface ApplyService {

    Map<String,Object> toApply(Integer userId) throws BussinessException;

    Map<String,Object> submit(Apply needs) throws BussinessException;
}
