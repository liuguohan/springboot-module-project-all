package com.biyouche.controller.drive;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.drive.vo.DriveTopicOneVo;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.DriveDataOneService;


/**
 * 考题有管接口
 * @author hc
 *
 */
@RestController
@RequestMapping("/question")
public class TestQuestionController extends BaseController{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TestQuestionController.class);
	
	
	@Autowired
	private DriveDataOneService driveDataOneService;
	
	 /**
     * 科目一题目
     * @return
     * @author hucong
     */
   @PostMapping("driveTopicOneList")
   public ResponseObject driveTopicOneList(Integer subject_type) {
  
       try {
       	LOGGER.info("科目一考题");
       	ResponseObject dealSuccess = dealSuccess();
       	List<DriveTopicOneVo> drive_topicOneList = driveDataOneService.driveTopicOneList(subject_type);
       	dealSuccess.content.put("drive_topicOneList", drive_topicOneList);
           return dealSuccess;
       } catch (Exception e) {
           return dealException(e);
       }
    }

}
