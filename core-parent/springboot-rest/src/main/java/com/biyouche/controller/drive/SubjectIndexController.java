package com.biyouche.controller.drive;

/**
 * created by pht on 2018/7/27 0027
 */

import com.biyouche.controller.BaseController;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.SubjectIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author pht
 * @program core-parent
 * @date 2018/7/27 0027
 */
@RestController
@RequestMapping("/subjectIndex")
public class SubjectIndexController extends BaseController {


    private final static Logger LOGGER = LoggerFactory.getLogger(SubjectIndexController.class);

    @Autowired
    private SubjectIndexService indexService;

    /**
     * 科目一和科目二首页
     *
     * @param subject_type
     * @return
     */
    @PostMapping("/exam")
    public ResponseObject subject1or4(Integer subject_type) {
        LOGGER.info((subject_type == 1 ? "科目一" : "科目四") + "首页请求参数:" + "subject_type = " + subject_type);
        try {
            Map<String, Object> resultMap = indexService.subject1or4(subject_type);
            LOGGER.info((subject_type == 1 ? "科目一" : "科目四") + "首页响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 科目二与科目三首页
     *
     * @return
     */
    @PostMapping("/driving")
    public ResponseObject subject2or3(Integer subject_type) {
        LOGGER.info((subject_type == 2 ? "科目二" : "科目三") + "首页请求参数:" + "subject_type = " + subject_type);
        try {
            Map<String, Object> resultMap = indexService.subject2or3(subject_type);
            LOGGER.info((subject_type == 2 ? "科目二" : "科目三") + "首页响应参数:" + resultMap);
            return dealSuccess(resultMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }
}
