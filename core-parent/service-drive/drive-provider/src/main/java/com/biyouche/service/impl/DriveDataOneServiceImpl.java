package com.biyouche.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.DriveTopicOneMapper;
import com.biyouche.domain.drive.vo.DriveTopicOneVo;
import com.biyouche.service.DriveDataOneService;
import com.biyouche.utils.ArrToList;

/**
 * 驾考科目一试题
 * @author hc
 *
 */
@Service("driveDataOneService")
public class DriveDataOneServiceImpl implements DriveDataOneService{
	
	
	@Autowired
	private DriveTopicOneMapper driveTopicOneMapper;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<DriveTopicOneVo> driveTopicOneList(Integer subject_type) {
		List<DriveTopicOneVo> list = driveTopicOneMapper.selectAll(subject_type);
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				List selelc = ArrToList.arrtoList(list.get(i).getAnswer_select().split("&"));//答案选项
				List anserw = ArrToList.arrtoList(list.get(i).getAnswer().split("&"));//正确答案
				List an = new ArrayList();//答案下标数组
				list.get(i).setSelectArr(selelc);
				list.get(i).setAnswerArr(anserw);
				if(selelc.size()>0) {
					for(int k=0;k<selelc.size();k++) {
						for(int j=0;j<anserw.size();j++) {
							if(anserw.get(j).equals(selelc.get(k))) {
								an.add(k);
							}
						}
					}
					list.get(i).setAnswerArrIndex(an);
					}
			}
			
		}
		return list;
	}

}
