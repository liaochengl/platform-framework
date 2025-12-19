package com.lanyang.cloud.framework.web.common.annotation;

import com.lanyang.cloud.framework.swagger.annotation.EnableCommonSwagger;
import org.mybatis.spring.annotation.MapperScan;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lanyang
 * @date 2025/4/17
 * @des 是否开启全局feign拦截器 开启会引入GlobalFeignRequestInterceptor做全局请求拦截
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@MapperScan(basePackages = "com.lanyang.cloud.**.mapper")
@EnableCommonSwagger
@EnableGlobalFeignInterceptor
public @interface EnableWebCommonConfig {
}
