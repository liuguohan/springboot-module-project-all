package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.vo.SkillsDetail;
import com.biyouche.domain.drive.vo.SkillsIco;

/**
 * 学车技巧接口
 * @author hc
 *
 */
public interface DriveSkillService {
	
	/**
	 * 学车技巧图标列表
	 * @param subject_type
	 * @return
	 */
	List<SkillsIco> skllsIcons(Integer subject_type);
	
	/**
	 * 学车技巧详情
	 * @param id
	 * @return
	 */
	SkillsDetail skillDetail(Integer id);

}
