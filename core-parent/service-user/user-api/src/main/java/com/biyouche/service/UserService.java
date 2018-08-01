package com.biyouche.service;

import com.biyouche.domain.user.LoginVO;
import com.biyouche.domain.user.User;
import com.biyouche.domain.user.UserToken;

import java.util.Map;

import com.biyouche.exception.BussinessException;

public interface UserService {


    /**
     * 登录
     * @param content
     * @return
     * @throws BussinessException
     * @author pht
     */
    Map<String, Object> login(LoginVO content) throws BussinessException;
    
    /**
     * 注册
     * @author hucong
     * @param content
     */
    int register(String code,String device_type,String pwd,String recommecd_mobile,String user_mobile) throws BussinessException;
    
    /**
     * 获取验证码
     * @author hucong
     * @param params
     * @param type
     * @param device_type
     */
    void send(String user_mobile, String type, String device_type)throws BussinessException;
    
    /**
     * 修改密码
     * 
     * @author lgh
     * @param params
     */
    void forgetPassword(Map<String, String> params) throws BussinessException;

    /**
     * 获取token
     * @author pht
     * @param accessToken
     * @param deviceType
     * @return
     */
    UserToken selectToken(String accessToken, String deviceType);
    
    /**
     * 根据userId获取用户
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     * 用户驾考需求入录
     * @return
     */
    int userSurvey(String apply_status,String ddriver_type,String driver_purpose,String sex,String user_id);

}
