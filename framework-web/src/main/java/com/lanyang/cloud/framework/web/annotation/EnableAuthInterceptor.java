package com.lanyang.cloud.framework.web.annotation;

import com.lanyang.cloud.framework.web.config.WebConfig;
import com.lanyang.cloud.framework.web.inteceptor.AuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lanyang
 * @date 2025/3/27
 * @des 引入统一拦截器，拦截用户信息
 * 启动类上配置，会引入AuthInterceptor
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({WebConfig.class, AuthInterceptor.class})
public @interface EnableAuthInterceptor {
}
