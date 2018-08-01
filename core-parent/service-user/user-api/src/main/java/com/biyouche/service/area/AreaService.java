package com.biyouche.service.area;

import java.util.List;

import com.biyouche.domain.area.Area;
import com.biyouche.exception.BussinessException;

/**
 * 地区编码服务
 * @author hucong
 *
 */
public interface AreaService {
	
	/**
	 * 根据父编码查询子编码
	 * @return
	 */
	List<Area> subArea(String areaNo) throws BussinessException;

}
