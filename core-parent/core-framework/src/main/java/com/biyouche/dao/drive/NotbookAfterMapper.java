package com.biyouche.dao.drive;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.drive.vo.NotbookAfterDetail;
import com.biyouche.domain.drive.vo.NotbookAfterVo;

/**
 * 拿本以后
 * @author hucong
 *
 */
public interface NotbookAfterMapper {

	
	/**
	 * 拿本以后列表
	 * @return
	 */
	@Select("select id,title,image,look_num from drive_notebook_after where del_status = 0 order by create_time desc")
	List<NotbookAfterVo> selectAll();
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@Select("select title,content,create_time from drive_notebook_after where del_status = 0 and id = #{id}")
	NotbookAfterDetail detail(Integer id);
	
	
	/**
	 * @param 更新阅读次数
	 * @return
	 */
	@Update("update drive_notebook_after set look_num = look_num+1 where id = #{id} and del_status = 0")
	int updateLookNum(Integer id);
}
