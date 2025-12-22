package com.lanyang.cloud.framework.message.domain.wechat.response;

import lombok.Data;

import java.util.Map;

/**
 * @author lanyang
 * @date 2024/7/4 15:48
 * @des
 */
@Data
public class WechatTemplateMessageDTO {

    /**
     * 接收者（用户）的 openid
     */
    private String touser;

    /**
     * 所需下发的订阅模板id
     */
    private String template_id;

    /**
     * 模板内容，格式形如 { "key1": { "value": any }, "key2": { "value": any } }的object
     */
    private Map<String, Map<String, Object>> data;

    /**
     * 跳转小程序时填写（url 和 miniprogram 同时不填，无跳转，url 和 miniprogram 同时填写，优先跳转小程序）
     * 固定两个key
     * 1. appId 小程序appid
     * 2. pagepath 小程序跳转路径
     */
    private Map<String, String> miniprogram;

    /**
     * 跳转链接
     */
    private String url;

}
