package com.biyouche.dao.drive;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.drive.vo.DriveTopicOneVo;

/**
 * 科目一考题
 * @author hc
 *
 */
public interface DriveTopicOneMapper {
	
	/**
	 * 科目一所有考题
	 * @return
	 */
	@Select("select * from drive_topic_one where subject_type = #{subject_type}")
	List<DriveTopicOneVo> selectAll(Integer subject_type);

}
