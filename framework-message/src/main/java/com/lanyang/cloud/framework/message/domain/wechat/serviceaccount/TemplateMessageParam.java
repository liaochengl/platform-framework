package com.lanyang.cloud.framework.message.domain.wechat.serviceaccount;

import lombok.Data;

import java.util.Map;

/**
 * @author lanyang
 * @date 2025/12/22
 * @des 模板消息参数
 */
@Data
public class TemplateMessageParam {

    /**
     * 模板id
     */
    private String templateId;

    /**
     * 目标用户
     */
    private String targetUser;

    /**
     * 消息参数,对应模板配置中的key
     */
    private Map<String, Object> data;

    /**
     * 跳转链接
     */
    private String url;

    /**
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;

    /**
     * appId
     */
    private String appId;
}
