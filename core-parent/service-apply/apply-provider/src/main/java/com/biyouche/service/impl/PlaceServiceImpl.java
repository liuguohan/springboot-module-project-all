package com.biyouche.service.impl;

import com.biyouche.dao.apply.PlaceMapper;
import com.biyouche.domain.apply.Place;
import com.biyouche.service.PlaceService;
import com.biyouche.utils.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaceServiceImpl.class);

    @Autowired
    private PlaceMapper placeMapper;
    /**
     * 驾校场地列表
     * @param schoolId
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    @Override
    public List<Map<String, Object>> placeList(Integer schoolId, String lat, String lng) {
        LOGGER.info("驾校场地请求数据:schoolId = " + schoolId + ",lat = " + lat + ",lng = " + lng);
        //根据驾校id查出所有场地
        List<Place> placeList = placeMapper.selectBySchool(schoolId);
        List<Map<String,Object>> list = new ArrayList<>();
        for (Place place : placeList) {
            Map<String, Object> voMap = new HashMap<>();
            voMap.put("place_id",place.getId());
            voMap.put("place_image",place.getImage());
            voMap.put("place_address",place.getAddress());
            voMap.put("place_name",place.getPlaceName());
            voMap.put("practice_type",place.getPracticeType());
            //计算距离
            double distance = MapUtils.GetDistance(Double.parseDouble(lat), Double.parseDouble(lng), place.getLat(), place.getLng());
            voMap.put("place_distance",distance);
            list.add(voMap);
        }
        return list;
    }
}
