package com.biyouche.dao.user;

import com.biyouche.domain.user.User;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    /**
     * 通过登录手机号查询用户信息
     * @param loginMobile
     * @return
     */
    @Select("select user_id,login_mobile,user_password,avatar_url,user_level,user_qrcode,login_lock,nick_name from user where login_mobile=#{loginMobile}")
    @Results({
            @Result(property = "userId", column = "user_id"),
            @Result(property = "loginMobile", column = "login_mobile"),
            @Result(property = "userPassword",column = "user_password"),
            @Result(property = "avatarUrl",column = "avatar_url"),
            @Result(property = "userLevel",column = "user_level"),
            @Result(property = "userQrcode",column = "user_qrcode"),
            @Result(property = "loginLock",column = "login_lock"),
            @Result(property = "nickName",column = "nick_name")
    })
    User selectByloginMobile(String loginMobile);

    /**
     * 通过用户id查黑名单
     * @param userId
     * @return
     */
    @Select("select count(0) from user_black where user_id = #{userId}")
    int checkUserBlackByuserId(Integer userId);


    /**
     * 注册插入用户
     * @param user
     * @return
     */
    @Insert("insert into user(login_mobile,user_password,recommend_id,recommend_mobile,user_qrcode,create_time,last_login_time,nick_name,avatar_url,device_type)"
    		+ "values(#{loginMobile},#{userPassword},#{recommendId},#{recommendMobile},#{userQrcode},UNIX_TIMESTAMP(),UNIX_TIMESTAMP(),#{nickName},#{avatarUrl},#{deviceType})")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="user_id") 
    @Results({
        @Result(property = "loginMobile", column = "login_mobile"),
        @Result(property = "userPassword",column = "user_password"),
        @Result(property = "recommendId",column = "recommend_id"),
        @Result(property = "recommendMobile",column = "recommend_mobile"),
        @Result(property = "userQrcode",column = "user_qrcode"),
        @Result(property = "nickName",column = "nick_name"),
        @Result(property = "avatarUrl",column = "avatar_url"),
        @Result(property = "deviceType",column = "device_type")
    })
    int register(User user);
    
    
    /**
     * 通过电话号码查询用户数量
     * @param mobile
     * @return
     */
    @Select("select count(0) from user where login_mobile = #{mobile}")
    int selectNumByMobile(String mobile);

    /**
     * 登录次数更新
     * @param loginTime
     * @param userId
     */
    @Update("update user set login_nums=login_nums+1,last_login_time=#{loginTime} where user_id=#{userId}")
    void updateLoginNum(@Param("loginTime") long loginTime, @Param("userId") Integer userId);

    /**
     * 修改密码信息
     * @param user
     */
    @Update(
    	"UPDATE user SET user_password=#{userPassword} WHERE login_mobile=#{loginMobile} AND login_lock=#{loginLock}"
    )
    int updatePasswordByLoginMobileAndLoginLock(User user);

    /**
     * 根据用户id获取用户
     * @param userId
     * @return
     */
    @Select("SELECT user_id,login_mobile,user_level,user_qrcode,nick_name,avatar_url,device_type FROM user WHERE user_id = #{userId}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "loginMobile", column = "login_mobile"),
            @Result(property = "userLevel",column = "user_level"),
            @Result(property = "userQrcode",column = "user_qrcode"),
            @Result(property = "nickName",column = "nick_name"),
            @Result(property = "avatarUrl",column = "avatar_url"),
            @Result(property = "deviceType",column = "device_type")
    })
    User selectUserById(Integer userId);

    
    /**
     * 更新绑定驾校id
     * @return
     */
    @Update("update user set school_id = #{schoolId} where user_id = #{userId}")
    @Options(useGeneratedKeys=true, keyProperty="userId", keyColumn="user_id") 
    int updateSchoolId(User user);
    
    /**
     * 通过user_id查找是否绑定驾校
     * @param userId
     * @return
     */
    @Select("select school_id from user where user_id = #{userId}")
    @Results({
        @Result(property = "schoolId", column = "school_id"),
    })
    int selectSchool(Integer userId);
}



