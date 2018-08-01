package com.biyouche.dao.apply;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.biyouche.domain.apply.InsuranceOrder;

/**
 * 学车保险订单
 * @author lgh
 *
 */
public interface InsuranceOrderMapper {

	/**
	 * 生成订单
	 * @return
	 */
	@Insert("INSERT INTO `insurance_order` (`user_id`, `user_name`, `mobile_phone`, `card_no`, `vip_level`, `vip_name`, `vip_retake_number`, `vip_cash`, `vip_fund`, `vip_fee`, `pay_status`, `create_time`, `expire_time`) VALUES "
			+ "(#{userId}, #{userName}, #{mobilePhone}, #{cardNo}, #{vipLevel}, #{vipName}, #{vipRetakeNumber}, #{vipCash}, #{vipFund}, #{vipFee}, 0, #{createTime}, #{expireTime})")
    int insertOrder(InsuranceOrder order);
	
	/**
	 * 根据userId查询学车保险信息
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM insurance_order WHERE user_id = #{userId}")
	@Results({
		@Result(property = "orderId", column = "order_id"),
        @Result(property = "userId", column = "user_id"),
        @Result(property = "userName", column = "user_name"),
        @Result(property = "mobilePhone", column = "mobile_phone"),
        @Result(property = "cardNo", column = "card_no"),
        @Result(property = "vipLevel", column = "vip_level"),
        @Result(property = "vipName", column = "vip_name"),
        @Result(property = "vipRetakeNumber", column = "vip_retake_number"),
        @Result(property = "vipCash", column = "vip_cash"),
        @Result(property = "vipFund", column = "vip_fund"),
        @Result(property = "vipFee", column = "vip_fee"),
        @Result(property = "payChannel", column = "pay_channel"),
        @Result(property = "payStatus", column = "pay_status"),
        @Result(property = "createTime", column = "create_time"),
        @Result(property = "successTime", column = "success_time"),
        @Result(property = "expireTime", column = "expire_time"),
        @Result(property = "originTime", column = "origin_time"),
        @Result(property = "orderStatus", column = "order_status")
        })
	List<InsuranceOrder> selectInsuranceOrderByUserId(Integer userId);
	
	/**
	 * 更新订单
	 * @param order
	 * @return
	 */
	@Insert("UPDATE insurance_order SET origin_time = create_time, create_time = #{createTime}, expire_time = #{expireTime}  WHERE order_id = #{orderId}")
    int updateCreateTime(InsuranceOrder beforeChosenOrder);
	
	/**
	 * 根据userId查询学车保险信息
	 * @param userId
	 * @return
	 */
	@Select("SELECT * FROM insurance_order WHERE pay_status = 0 AND expire_time >= UNIX_TIMESTAMP() AND order_status = 0 ORDER BY create_time DESC LIMIT 1")
	@Results({
         @Result(property = "orderId", column = "order_id"),
         @Result(property = "userId", column = "user_id"),
         @Result(property = "userName", column = "user_name"),
         @Result(property = "mobilePhone", column = "mobile_phone"),
         @Result(property = "cardNo", column = "card_no"),
         @Result(property = "vipLevel", column = "vip_level"),
         @Result(property = "vipName", column = "vip_name"),
         @Result(property = "vipRetakeNumber", column = "vip_retake_number"),
         @Result(property = "vipCash", column = "vip_cash"),
         @Result(property = "vipFund", column = "vip_fund"),
         @Result(property = "vipFee", column = "vip_fee"),
         @Result(property = "payChannel", column = "pay_channel"),
         @Result(property = "payStatus", column = "pay_status"),
         @Result(property = "createTime", column = "create_time"),
         @Result(property = "successTime", column = "success_time"),
         @Result(property = "expireTime", column = "expire_time"),
         @Result(property = "originTime", column = "origin_time"),
         @Result(property = "orderStatus", column = "order_status")
        })
	InsuranceOrder selectLastestUnpayInsuranceOrder();
	
}
