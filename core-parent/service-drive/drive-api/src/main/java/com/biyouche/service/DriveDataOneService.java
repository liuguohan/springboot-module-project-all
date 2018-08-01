package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.vo.DriveTopicOneVo;

/**
 * 驾考一考题数据
 * @author hc
 *
 */
public interface DriveDataOneService {
	
	/**
	 * 科目一考题列表
	 * @return
	 */
	List<DriveTopicOneVo> driveTopicOneList(Integer subject_type);

}
