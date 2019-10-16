package com.rtstjkx.jkx.netty;

import com.rtstjkx.jkx.netty.coder.MyDecoder;
import com.rtstjkx.jkx.netty.coder.MyEncoder;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 通道初始化
 * @param <SocketChannel>
 */
@Component
public class BootNettyChannelInitializer<SocketChannel> extends ChannelInitializer<Channel> {

    @Autowired
    BootNettyChannelInboundHandler bootNettyChannelInboundHandler;
    @Autowired
    MyDecoder myDecoder;
    @Override
    protected void initChannel(Channel ch) throws Exception {
        // ChannelOutboundHandler，依照逆序执行
        //ch.pipeline().addLast("encoder", myEncoder);
        // 属于ChannelInboundHandler，依照顺序执行
        ch.pipeline().addLast("decoder", myDecoder);
        /*ByteBuf delimiter = Unpooled.copiedBuffer("0D 0D".getBytes());
        //1024 是单条消息的最大长度，如果达到该长度后仍然没有找到分隔符就会抛出异常，这点大家要特别注意。delimiter就是我们的分隔符。
        ch.pipeline().addLast(new DelimiterBasedFrameDecoder(2048,false, delimiter));
        ch.pipeline().addLast(new StringDecoder(Charset.forName("utf-16")));
        ch.pipeline().addLast(new StringEncoder(Charset.forName("utf-16")));*/
        // 心跳监测机制
       // ch.pipeline().addLast(new IdleStateHandler(5,7,10, TimeUnit.SECONDS));

        /**
         * 自定义ChannelInboundHandlerAdapter
         */
        ch.pipeline().addLast(bootNettyChannelInboundHandler);
        System.out.println("信道初始化中....");
    }
}
