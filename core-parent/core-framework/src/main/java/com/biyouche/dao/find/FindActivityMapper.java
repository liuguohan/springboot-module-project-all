package com.biyouche.dao.find;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.find.FindActivityOrder;
import com.biyouche.domain.find.model.FindActivityCoverModel;
import com.biyouche.domain.find.model.FindActivityDetailModel;

/**
 * 发现活动模块
 * @author lgh
 *
 */
public interface FindActivityMapper {

	/**
	 * 发现活动模块活动列表
	 * @param findId
	 * @param delStatus
	 * @return
	 */
	@Select(" SELECT activity_id, find_id, activity_title, activity_cover, people_num, limit_num, activity_fee, activity_address, activity_time FROM find_activity "
			+ " WHERE find_id = #{findId} AND del_status = #{delStatus} ")
	@Results({
        @Result(property = "activityId", column = "activity_id"),
        @Result(property = "findId", column = "find_id"),
        @Result(property = "activityTitle", column = "activity_title"),
        @Result(property = "activityCover", column = "activity_cover"),
        @Result(property = "peopleNum", column = "people_num"),
        @Result(property = "limitNum", column = "limit_num"),
        @Result(property = "activityFee", column = "activity_fee"),
        @Result(property = "activityAddress", column = "activity_address"),
        @Result(property = "activityTime", column = "activity_time")
       })
	List<FindActivityCoverModel> activityList(@Param("findId") int findId, @Param("delStatus") int delStatus);
	
	/**
	 * 发现活动模块活动详情
	 * @param activityId
	 * @param delStatus
	 * @return
	 */
	@Select(" SELECT activity_id, activity_title, activity_cover, limit_num, people_num, report_start_time, report_end_time, activity_time, activity_fee, activity_address, activity_content, activity_rule "
			+ " FROM find_activity WHERE activity_id = #{activityId} AND del_status = #{delStatus} ")
	@Results({
        @Result(property = "activityId", column = "activity_id"),
        @Result(property = "activityTitle", column = "activity_title"),
        @Result(property = "activityCover", column = "activity_cover"),
        @Result(property = "limitNum", column = "limit_num"),
        @Result(property = "peopleNum", column = "people_num"),
        @Result(property = "activityFee", column = "activity_fee"),
        @Result(property = "activityAddress", column = "activity_address"),
        @Result(property = "activityContent", column = "activity_content"),
        @Result(property = "activityRule", column = "activity_rule"),
        @Result(property = "reportStartTime", column = "report_start_time"),
        @Result(property = "reportEndTime", column = "report_end_time"),
        @Result(property = "activityTime", column = "activity_time")
       })
	FindActivityDetailModel activityDetail(@Param("activityId") int activityId, @Param("delStatus") int delStatus);
	
	/**
	 * 根据用户ID获取指定活动订单信息
	 * @param activityId
	 * @param userId
	 * @return
	 */
	@Select(" SELECT * FROM find_activity_order WHERE activity_id = #{activityId} AND user_id = #{userId} ")
	@Results({
		@Result(property = "orderId", column = "order_id"),
        @Result(property = "activityId", column = "activity_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "activityFee", column = "activity_fee"),
        @Result(property = "payStatus", column = "pay_status"),
        @Result(property = "payChannel", column = "pay_channel"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "successTime", column = "success_time"),
        @Result(property = "originTime", column = "origin_time")
       })
	FindActivityOrder selectFindActivityOrder(@Param("activityId") int activityId, @Param("userId") int userId);
	
	/**
	 * 生成用户活动订单
	 * @param order
	 * @return
	 */
	@Insert(" INSERT INTO `find_activity_order` (`activity_id`, `user_id`, `activity_fee`, `pay_status`, `pay_channel`, `create_time`, `success_time`, `origin_time`) VALUES "
			+ "(#{activityId}, #{userId}, #{activityFee}, #{payStatus}, NULL, UNIX_TIMESTAMP(), '0', '0') ")
	int insertFindActivityOrder(FindActivityOrder order);
}
