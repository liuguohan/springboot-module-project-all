package com.biyouche.dao.user;

import com.biyouche.domain.user.UserLoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

public interface UserLoginLogMapper {

    @Insert("INSERT INTO log_user_login (user_id,user_mobile,device_type,login_time,login_ip,login_area_code,longitude,latitude,device_id,device_os,device_name,client_version,device_detail)" +
            "VALUES (#{userLoginLog.userId},#{userLoginLog.userMobile},#{userLoginLog.deviceType},#{userLoginLog.loginTime},#{userLoginLog.loginIp},#{userLoginLog.loginAreaCode},#{userLoginLog.longitude}," +
            "#{userLoginLog.latitude},#{userLoginLog.deviceId},#{userLoginLog.deviceOs},#{userLoginLog.deviceName},#{userLoginLog.clientVersion},#{userLoginLog.deviceDetail})")
    @Options(useGeneratedKeys = true,keyColumn = "log_id",keyProperty = "userLoginLog.logId")
    void inserLogin(@Param("userLoginLog") UserLoginLog userLoginLog);
}
