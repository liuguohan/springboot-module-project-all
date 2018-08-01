package com.biyouche.dao.drive;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.drive.vo.DriveSecretDetail;
import com.biyouche.domain.drive.vo.DriveSecretVo;

/**
 * 考试秘笈表
 * @author hc
 *
 */
public interface DriveSecretMapper {

	/**
	 * 列表
	 * @return
	 */
	@Select("select id,title,image,look_num from drive_secret where del_status = 0")
	List<DriveSecretVo>  driveSecretList();
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@Select("select title,content,create_time from drive_secret where del_status = 0 and id = #{id}")
	DriveSecretDetail driveSecretDetail(Integer id);
	
	/**
	 * @param 更新阅读次数
	 * @return
	 */
	@Update("update drive_secret set look_num = look_num+1 where id = #{id} and del_status = 0")
	int updateLookNum(Integer id);
}
