package com.biyouche.service;

import java.util.List;
import java.util.Map;

public interface PlaceService {
    List<Map<String, Object>> placeList(Integer schoolId, String lat, String lng);
}
