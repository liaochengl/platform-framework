package com.lanyang.cloud.framework.message.domain.vo;
import lombok.Data;

import java.util.Map;

/**
 *
 * 微信消息参数
 *
 * @author lanyang
 * @date 2024/7/4 15:18
 * @des
 */
@Data
public class WechatMessageVO {

    /**
     * appId
     */
    private String appId;

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
     * 点击模板卡片后的跳转页面，仅限本小程序内的页面。支持带参数,（示例index?foo=bar）。该字段不填则模板无跳转
     */
    private String page;

    /**
     * 跳转小程序类型：developer为开发版；trial为体验版；formal为正式版；默认为正式版
     */
    private String miniProgramState;
}
