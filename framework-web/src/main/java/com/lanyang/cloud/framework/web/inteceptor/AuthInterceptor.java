package com.lanyang.cloud.framework.web.inteceptor;

import com.lanyang.framework.common.constant.SecurityConstants;
import com.lanyang.framework.common.context.ThreadLocalContextHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lanyang
 * @date 2025/3/27
 * @des
 */
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){

        String userId = request.getHeader(SecurityConstants.USER_ID);
        if(StringUtils.isNotBlank(userId)){
            //请求头的用户id放到ThreadLocal
            ThreadLocalContextHolder.set(SecurityConstants.USER_ID, userId);
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        ThreadLocalContextHolder.remove();
    }
}
