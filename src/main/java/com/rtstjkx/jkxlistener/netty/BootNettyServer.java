package com.rtstjkx.jkxlistener.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.AdaptiveRecvByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * netty的server
 */
@Component
@Slf4j
public class BootNettyServer {
    @Autowired
    BootNettyInitializer bootNettyInitializer;

    public void run(int port) throws Exception {
        /**
         * 配置服务端的NIO线程组
         * NioEventLoopGroup 是用来处理I/O操作的Reactor线程组
         * bossGroup：用来接收进来的连接，workerGroup：用来处理已经被接收的连接,进行socketChannel的网络读写，
         * bossGroup接收到连接后就会把连接信息注册到workerGroup
         * workerGroup的EventLoopGroup默认的线程数是CPU核数的二倍
         */
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();//ServerBootstrap 是一个启动NIO服务的辅助启动类
            serverBootstrap
                    .group(bossGroup, workerGroup)//设置group，将bossGroup， workerGroup线程组传递到ServerBootstrap
                    .channel(NioServerSocketChannel.class)//ServerSocketChannel是以NIO的selector为基础进行实现的，用来接收新的连接，这里告诉Channel通过NioServerSocketChannel获取新的连接
                    /**
                     * option是设置 bossGroup，childOption是设置workerGroup
                     * netty 默认数据包传输大小为1024字节, 设置它可以自动调整下一次缓冲区建立时分配的空间大小，避免内存的浪费    最小  初始化  最大 (根据生产环境实际情况来定)
                     * 使用对象池，重用缓冲区
                     */
                    .option(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(64, 10496, 1048576))
                    .childOption(ChannelOption.RCVBUF_ALLOCATOR, new AdaptiveRecvByteBufAllocator(64, 10496, 1048576))
                    .childHandler(bootNettyInitializer);//设置 I/O处理类,主要用于网络I/O事件，记录日志，编码、解码消息
            System.out.println("正在监听8234端口中....");
            ChannelFuture f = serverBootstrap.bind(port).sync();//绑定端口，同步等待成功
            f.channel().closeFuture().sync();//等待服务器监听端口关闭
        } catch (InterruptedException e) {

        } finally {
            /**
             * 退出，释放线程池资源
             */
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }
    }
}
