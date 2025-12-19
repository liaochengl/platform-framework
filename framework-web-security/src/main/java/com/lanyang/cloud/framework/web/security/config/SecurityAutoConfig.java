package com.lanyang.cloud.framework.web.security.config;

import com.lanyang.cloud.framework.web.common.domain.LoginUser;
import com.lanyang.cloud.framework.web.security.handler.LoginUserHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanyang
 * @date 2025/12/4
 * @des
 */
@Configuration
public class SecurityAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public LoginUserHandler defaultLoginUserService() {
        return new LoginUserHandler() {
            @Override
            public LoginUser getLoginUser() {
                return LoginUserHandler.super.getLoginUser();
            }
        };
    }
}
