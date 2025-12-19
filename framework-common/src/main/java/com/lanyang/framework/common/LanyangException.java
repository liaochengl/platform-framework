package com.lanyang.framework.common;

/**
 * @author lanyang
 * @date 2025/6/11
 * @des
 */
public class LanyangException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常code
     */
    private Integer code;

    /**
     * 异常消息
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LanyangException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
