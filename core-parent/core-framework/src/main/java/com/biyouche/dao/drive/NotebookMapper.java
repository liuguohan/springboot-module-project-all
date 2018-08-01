package com.biyouche.dao.drive;

import java.util.List;


import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.drive.vo.NotbookDetail;
import com.biyouche.domain.drive.vo.NotbookIco;

/**
 * 拿本栏目接口
 * @author hucong
 *
 */
public interface NotebookMapper {

	/**
	 * 查找所有拿本图标
	 * @return
	 */
	@Select("select id,icon,icon_name from drive_notebook where del_status = 0")
	List<NotbookIco> selectAllIco();
	
	
	/**
	 * 拿本图标详情
	 * @param id
	 * @return
	 */
	@Select("select title,content,create_time,look_num from drive_notebook where id = #{id} and del_status = 0")
	NotbookDetail notbookDetail(Integer id);
	
	@Update("update drive_notebook set look_num = look_num+1 where id = #{id} and del_status = 0")
	int updateLookNum(Integer id);
	
}
