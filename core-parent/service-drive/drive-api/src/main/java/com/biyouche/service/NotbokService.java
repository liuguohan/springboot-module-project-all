package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.vo.NotbookDetail;
import com.biyouche.domain.drive.vo.NotbookIco;

/**
 * 拿本栏目
 * @author hucong
 *
 */
public interface NotbokService {
	
	/**
	 * 查询所有图标
	 * @return
	 */
	List<NotbookIco> selectAllIco();
	
	

	/**
	 * 拿本图标详情
	 * @param id
	 * @return
	 */
	NotbookDetail notbookDetail(Integer id);

}
