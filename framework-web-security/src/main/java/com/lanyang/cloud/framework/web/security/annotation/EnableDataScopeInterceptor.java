package com.lanyang.cloud.framework.web.security.annotation;

import com.lanyang.cloud.framework.web.security.aspect.DataScopeAspect;
import com.lanyang.cloud.framework.web.security.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lanyang
 * @date 2025/6/13
 * @des 启动数据权限拦截
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({DataScopeAspect.class, SecurityInterceptor.class})
public @interface EnableDataScopeInterceptor {
}
