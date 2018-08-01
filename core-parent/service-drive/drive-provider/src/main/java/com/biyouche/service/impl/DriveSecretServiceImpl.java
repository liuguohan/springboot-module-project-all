package com.biyouche.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.drive.DriveSecretMapper;
import com.biyouche.domain.drive.vo.DriveSecretDetail;
import com.biyouche.domain.drive.vo.DriveSecretVo;
import com.biyouche.service.DriveSecretService;

/**
 * 驾考秘笈业务
 * @author hc
 *
 */
@Service("driveSecretService")
public class DriveSecretServiceImpl implements DriveSecretService{
	
	@Autowired
	private DriveSecretMapper driveSecretDao;

	@Override
	public List<DriveSecretVo> driveSecretList() {
		List<DriveSecretVo> list = driveSecretDao.driveSecretList();
		return list;
	}

	@Override
	public DriveSecretDetail driveSecretDetail(Integer id) {
		DriveSecretDetail detail = driveSecretDao.driveSecretDetail(id);
		//更新阅读数
		if(detail!=null) {
			driveSecretDao.updateLookNum(id);
		}
		return detail;
	}

	
}
