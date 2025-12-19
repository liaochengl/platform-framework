package com.lanyang.cloud.framework.web.security.exception;

import com.lanyang.cloud.framework.web.common.exception.BizException;

/**
 * @author lanyang
 * @date 2025/6/16
 * @des
 */
public class AuthException extends BizException {

    public AuthException(Integer code, String message) {
        super(code, message);
    }
}
