package com.biyouche.service.impl;

/**
 * created by pht on 2018/7/27 0027
 */

import com.biyouche.dao.drive.BannerMapper;
import com.biyouche.dao.drive.DriveSkillsMapper;
import com.biyouche.dao.drive.SubjectMapper;
import com.biyouche.dao.drive.VideoMapper;
import com.biyouche.domain.drive.Subjects;
import com.biyouche.domain.drive.vo.BannerVO;
import com.biyouche.domain.drive.vo.DriveVideoVO;
import com.biyouche.domain.drive.vo.SkillsIco;
import com.biyouche.domain.drive.vo.SubjectVO;
import com.biyouche.service.SubjectIndexService;
import com.biyouche.service.SubjectService;
import com.biyouche.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @program core-parent
 * @date 2018/7/27 0027
 * @author pht
 */
@Service("subjectIndexService")
public class SubjectIndexServiceImpl implements SubjectIndexService {

    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private DriveSkillsMapper driveSkillsMapper;
    /**
     * 科目二科目三首页
     * @param subject_type
     * @return
     */
    @Override
    public Map<String, Object> subject2or3(Integer subject_type) {
        //加载banner图
        BannerVO banner = bannerMapper.getBanner(subject_type);
        //考试项目详解列表
        List<Subjects> subjects = subjectMapper.selectListByType(subject_type);
        //视频精选
        List<DriveVideoVO> driveVideoVOS = videoMapper.selectVideoList(subject_type, 2);
        //驾考技巧列表
        List<SkillsIco> skillsIcos = driveSkillsMapper.skllsIcons(subject_type);

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("banner_image",banner);
        resultMap.put("subject_list",subjects);
        resultMap.put("video_list",driveVideoVOS);
        resultMap.put("skill_list",skillsIcos);
        //添加驾考问答
        return resultMap;
    }

    @Override
    public Map<String, Object> subject1or4(Integer subject_type) {
        //加载banner图
        BannerVO banner = bannerMapper.getBanner(subject_type);
        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("banner_image",banner);
        return resultMap;
    }
}
