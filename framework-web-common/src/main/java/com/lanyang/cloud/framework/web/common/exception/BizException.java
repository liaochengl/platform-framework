package com.lanyang.cloud.framework.web.common.exception;

import com.lanyang.framework.common.exception.LyException;

/**
 * @author lanyang
 * @date 2025/3/27
 * @des
 */
public class BizException extends LyException {

    private static final long serialVersionUID = 1L;


    public BizException(String message) {
        super(500, message);
    }

    public BizException(Integer code, String message) {
        super(code, message);
    }

    public BizException(ExceptionResolvable exceptionCode) {
        this(exceptionCode.getCode(), exceptionCode.getMessage());
    }
}
