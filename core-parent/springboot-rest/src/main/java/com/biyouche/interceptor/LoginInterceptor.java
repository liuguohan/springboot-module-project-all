package com.biyouche.interceptor;

import com.alibaba.fastjson.JSON;
import com.biyouche.annotation.LoginRequired;
import com.biyouche.controller.BaseController;
import com.biyouche.domain.user.UserToken;
import com.biyouche.exception.BussinessException;
import com.biyouche.response.ResponseObject;
import com.biyouche.service.UserService;
import com.biyouche.utils.ValidatorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class LoginInterceptor extends BaseController implements HandlerInterceptor {

    public final static String ACCESS_TOKEN = "accessId";
    public final static String DEVICE_TYPE = "deviceType";
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UserService userService;

    //执行方法之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        UserToken userToken = null;
        //获取accessId 有的接口可登陆可不登陆 所以获取用户id的时候不能通过注解判断,任何接口都获取accessId
        String accessToken = request.getParameter(ACCESS_TOKEN);
        String deviceType = request.getParameter(DEVICE_TYPE);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        // 判断接口是否需要登录
        LoginRequired methodAnnotation = method.getAnnotation(LoginRequired.class);
        // 有 @LoginRequired 注解，需要认证
        if (methodAnnotation != null) {
            // 判断是否存在令牌信息，如果存在，则允许登录
            Map<String, Object> serviceMap = new LinkedHashMap<>();
            serviceMap.put("method",method.getName());
            serviceMap.put("accessId",accessToken);
            serviceMap.put("deviceType",deviceType);
            if (null == accessToken) {
                //未登录,跳转登录页面
                ResponseObject responseObject = dealException(new BussinessException(200013));
                responseObject.getContent().putAll(serviceMap);
                this.returnJson(response, JSON.toJSONString(responseObject));
                return false;
            }
            //通过token查询用户
            userToken = userService.selectToken(accessToken,deviceType);
            if (userToken == null) {
                ResponseObject responseObject = dealException(new BussinessException(200006));
                responseObject.getContent().putAll(serviceMap);
                this.returnJson(response, JSON.toJSONString(responseObject));
                return false;
            }
        }
        // 当前登录用户@CurrentUser
        if (!ValidatorUtils.isEmpty(accessToken) && !ValidatorUtils.isEmpty(deviceType)){
            userToken = userService.selectToken(accessToken,deviceType);
            Integer userId = null;
            if (!ValidatorUtils.isNull(userToken)){
                userId = userToken.getUserId();
            }
            request.setAttribute("user_id",userId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);

        } catch (IOException e) {
            LOGGER.error("response error",e);
        } finally {
            if (writer != null)
                writer.close();
        }
    }

}
