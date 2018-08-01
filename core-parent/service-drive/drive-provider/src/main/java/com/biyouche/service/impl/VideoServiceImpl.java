package com.biyouche.service.impl;

/**
 * created by pht on 2018/7/26 0026
 */

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.drive.CommentMapper;
import com.biyouche.dao.drive.VideoMapper;
import com.biyouche.domain.drive.DriveVideo;
import com.biyouche.domain.drive.vo.CommentVo;
import com.biyouche.domain.drive.vo.DriveVideoVO;
import com.biyouche.domain.drive.vo.RecommendVO;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.VideoService;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/26 0026
 */
@Service("videoService")
public class VideoServiceImpl implements VideoService {

    private final static Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class);

    @Autowired
    private VideoMapper videoMapper;
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 学车视频列表
     *
     * @param subject_type
     * @param video_type
     * @return
     * @author pht
     */
    @Override
    public Map<String, Object> driveVideoList(Integer subject_type, Integer video_type) {

        //根据动态sql进行筛选视频列表
        List<DriveVideoVO> videoList = videoMapper.selectVideoList(subject_type, video_type);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("video_list", videoList);
        return resultMap;
    }

    /**
     * 视频详情
     *
     * @param video_id
     * @return
     * @author pht
     */
    @Override
    public Map<String, Object> videoDetail(Integer video_id) throws BussinessException {
        //通过id查出视频详情
        DriveVideo video = videoMapper.selectById(video_id);
        if (ValidatorUtils.isNull(video)) {
            throw new BussinessException(220000);
        }
        //加载相关推荐(随机策略,除本身外所有视频)
        List<RecommendVO> recommendList = videoMapper.selectRecommend(video_id);

        Map<String, Object> resultMap = JSON.parseObject(JSON.toJSONString(video), Map.class);
        resultMap.put("recommend_list",recommendList);

        //加载视频评论列表
        List<CommentVo> commentList = commentMapper.selectListByVideoId(video_id);
        resultMap.put("comment_list",commentList);

        resultMap.remove("admin_id");
        resultMap.remove("status");
        resultMap.remove("subject_type");
        resultMap.remove("video_id");
        return resultMap;
    }
}
