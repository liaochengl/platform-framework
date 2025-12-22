package com.lanyang.cloud.framework.message.domain.wechat.response;

import lombok.Data;

/**
 * 微信消息响应结果
 *
 * @author lanyang
 * @date 2024/7/4 17:10
 * @des
 */
@Data
public class WechatMessageResponseDTO {

    /**
     * 结果码 0-成功 其他失败
     */
    private Integer errcode;

    /**
     * 响应信息
     */
    private String errmsg;

    /**
     * 消息id
     */
    private String msgid;
}
