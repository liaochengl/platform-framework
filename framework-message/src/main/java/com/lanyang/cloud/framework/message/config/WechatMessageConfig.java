package com.lanyang.cloud.framework.message.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author lanyang
 * @date 2024/7/5 16:16
 * @des
 */
@ConfigurationProperties(prefix = "wechat")
@Data
@Component
public class WechatMessageConfig {

    private String server = "https://api.weixin.qq.com";

    private String tokenUrl = "/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    private String templateMessageUrl = "/cgi-bin/message/template/send?access_token=%s";

    private String subscribeMessageUrl = "/cgi-bin/message/subscribe/send?access_token=%s";

    private String appId;

    private String appSecret;

    private Map<String, String> app;
}
