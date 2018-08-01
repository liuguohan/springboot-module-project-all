package com.biyouche.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biyouche.annotation.CurrentUser;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.user.LoginVO;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.FindCommunityService;
import com.biyouche.service.UserService;
import com.biyouche.utils.CommonUtils;
import com.biyouche.utils.ValidatorUtils;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Autowired
    private FindCommunityService findCommunityService;

    /**
     * @param content 登录请求数据
     * @return
     * @autor pht
     */
    @PostMapping("/login")
    public ResponseObject login(LoginVO loginVO, HttpServletRequest request) {
        LOGGER.info("登录请求参数内容:" + loginVO);
        try {
            String ip = CommonUtils.getIP(request);
            LOGGER.info("ip地址:" + ip);
            //解析json参数
            //添加ip
            loginVO.setReqIp(ip);
            Map<String, Object> responseMap = userService.login(loginVO);
            return dealSuccess(responseMap);
        } catch (Exception e) {
            return dealException(e);
        }
    }

    /**
     * 注册接口
     *
     * @param content
     * @return code
     */
    @PostMapping("/register")
    public ResponseObject register(String code,String device_type,String pwd,String recommecd_mobile,String user_mobile) {
        LOGGER.info("注册地请求参数内容:" + code+"--"+device_type+"--"+pwd+"--"+recommecd_mobile+"--"+user_mobile);
        try {
        	ResponseObject dealSuccess = dealSuccess();
            int register = userService.register(code,device_type,pwd,recommecd_mobile,user_mobile);
            dealSuccess.content.put("user_id", register);
            return dealSuccess;
        } catch (Exception e) {
            return dealException(e);
        }

    }

    /**
     * 忘记密码
     *
     * @param phone
     * @param password
     * @param validCode
     * @return
     * @author lgh
     */
    @PostMapping("/forgetPassword")
    public ResponseObject forgetPassword(String phone, String password, String validCode) {
        try {
        	
        	if( ValidatorUtils.isEmpty(phone) ) {
        		throw new BussinessException(200011);
        	}
        	if( ValidatorUtils.isEmpty(password) ) {
        		throw new BussinessException(200014);
        	}
        	if( ValidatorUtils.isEmpty(validCode) ) {
        		throw new BussinessException(200015);
        	}
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("phone", phone);
        	params.put("password", password);
        	params.put("validCode", validCode);
        	
        	LOGGER.info("忘记密码请求参数内容: " + params.toString());
        	userService.forgetPassword(params);
        	
			return dealSuccess();
		} catch (Exception e) {
			return dealException(e);
		}
    }

    /**
     * 用户调研
     *
     * @param user_id
     * @param sex
     * @param apply_status
     * @param driver_purpose
     * @param ddriver_type
     * @return
     * @author huc
     */
    @PostMapping("/userSurvey")
    public ResponseObject userSurvey(String apply_status,String ddriver_type,String driver_purpose,String sex,String user_id) {
    	 try {
         	ResponseObject dealSuccess = dealSuccess();
             int userSurvey = userService.userSurvey(apply_status,ddriver_type,driver_purpose,sex,user_id);
             dealSuccess.content.put("user_survey", userSurvey);
             return dealSuccess;
         } catch (Exception e) {
             return dealException(e);
         }
    }
    
    /**
     * 我的发布
     *
     * @param userId
     * @return
     * @author lgh
     */
    @GetMapping("/userTopicPublish")
    public ResponseObject userTopicPublish(@CurrentUser String userId) {
        try {
        	
        	if( ValidatorUtils.isEmpty(userId) ) {
        		throw new BussinessException(210003);
        	}
        	
        	LOGGER.info("我的发布请求参数内容: userId =" + userId);
			return dealSuccess(findCommunityService.userTopicPublish(Integer.parseInt(userId)));
		} catch (Exception e) {
			return dealException(e);
		}
    }
    
    /**
     * 我的回复
     *
     * @param userId
     * @return
     * @author lgh
     */
    @GetMapping("/userTopicReply")
    public ResponseObject userTopicReply(@CurrentUser String userId) {
        try {
        	
        	if( ValidatorUtils.isEmpty(userId) ) {
        		throw new BussinessException(210003);
        	}
        	
        	LOGGER.info("我的回复请求参数内容: userId =" + userId);
			return dealSuccess(findCommunityService.userTopicReply(Integer.parseInt(userId)));
		} catch (Exception e) {
			return dealException(e);
		}
    }

}
