package com.lanyang.cloud.framework.web.security.handler;

import com.lanyang.cloud.framework.web.common.domain.LoginUser;
import com.lanyang.cloud.framework.web.common.util.SecurityUtils;

/**
 * @author lanyang
 * @date 2025/12/4
 * @des
 */
public interface LoginUserHandler {

    /**
     * 获取登录用户信息
     * 默认实现是从redis中获取
     * 各自服务可以重写实现逻辑
     * @return
     */
    default LoginUser getLoginUser() {
        return SecurityUtils.getLoginUserFromRedis();
    }
}
