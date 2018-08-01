package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.NotebookMapper;
import com.biyouche.domain.drive.vo.NotbookDetail;
import com.biyouche.domain.drive.vo.NotbookIco;
import com.biyouche.service.NotbokService;

/**
 * 拿本栏目
 * @author hucong
 *
 */
@Service("notbokService")
public class NotbokServiceImpl implements NotbokService{

	@Autowired
	private NotebookMapper notebookDao;

	/**
	 * 查询所有图标
	 * @return
	 */
	@Override
	public List<NotbookIco> selectAllIco() {
		List<NotbookIco> allIco = notebookDao.selectAllIco();
		return allIco;
	}

	
	/**
	 * 拿本图标详情
	 * @param id
	 * @return
	 */
	@Override
	public NotbookDetail notbookDetail(Integer id) {
		NotbookDetail detail = notebookDao.notbookDetail(id);
		//更新阅读次数
		if(detail!=null) {
			notebookDao.updateLookNum(id);
		}
		return detail;
	}
}
