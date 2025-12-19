package com.lanyang.cloud.framework.message.exception;

/**
 * @author lanyang
 * @date 2025/6/10
 * @des
 */
public class MessageException extends RuntimeException {

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

    public MessageException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static MessageException error(Integer code, String message){
        if(code == null){
            return new MessageException(500, message);
        }
        return new MessageException(code, message);
    }


}
