package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.NotbookAfterMapper;
import com.biyouche.domain.drive.vo.NotbookAfterDetail;
import com.biyouche.domain.drive.vo.NotbookAfterVo;
import com.biyouche.service.NotbookAfterService;

/**
 * 拿本以后服务
 * @author hucong
 *
 */
@Service("notbookAfterService")
public class NotbookAfterServiceImpl implements NotbookAfterService{
	
	@Autowired
	private NotbookAfterMapper notbookAfterDao;

	/**
	 * 拿本以后列表
	 * @return
	 */
	@Override
	public List<NotbookAfterVo> selectAll() {
		List<NotbookAfterVo> list = notbookAfterDao.selectAll();
		return list;
	}

	/**
	 * 拿本以后详情
	 * @return
	 */
	@Override
	public NotbookAfterDetail notbookAfterDetail(Integer id) {
		NotbookAfterDetail detail = notbookAfterDao.detail(id);
		//更新阅读次数
		if(detail!=null) {
			notbookAfterDao.updateLookNum(id);
		}
		return detail;
	}

}
