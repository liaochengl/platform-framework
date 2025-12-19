package com.lanyang.framework.common.domain;

import lombok.Data;

/**
 * @author lanyang
 * @date 2025/8/8
 * @des
 */
@Data
public class LoginResult {

    /** TOKEN */
    private String access_token;

    /** 过期时间 */
    private Long expires_in;

    private String phoneNumber;
}
