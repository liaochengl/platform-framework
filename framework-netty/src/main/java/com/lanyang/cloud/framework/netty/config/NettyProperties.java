package com.lanyang.cloud.framework.netty.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author lanyang
 * @date 2025/12/11
 * @des
 */
@ConfigurationProperties(prefix = "netty")
@Component
public class NettyProperties {

    /** 端口号 */
    public static Integer port = 18050;

    /** boss线程 */
    public static Integer bossCount = 1;

    /** worker线程 */
    public static Integer workerCount = 50;

    /** 是否active */
    public static boolean keepalive = true;

    /**  */
    public static Integer backlog = 100;

    /** 心跳周期，实际为发帧间隔，单位为 秒 */
    public static Integer heartbeat = 2;

    /** 定时器延时启动时间，单位为 秒 */
    public static Integer delay = 35;

    /** 采集周期 单位为 分钟，与数据库中周期单位对应 */
    public static Integer readPeriod = 15;


    /** JSON 格式数据的解码器 默认为true,默认报文为json格式*/
    public static Boolean jsonDecoder = true;

    /**
     * json 数据包最大长度 默认5KB
     */
    public static Integer maxObjectLength = 5120;

    public static Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        NettyProperties.port = port;
    }

    public static Integer getBossCount() {
        return bossCount;
    }

    public void setBossCount(Integer bossCount) {
        NettyProperties.bossCount = bossCount;
    }

    public static Integer getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(Integer workerCount) {
        NettyProperties.workerCount = workerCount;
    }

    public static boolean isKeepalive() {
        return keepalive;
    }

    public void setKeepalive(boolean keepalive) {
        NettyProperties.keepalive = keepalive;
    }

    public static Integer getBacklog() {
        return backlog;
    }

    public void setBacklog(Integer backlog) {
        NettyProperties.backlog = backlog;
    }

    public static Integer getHeartbeat() {
        return heartbeat;
    }

    public void setHeartbeat(Integer heartbeat) {
        NettyProperties.heartbeat = heartbeat;
    }

    public static Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        NettyProperties.delay = delay;
    }

    public static Integer getReadPeriod() {
        return readPeriod;
    }

    public void setReadPeriod(Integer readPeriod) {
        NettyProperties.readPeriod = readPeriod;
    }

    public static Boolean getJsonDecoder() {
        return jsonDecoder;
    }

    public void setJsonDecoder(Boolean jsonDecoder) {
        NettyProperties.jsonDecoder = jsonDecoder;
    }

    public static Integer getMaxObjectLength() {
        return maxObjectLength;
    }

    public void setMaxObjectLength(Integer maxObjectLength) {
        NettyProperties.maxObjectLength = maxObjectLength;
    }
}
