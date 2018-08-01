package com.biyouche.service.impl.area;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.biyouche.dao.area.AreaMapper;
import com.biyouche.domain.area.Area;
import com.biyouche.exception.BussinessException;
import com.biyouche.service.area.AreaService;

/**
 * 地区编码实现类
 * @author hucong
 *
 */
@Service("areaService")
@SuppressWarnings({ "unused" })
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaMapper areaDao;

	/**
	 * 根据父编码查询子编码
	 * @return list
	 */
	@SuppressWarnings("unchecked")
	public List<Area> subArea(String content) throws BussinessException {
		Map<String, String> params = JSON.parseObject(content, Map.class);
		String areaNo = params.get("area_no");
		if(params.get("area_no")==null||"".equals(params.get("area_no"))) {
			areaNo = "0";
		}
		if(!"0".equals(areaNo)){
			int c = areaDao.areaNum(areaNo);
			if(c<=0){
				throw new BussinessException(200010);
			}
		}		
		List<Area> list = areaDao.areas(areaNo);
		if(list.size()<=0) {
			throw new BussinessException(200011);
		}
		return list;
	}

}
