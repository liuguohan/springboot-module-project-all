package com.biyouche.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.biyouche.constants.CommonConstant;
import com.biyouche.constants.UserConstant;
import com.biyouche.dao.apply.NeedsMapper;
import com.biyouche.dao.drive.BannerMapper;
import com.biyouche.domain.apply.model.*;
import com.biyouche.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.dao.apply.CoachMapper;
import com.biyouche.dao.apply.SchoolMapper;
import com.biyouche.domain.dict.model.Dict;
import com.biyouche.enums.DictTypeEnum;
import com.biyouche.enums.SearchLabelEnum;
import com.biyouche.exception.BussinessException;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.redis.utils.RedisTempleteUtils;
import com.biyouche.service.IndexService;
import com.biyouche.utils.DictUtil;
import com.biyouche.utils.ValidatorUtils;

/**
 * 首页-搜索驾校/教练实现
 *
 * @author lgh
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    @Autowired
    private SchoolMapper schoolMapper;

    @Autowired
    private CoachMapper coachMapper;

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private NeedsMapper needsMapper;
    @Autowired
    private SchoolService schoolService;


    @Override
    public Map<String, Object> obtainCondition() {

        List<Dict> labelList = DictUtil.getDict(DictTypeEnum.SEARCH_RECOMMAND.KEY);

        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("labelList", labelList);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Map<String, Object> searchSchoolOrCoachList(Map<String, String> params) {
        //TODO 搜索引擎类型中间件支持
        String cityCode = params.get("cityCode");
        String searchName = params.get("searchName");
        int labelType = Integer.parseInt(params.get("labelType"));

        if (ValidatorUtils.isEmpty(cityCode)) {
            throw new BussinessException(210018);
        }

        Map<String, Object> result = null;
        List<SchoolIndexModel> schoolList = null;
        if (ValidatorUtils.isNotEmpty(searchName) && SearchLabelEnum.NONE.KEY == labelType) {

            //1.模糊搜索驾校

            schoolList = schoolMapper.searchSchoolList(searchName, cityCode);

            //2.模糊搜索教练

            List<CoachIndexModel> coachList = coachMapper.searchCoachList(searchName, cityCode);

            result = new LinkedHashMap<String, Object>();
            result.put("schoolList", schoolList);
            result.put("coachList", coachList);
        } else if (ValidatorUtils.isEmpty(searchName) && SearchLabelEnum.NONE.KEY != labelType) {

            //3.根据搜索标签精确查询

            //默认从缓存找，如果没有则从获取库后回设缓存
            String key = RedisKeyPrefix.SEARCH_SCHOOL_LIST_BY_LABEL + cityCode + ":" + labelType;
            long expireTime = 5 * 60;
            schoolList = (List<SchoolIndexModel>) RedisTempleteUtils.getObj(key);
            if (ValidatorUtils.isEmpty(schoolList)) {
                schoolList = schoolMapper.searchSchoolListByLabel(labelType, cityCode);
                if (ValidatorUtils.isNotEmpty(schoolList)) {
                    RedisTempleteUtils.set(key, schoolList, expireTime);
                }
            }

            result = new LinkedHashMap<String, Object>();
            result.put("schoolList", schoolList);
            result.put("coachList", null);
        } else {

            //4.无模糊查询字段或被选标签直接返回
            result = new LinkedHashMap<String, Object>();
            result.put("schoolList", null);
            result.put("coachList", null);
        }

        return result;
    }

    @Override
    public Map<String, Object> quickSearchSchoolOrCoachList(Map<String, String> params) {
        //TODO 搜索引擎类型中间件支持
        String cityCode = String.valueOf(params.get("cityCode"));
        String searchName = String.valueOf(params.get("searchName"));

        if (ValidatorUtils.isEmpty(cityCode)) {
            throw new BussinessException(210018);
        }
        if (ValidatorUtils.isEmpty(searchName)) {
            throw new BussinessException(210019);
        }

        List<QuickSchoolIndexModel> schoolQuickList = null;
        List<QuickCoachIndexModel> coachQuickList = null;

        //1.即时模糊搜索驾校

        schoolQuickList = schoolMapper.quickSearchSchoolList(searchName, cityCode);

        //2.即时模糊搜索教练

        coachQuickList = coachMapper.quickSearchCoachList(searchName, cityCode);

        Map<String, Object> result = new LinkedHashMap<String, Object>();
        result.put("schoolQuickList", schoolQuickList);
        result.put("coachQuickList", coachQuickList);

        return result;
    }

    /**
     * 报名模块首页
     *
     * @param lat 纬度
     * @param lng 经度
     * @return
     */
    @Override
    public Map<String, Object> applyIndex(String lat, String lng) {
        //查询类型默认是推荐[0 推荐驾校 1 距离最近 2 价格最低 3 评分最好]
        String select_type = "0";
        //获取banner图
        List<Banners> bannersList = bannerMapper.getBannerByLocal(CommonConstant.BANNER_LOCAL_APPLY_INDEX);
        //优惠券banner图
        List<Banners> coupons = bannerMapper.getBannerByLocal(CommonConstant.BANNER_LOCAL_APPLY_COUPONS);
        Banners coupon = new Banners();
        if (coupons.size() > 0) {
            coupon = coupons.get(0);
        }
        //报名学车统计
        Integer count = needsMapper.selectSuccessNum(UserConstant.LEARN_APPLY_STATUS_SUCCESS);
        //驾校列表
        List<SchoolData> schoolList = schoolService.schoolList(lat, lng, select_type);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("banners_list", bannersList);
        resultMap.put("coupon", coupon);
        resultMap.put("apply_success_count", count);
        resultMap.put("school_list", schoolList);
        return resultMap;
    }

}
