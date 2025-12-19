package com.lanyang.cloud.framework.file.config;

import io.minio.MinioClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lanyang
 * @date 2024/6/11 16:45
 * @des
 */
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
public class MinioConfig {


    @Bean
    public MinioClient minioClient(MinioProperties properties) {
        return new MinioClient.Builder().region("cn-north-1")
                .endpoint(properties.getEndPoint())
                .credentials(properties.getUsername(), properties.getPassword())
                .build();
    }
}



