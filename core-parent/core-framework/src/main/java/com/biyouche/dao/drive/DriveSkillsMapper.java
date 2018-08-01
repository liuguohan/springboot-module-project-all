package com.biyouche.dao.drive;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.drive.vo.SkillsDetail;
import com.biyouche.domain.drive.vo.SkillsIco;

/**
 * 考试技巧表
 * @author hc
 *
 */
public interface DriveSkillsMapper {

	/**
	 * 根据科目类型查询标题
	 * @param subject_type
	 * @return
	 */
	@Select("select id,icon,icon_name,icon_label from drive_skills where subject_type = #{subject_type} and del_status = 0")
	List<SkillsIco> skllsIcons(Integer subject_type);
	
	/**
	 * 驾考技巧内容
	 * @param id
	 * @return
	 */
	@Select("select title,content,create_time from drive_skills where id = #{id} and del_status = 0")
	SkillsDetail skillDetail(Integer id);
}
