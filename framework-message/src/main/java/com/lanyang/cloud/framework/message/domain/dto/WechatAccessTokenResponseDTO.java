package com.lanyang.cloud.framework.message.domain.dto;

import lombok.Data;

/**
 *
 * 微信获取access_token响应结果
 * @author lanyang
 * @date 2024/7/4 15:32
 * @des
 */
@Data
public class WechatAccessTokenResponseDTO {

    /**
     * access_token
     */
    private String access_token;

    /**
     * 过期时间
     */
    private Long expires_in;
}
