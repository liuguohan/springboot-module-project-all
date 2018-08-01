package com.biyouche.dao.user;

import com.biyouche.domain.user.UserToken;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserTokenMapper {

    /**
     * 通过用户id与设备类型查询登录token
     *
     * @param userId
     * @param deviceType
     * @return
     */
    @Select("select access_id from user_token where user_id=#{userId} and device_type=#{deviceType}")
    @Results({
            @Result(column = "access_id",property = "accessId"),
            @Result(column = "device_type",property = "deviceType"),
            @Result(column = "user_id",property = "userId")
    })
    List<UserToken> selectLoginToken(@Param("userId") Integer userId, @Param("deviceType") int deviceType);

    /**
     * 通过用户id与设备类型删除登录token
     *
     * @param userId
     * @param deviceKey
     */
    @Delete("delete from user_token where user_id=#{userId} and device_type=#{deviceKey}")
    void deleteUserToken(@Param("userId") Integer userId, @Param("deviceKey") int deviceKey);

    /**
     * 添加登录token
     * @param userToken
     * @return
     */
    @Insert("INSERT into user_token(access_id,access_key,data_transfer_key,user_id,device_type,login_time,last_action_time,expire_time) " +
            "VALUES (#{accessId},#{accessKey},#{dataTransferKey},#{userId},#{deviceType}," +
            "#{loginTime},#{lastActionTime},#{expireTime})")
    int insertUserToken(UserToken userToken);


    /**
     * 通过id与设备查询token
     * @param accessId
     * @param deviceType
     * @return
     */
    @Select("select access_id,user_id from user_token where access_id=#{accessId} and device_type=#{deviceType}")
    @Results({
            @Result(column = "access_id",property = "accessId"),
            @Result(column = "device_type",property = "deviceType"),
            @Result(column = "user_id",property = "userId")
    })
    UserToken selectTokenByAccessId(@Param("accessId") String accessId, @Param("deviceType") String deviceType);
}
