package com.lanyang.cloud.framework.http.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author lanyang
 * @date 2024/7/3 15:37
 * @des
 */
@Configuration
@EnableConfigurationProperties(HttpClientPoolConfig.class)
public class RestTemplateConfig {

    @Autowired
    private HttpClientPoolConfig poolConfig;

    @Bean("httpClientRestTemplate")
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        ClientHttpRequestFactory requestFactory = clientHttpRequestFactory();
        restTemplate.setRequestFactory(requestFactory);
        return restTemplate;
    }

    @Bean
    public HttpClientConnectionManager httpClientConnectionManager(){
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
        // 最大连接数
        manager.setMaxTotal(poolConfig.getMaxTotalConnect());
        // 路由并发, 每个主机
//        manager.setDefaultMaxPerRoute(poolConfig.getMaxConnectPerRoute());
        return manager;
    }

    @Bean
    public HttpClient httpClient(){
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setConnectionManager(httpClientConnectionManager());
        // 重试
//        builder.setRetryHandler(new DefaultHttpRequestRetryHandler(3, true));
        return builder.build();
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        factory.setHttpClient(this.httpClient());
        // 连接超时时间  5秒
        factory.setConnectTimeout(poolConfig.getConnectTimeout());
        // 读取时间, 可视情况加长
        factory.setReadTimeout(poolConfig.getReadTimeout());
        // 连接池获取连接时间
        factory.setConnectionRequestTimeout(poolConfig.getConnectionRequestTimout());
        return factory;
    }


}
