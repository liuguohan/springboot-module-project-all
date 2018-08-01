package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.vo.NotbookAfterDetail;
import com.biyouche.domain.drive.vo.NotbookAfterVo;

/**
 * 拿本以后接口
 * @author hucong
 *
 */
public interface NotbookAfterService {

	
	/**
	 * 拿本以后列表
	 * @return
	 */
	List<NotbookAfterVo> selectAll();
	
	/**
	 * 拿本以后详情
	 * @param id
	 * @return
	 */
	NotbookAfterDetail notbookAfterDetail(Integer id);
}
