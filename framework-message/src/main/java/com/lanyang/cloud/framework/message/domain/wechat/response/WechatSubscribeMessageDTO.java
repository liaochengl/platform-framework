package com.lanyang.cloud.framework.message.domain.wechat.response;

import lombok.Data;

import java.util.Map;

/**
 * @author lanyang
 * @date 2024/7/4 15:48
 * @des
 */
@Data
public class WechatSubscribeMessageDTO {

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
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    private String miniprogram_state;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;

    /**
     * 跳转链接
     */
    private String url;

}
