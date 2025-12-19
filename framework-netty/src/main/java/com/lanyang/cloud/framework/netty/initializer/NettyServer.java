package com.lanyang.cloud.framework.netty.initializer;

import com.lanyang.cloud.framework.netty.config.NettyProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * @author lanyang
 * @date 2025/12/11
 * @des
 */
@Component
public class NettyServer {

    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap serverBootstrap;

    private Channel serverChannel;

    public void start() throws Exception {
        serverChannel = serverBootstrap.bind(NettyProperties.getPort()).sync().channel().closeFuture().sync().channel();
    }

    @PreDestroy
    public void stop() throws Exception {
        serverChannel.close();
        serverChannel.parent().close();
    }
}
