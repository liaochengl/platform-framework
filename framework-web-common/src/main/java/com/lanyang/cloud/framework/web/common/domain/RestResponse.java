package com.lanyang.cloud.framework.web.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author lanyang
 * @date 2025/3/27
 * @des
 */
@ApiModel("http响应结果")
public class RestResponse<T> {

    private static final Integer SUCCESS_CODE = 1;

    private static final Integer ERROR_CODE = 500;

    @ApiModelProperty("结果码")
    private Integer code;

    @ApiModelProperty("信息")
    private String msg;

    @ApiModelProperty("响应数据")
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private RestResponse(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static <T> RestResponse<T> success(T data, String msg){
        return new RestResponse<>(SUCCESS_CODE, data, msg);
    }

    public static <T> RestResponse<T> success(T data){
        return new RestResponse<>(SUCCESS_CODE, data, "success");
    }

    public static <T> RestResponse<T> success(){
        return new RestResponse<>(SUCCESS_CODE, null, "success");
    }

    public static <T> RestResponse<T> error(Integer code, T data, String msg){
        return new RestResponse<>(code, data, msg);
    }

    public static <T> RestResponse<T> error(Integer code, String msg){
        return new RestResponse<>(code, null, msg);
    }
    public static <T> RestResponse<T> error(String msg){
        return new RestResponse<>(ERROR_CODE, null, msg);
    }

}
