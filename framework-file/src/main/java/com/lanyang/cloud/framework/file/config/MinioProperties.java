package com.lanyang.cloud.framework.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author lanyang
 * @date 2024/6/12 14:54
 * @des
 */
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String endPoint;

    private String username;

    private String password;

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
