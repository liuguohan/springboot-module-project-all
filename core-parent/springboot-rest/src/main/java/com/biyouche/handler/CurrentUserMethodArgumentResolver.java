package com.biyouche.handler;

import com.biyouche.annotation.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


/**
 * @description 自定义解析器实现参数绑定
 * 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String CURRENT_USER = "user_id";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.getParameterType().isAssignableFrom(Integer.class)
                || parameter.getParameterType().isAssignableFrom(String.class))
                && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest request, WebDataBinderFactory webDataBinderFactory) throws Exception {
    	Object userId = request.getAttribute(CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
    	
    	if( methodParameter.getParameterType().isAssignableFrom(Integer.class) ){
    		return userId;
    	}else if( methodParameter.getParameterType().isAssignableFrom(String.class) ) {
    		return userId==null?null:String.valueOf(userId);
    	}
        return userId;
    }
}
