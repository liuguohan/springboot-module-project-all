package com.biyouche.service.impl;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.dao.apply.PraiseMapper;
import com.biyouche.dao.apply.SchoolMapper;
import com.biyouche.domain.apply.Evaluation;
import com.biyouche.domain.apply.Praise;
import com.biyouche.domain.apply.model.EvaluationVO;
import com.biyouche.domain.apply.model.SchoolDetail;
import com.biyouche.utils.TimeUtils;
import com.biyouche.utils.ValidatorUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.apply.PraiseMapper;
import com.biyouche.dao.apply.SchoolMapper;
import com.biyouche.dao.user.UserMapper;
import com.biyouche.domain.apply.Evaluation;
import com.biyouche.domain.user.User;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.PraiseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hucong
 */
@Service("praiseService")
@SuppressWarnings("rawtypes")
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private UserMapper userDao;

    @Autowired
    private SchoolMapper schoolDao;

    @Autowired
    private PraiseMapper praiseDao;

    @Autowired
    private PraiseMapper praiseMapper;

    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public int binding(String accessId,String school_id,String deviceType,Integer user_id) {
        Integer school_id1 = Integer.parseInt(school_id);
        User user = new User();
        user.setUserId(user_id);
        user.setSchoolId(school_id1);
        userDao.updateSchoolId(user);
        return user.getUserId();
    }

    /**
     * 驾校评价列表
     *
     * @param userId
     * @param schoolId
     * @return
     */
    @Override
    public Map<String, Object> evaluationList(Integer userId, Integer schoolId) {

        Map<String, Object> resultMap = new HashMap<>();

        //根据驾校id查出所有评价
        List<EvaluationVO> evaluationList = praiseMapper.selectBySchoolId(schoolId);
        //添加登录用户点赞状态
        if (!ValidatorUtils.isNull(userId)) {
            List<Integer> evIds = new ArrayList<>();
            for (EvaluationVO evaluation : evaluationList) {
                evIds.add(evaluation.getId());
            }
            if (evIds.size() > 0) {
                //返回该用户已点赞评论id
                List<Integer> evaluationIds = praiseMapper.selectPraiseByIds(userId, evIds);
                for (EvaluationVO evaluation : evaluationList) {
                    for (Integer id : evaluationIds) {
                        if (evaluation.getId().equals(id)) {
                            //设置评论点赞状态
                            evaluation.setIfPraise(1);
                        }
                    }
                }
            }
        }
        resultMap.put("evaluation_list", evaluationList);
        //驾校评分详情
        SchoolDetail schoolDetail = schoolMapper.schoolDetail(schoolId);
        //封装数据
        resultMap.put("school_name", schoolDetail.getName());
        resultMap.put("school_score", schoolDetail.getScore());
        resultMap.put("school_level", schoolDetail.getSchoolLevel());
        return resultMap;
    }

  
    @Override
    public String writePraise(String accessId,String deviceType,Integer user_id) throws BussinessException {
        //校验是否绑定驾校
        int schoolId = userDao.selectSchool(user_id);
        if (schoolId == 0) {
            throw new BussinessException(210009);
        }
        String schoolName = schoolDao.schoolName(schoolId);
        return schoolName;
    }

    @Override
    public int submitPraise(String accessId,String deviceType,String driver_speed,String environmental,String evaluation_content,String level,String school_id,String teaching_service, Integer user_id) {
        //获取参数
        Integer schoolId = Integer.parseInt(school_id);
        Integer level1 = Integer.parseInt(level);
        String evaluationContent = evaluation_content;
        Integer teachingService = Integer.parseInt(teaching_service);
        Integer environmental1 = Integer.parseInt(environmental);
        Integer driverSpeed = Integer.parseInt(driver_speed);
        Evaluation evaluation = new Evaluation();
        evaluation.setLevel(level1);
        evaluation.setSchoolId(schoolId);
        evaluation.setDriverSpeed(driverSpeed);
        evaluation.setEvaluationContent(evaluationContent);
        evaluation.setEnvironmental(environmental1);
        evaluation.setTeachingService(teachingService);
        evaluation.setUserId(user_id);
        praiseDao.insertEvaluation(evaluation);
        return evaluation.getId();
    }

    /**
     * 驾校评论点赞
     * @param userId
     * @param id
     * @return
     */
    @Override
    public void salute(Integer userId, Integer id) throws BussinessException {
        if (ValidatorUtils.isNull(userId)){
            throw new BussinessException(200013);
        }
        if (ValidatorUtils.isNull(id)){
            throw new BussinessException(210010);
        }
        //判断是否点过赞
        int count = praiseMapper.selectSaluteById(userId,id);
        if (count > 0){
            throw  new BussinessException(210011);
        }
        //添加点赞
        Praise praise = new Praise();
        praise.setUserId(userId);
        praise.setCreateTime(Integer.parseInt(TimeUtils.getCurrentTimeStamp() + ""));
        praise.setEvaluationId(id);
        int cow = praiseMapper.insertIntoSalute(praise);
        if (cow == 0){
            throw new BussinessException(210012);
        }
        //更新评论点赞数
        praiseMapper.updatePraiseNum(id);
    }
}
