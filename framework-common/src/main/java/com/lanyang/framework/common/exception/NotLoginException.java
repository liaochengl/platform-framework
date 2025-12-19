package com.lanyang.framework.common.exception;

/**
 * @author lanyang
 * @date 2025/8/8
 * @des
 */
public class NotLoginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotLoginException(String message) {
        super(message);
    }
}
