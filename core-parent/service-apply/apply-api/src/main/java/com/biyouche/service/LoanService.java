package com.biyouche.service;

import com.biyouche.domain.loan.LearnLoan;
import com.biyouche.exception.BussinessException;

import java.util.Map;

public interface LoanService {
    Map<String,Object> toApplyLoan(Integer userId) throws BussinessException;

    void submitApply(LearnLoan learnLoan) throws BussinessException;

    Map<String,Object> auditResult(Integer userId) throws BussinessException;

    Map<String,Object> toApplyCard(Integer userId) throws BussinessException;
}
