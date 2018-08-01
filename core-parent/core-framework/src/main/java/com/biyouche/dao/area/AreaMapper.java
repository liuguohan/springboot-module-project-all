package com.biyouche.dao.area;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.area.Area;

/**
 * 省市区库
 * @author hucong
 *
 */
public interface AreaMapper {
	
	/**
	 * 根据父编码查询子编码
	 * @param areaNo
	 * @return
	 */
	@Select("select area_no,area_name from area where parent_area_no=#{areaNo}  order by area_no asc")
	List<Area> areas(String areaNo);
	
	/**
	 * 查询编码个数
	 * @param areaNo
	 * @return
	 */
	@Select("select count(0) c from area where area_no=#{areaNo} order by area_no asc")
	int areaNum(String areaNo);
	
	
	/**
	 * 查询编码名字
	 * @param areaNo
	 * @return
	 */
	@Select("select area_name from area where area_no=#{areaNo} and area_status = 1")
	String areaName(String areaNo);

}
