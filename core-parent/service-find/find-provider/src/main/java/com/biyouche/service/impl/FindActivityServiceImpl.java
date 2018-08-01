package com.biyouche.service.impl;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biyouche.constants.ConfigConstant;
import com.biyouche.constants.FindConstant;
import com.biyouche.dao.find.FindActivityMapper;
import com.biyouche.domain.find.FindActivityOrder;
import com.biyouche.domain.find.model.FindActivityCoverModel;
import com.biyouche.domain.find.model.FindActivityDetailModel;
import com.biyouche.exception.BussinessException;
import com.biyouche.redis.annotations.Cacheable;
import com.biyouche.redis.enums.ExpireTime;
import com.biyouche.redis.prefix.RedisKeyPrefix;
import com.biyouche.service.FindActivityService;
import com.biyouche.utils.TimeUtils;

/**
 * 发现活动模块业务实现
 * @author lgh
 *
 */
@Service("findActivityService")
public class FindActivityServiceImpl implements FindActivityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FindActivityServiceImpl.class);
    
    @Autowired
    private FindActivityMapper findActivityMapper;

	@Override
	@Cacheable(key = RedisKeyPrefix.ACTIVITY_LIST + "#findId", expire = ExpireTime.FIVE_MIN)
	public Map<String, Object> activityList(Integer findId) {
		LOGGER.info("发现活动模块活动列表查询库信息 ......");
		
		List<FindActivityCoverModel> findActivityCoverList = findActivityMapper.activityList(findId, FindConstant.DELSTATUS_VALID);
		for( FindActivityCoverModel model : findActivityCoverList ) {
			model.setActivityCover(ConfigConstant.getInstance().PIC_URL_PREFIX + model.getActivityCover());
			model.setActivityTimeStr(TimeUtils.timeStampToDateStr(model.getActivityTime(), "MM/dd mm:ss"));
			model.setActivityTimeWeekStr(model.getActivityTimeWeekStr());
		}
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("activityList", findActivityCoverList);
		return result;
	}

	@Override
	@Cacheable(key = RedisKeyPrefix.ACTIVITY_DETAIL + "#activityId", expire = ExpireTime.FIVE_MIN)
	public Map<String, Object> activityDetail(Integer activityId) {
		LOGGER.info("发现活动模块活动详情查询库信息 ......");
		
		FindActivityDetailModel model = findActivityMapper.activityDetail(activityId, FindConstant.DELSTATUS_VALID);
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("activityId", model.getActivityId());
		result.put("activityTitle", model.getActivityTitle());
		result.put("activityCover", ConfigConstant.getInstance().PIC_URL_PREFIX + model.getActivityCover());
		result.put("limitNum", model.getLimitNum());
		result.put("activityFee", model.getActivityFee());
		result.put("activityAddress", model.getActivityAddress());
		result.put("activityContent", model.getActivityContent());
		result.put("activityRule", model.getActivityRule());
		result.put("reportStartTime", TimeUtils.timeStampToDateStr(model.getReportStartTime(), TimeUtils.yyyyMMddHHmmss));
		result.put("reportEndTime", TimeUtils.timeStampToDateStr(model.getReportEndTime(), TimeUtils.yyyyMMddHHmmss));
		result.put("activityTime", model.getActivityTime());
		result.put("activityTimeStr", TimeUtils.timeStampToDateStr(model.getActivityTime(), "MM/dd mm:ss"));
		result.put("activityTimeWeekStr", model.getActivityTimeWeekStr());
		return result;
	}
	
	@Override
	public Map<String, Object> toJoinActivity(Integer userId, Integer activityId) {
		boolean isShowButton = true;
		if( userId != null && !userId.equals(0) ) {
			FindActivityOrder order = findActivityMapper.selectFindActivityOrder(activityId, userId);
			if( order != null && !(order.getPayStatus().equals(FindConstant.PAY_STATUS_UNPAY) || 
					order.getPayStatus().equals(FindConstant.PAY_STATUS_PAY_FAIL)) ) {	
				isShowButton = false;
			}
		}
		
		Map<String,Object> result = new LinkedHashMap<String, Object>();
		result.put("isShowButton", isShowButton);
		return result;
	}

	@Override
	public void joinActivity(Integer userId, Integer activityId) throws BussinessException {
		
		FindActivityDetailModel model = findActivityMapper.activityDetail(activityId, FindConstant.DELSTATUS_VALID);
		
		//校验是否有报名资格
		Integer limitNum = model.getLimitNum();
		Integer peopleNum = model.getPeopleNum();
		if( peopleNum == limitNum ) {
			throw new BussinessException(230020);
		}
		Integer curTime = Integer.valueOf(String.valueOf(TimeUtils.getCurrentTimeStamp()));
		Integer reportStartTime = model.getReportStartTime();
		Integer reportEndTime = model.getReportEndTime();
		if( reportStartTime != null && reportStartTime > curTime ) {
			throw new BussinessException(230021);
		}
		if( reportEndTime != null && reportEndTime < curTime ) {
			throw new BussinessException(230022);
		}
		
		//订单校验
		FindActivityOrder order = findActivityMapper.selectFindActivityOrder(activityId, userId);
		if( order != null && !(order.getPayStatus().equals(FindConstant.PAY_STATUS_UNPAY) || 
				order.getPayStatus().equals(FindConstant.PAY_STATUS_PAY_FAIL)) ) {	
			throw new BussinessException(230023);
		}
		
		
		//如果活动费用为免费，直接将支付状态改为成功
		BigDecimal activityFee = model.getActivityFee();
		//生成订单
		order = new FindActivityOrder();
		order.setPayStatus(FindConstant.PAY_STATUS_UNPAY);
		if( new BigDecimal(0).equals(activityFee) ) {
			order.setPayStatus(FindConstant.PAY_STATUS_PAIED);
		}
		order.setActivityId(activityId);
		order.setUserId(userId);
		order.setActivityFee(activityFee);
		int result = findActivityMapper.insertFindActivityOrder(order);
		if( result != 1 ) {
			throw new BussinessException(230024);
		}
	}

	



   
}
