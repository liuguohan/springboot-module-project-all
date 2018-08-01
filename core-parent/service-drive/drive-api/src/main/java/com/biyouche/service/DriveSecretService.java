package com.biyouche.service;

import java.util.List;

import com.biyouche.domain.drive.vo.DriveSecretDetail;
import com.biyouche.domain.drive.vo.DriveSecretVo;

/**
 * 驾考秘笈接口
 * @author hc
 *
 */
public interface DriveSecretService {

	/**
	 * 列表
	 * @return
	 */
	List<DriveSecretVo>  driveSecretList();
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	DriveSecretDetail driveSecretDetail(Integer id);
}
