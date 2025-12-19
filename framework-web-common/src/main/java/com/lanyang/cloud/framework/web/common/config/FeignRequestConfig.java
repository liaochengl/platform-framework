package com.lanyang.cloud.framework.web.common.config;

import com.lanyang.cloud.framework.web.common.interceptor.GlobalFeignRequestInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanyang
 * @date 2025/4/17
 * @des
 */
@Configuration
public class FeignRequestConfig {

    @Bean
    public RequestInterceptor requestInterceptor(){
        return new GlobalFeignRequestInterceptor();
    }
}
