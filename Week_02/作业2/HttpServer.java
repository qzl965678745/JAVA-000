package com.example.springboot.springbootdemo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qzl
 * @create 2020/10/25
 */
public class HttpServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(3);
        EventLoopGroup workerGroup = new NioEventLoopGroup(1000);
        try {
            ServerBootstrap b = new ServerBootstrap();
//            b.option(ChannelOption.SO_BACKLOG,128)
//                    .option(ChannelOption.SO_KEEPALIVE,true)
//                    .option(ChannelOption.TCP_NODELAY,true)
//                    .option(ChannelOption.SO_REUSEADDR,true)
//                    .option(ChannelOption.SO_RCVBUF,32*1024)
//                    .option(ChannelOption.SO_SNDBUF,32*1024)
//                    .option(EpollChannelOption.SO_REUSEPORT,true)
//                    .option(EpollChannelOption.SO_KEEPALIVE,true);
            b.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new HttpInitializer());
            ChannelFuture future = b.bind(8080).sync();
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}
