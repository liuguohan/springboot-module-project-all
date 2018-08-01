package com.biyouche.dao.user;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biyouche.domain.user.SmsCode;

/**
 * @author hucong
 *
 */
public interface SmsMapper {
	
	
	@Insert("insert into sms_code(user_mobile,sms_code,sms_type,send_nums,create_time,expire_time,reqip,device_type) values("
			+ "#{userMobile},#{smsCode},#{smsType},#{sendNums},UNIX_TIMESTAMP(),UNIX_TIMESTAMP()+300,#{reqIp},#{deviceType})")
	@Options(useGeneratedKeys=true, keyProperty="smsId", keyColumn="sms_id") 
	int insert(SmsCode code);

	/**
	 * 根据主键查更新验证码状态
	 * @return
	 */
	@Update("update sms_code set send_time=UNIX_TIMESTAMP() where sms_id=#{smsId}")
	int updateSendTime(Integer smsId);
	
	/**
	 * 当天发送次数
	 * @return
	 */
	@Select("select sum(send_nums) as num from sms_code where user_mobile=#{userMobile} and sms_type=#{smsType} and create_time>=#{createTime} limit 1")
	Integer sendNumToday(SmsCode code);
	
	/**
	 * 获取指定用户手机号未使用且未过期的验证码短信类型
	 * @param code
	 * @return
	 */
	@Select(
		"SELECT count(0) as nums FROM sms_code WHERE sms_code=#{smsCode} AND user_mobile=#{userMobile} AND sms_status=#{smsStatus} AND sms_type=#{smsType} AND expire_time>UNIX_TIMESTAMP() LIMIT 1"
	)
	int findCountBySpecificCondition(SmsCode code);
	
	/**
	 * 更改指定用户手机号未使用的验证码短信类型为已使用
	 * @param code
	 * @return
	 */
	@Update(
		"UPDATE sms_code SET used_time=UNIX_TIMESTAMP(),sms_status=#{newSmsStatus} WHERE sms_code=#{smsCode} AND user_mobile=#{userMobile} AND sms_status=#{smsStatus} AND sms_type=#{smsType}"
	)
	int updateUsedBySpecificCondition(@Param("newSmsStatus") int newSmsStatus, 
			@Param("smsCode") String smsCode, @Param("userMobile") String userMobile, @Param("smsStatus") int smsStatus, @Param("smsType") int smsType );
	
}
