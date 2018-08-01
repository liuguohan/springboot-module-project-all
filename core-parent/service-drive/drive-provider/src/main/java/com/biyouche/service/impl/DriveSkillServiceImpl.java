package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.DriveSkillsMapper;
import com.biyouche.domain.drive.vo.SkillsDetail;
import com.biyouche.domain.drive.vo.SkillsIco;
import com.biyouche.service.DriveSkillService;

/**
 * 学车技巧业务
 * @author hc
 *
 */
@Service("driveSkillService")
public class DriveSkillServiceImpl implements DriveSkillService{

	
	@Autowired
	private DriveSkillsMapper driveSkillsMapper;
	
	@Override
	public List<SkillsIco> skllsIcons(Integer subject_type) {
		List<SkillsIco> skllsIcons = driveSkillsMapper.skllsIcons(subject_type);
		return skllsIcons;
	}

	@Override
	public SkillsDetail skillDetail(Integer id) {
		SkillsDetail skillDetail = driveSkillsMapper.skillDetail(id);
		return skillDetail;
	}

}
