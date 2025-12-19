package com.lanyang.cloud.framework.web.security.annotation;

import com.lanyang.cloud.framework.web.security.aspect.UserAuthAspect;
import com.lanyang.cloud.framework.web.security.config.SecurityAutoConfig;
import com.lanyang.cloud.framework.web.security.config.WebConfig;
import com.lanyang.cloud.framework.web.security.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lanyang
 * @date 2025/3/27
 * @des 引入统一拦截器，拦截用户信息
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({WebConfig.class, SecurityInterceptor.class, UserAuthAspect.class, SecurityAutoConfig.class})
public @interface EnableSecurityInterceptor {
}
