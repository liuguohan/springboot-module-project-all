package com.biyouche.controller.apply;

import com.biyouche.controller.BaseController;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/place")
public class PlaceController extends BaseController {
    private final static Logger LOGGER = LoggerFactory.getLogger(PlaceController.class);
    @Autowired
    private PlaceService placeService;
    /**
     * 驾校场地列表
     * @param schoolId
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    @PostMapping("/placeList")
    public ResponseObject list(Integer schoolId,String lat,String lng){
        LOGGER.info("驾校场地列表请求参数:schoolId = " + schoolId + ",lat = " + lat + ",lng" + lng);
        try {
            ResponseObject dealSuccess = dealSuccess();
            List<Map<String,Object>> result = placeService.placeList(schoolId,lat,lng);
            dealSuccess.content.put("place_list",result);
            dealSuccess.content.put("place_total_num",result.size());
            return dealSuccess;
        }catch (Exception e){
            return dealException(e);
        }
    }

}
