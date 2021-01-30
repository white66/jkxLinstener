package com.rtstjkx.jkxlistener.netty;

import com.rtstjkx.jkxlistener.rabbitmq.RabbitProducer;
import com.rtstjkx.jkxlistener.util.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;

import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * I/O数据读写处理类
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class BootNettyHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    RabbitProducer rabbitProducer;
    //  将当前客户端连接 存入map   实现控制设备下发 参数
    public  static Map<String, Channel> ctxMap = new LinkedHashMap<String, Channel>();
    /**
     * 从客户端收到新的数据时，这个方法会在收到消息时被调用
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        SocketChannel channel = (SocketChannel) ctx.channel();
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        //将字符串转成每两个字符加空格形式的字符串 7D 7D 21 3C C5 3B 0D 0D 7D 7D 25 3C
        String regex = "(.{2})";
        String input = msg.toString().replaceAll(regex, "$1 ");
        log.info(channel.remoteAddress().getHostString() + ":  " + input);
        System.out.println("服务端接受信息为： " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息：" + input);
        byte[] bytes = StringUtil.toByteArray(msg.toString());
        if (bytes.length > 4 && bytes[4] == 125 && bytes[5] == 125 && bytes[bytes.length - 1] == 13 && bytes[bytes.length - 2] == 13) {
            if (StringUtil.fuTurnzheng(bytes[8]) == 130) {
                int Sum = 0;
                for (int i = 4; i < bytes.length - 4; i++) {
                    Sum = Sum + StringUtil.fuTurnzheng(bytes[i]);
                }
                int SumL = StringUtil.fuTurnzheng(bytes[bytes.length - 3]) + StringUtil.fuTurnzheng(bytes[bytes.length - 4] * 256);
                if (Sum == SumL) {
                    System.out.println("校验成功，数据有效");
                    byte[] backMeg = StringUtil.backMag(0X82);
                    buff.writeBytes(backMeg);
                    ctx.writeAndFlush(buff);
                    rabbitProducer.sendMsg(msg.toString());
                }
            } else if (StringUtil.fuTurnzheng(bytes[8]) == 135) {
                int Sum = 0;
                for (int i = 4; i < bytes.length - 4; i++) {
                    Sum = Sum + StringUtil.fuTurnzheng(bytes[i]);
                }
                int SumL = StringUtil.fuTurnzheng(bytes[bytes.length - 3]) + StringUtil.fuTurnzheng(bytes[bytes.length - 4] * 256);
                if (Sum == SumL) {
                    System.out.println("告警校验和：" + SumL);
                    byte[] backMeg = StringUtil.backMag(0X87);
                    buff.writeBytes(backMeg);
                    ctx.writeAndFlush(buff);
                    rabbitProducer.sendMsg(msg.toString());
                }
            }else if(StringUtil.fuTurnzheng(bytes[8]) == 132){
                int Sum = 0;
                for (int i = 4; i < bytes.length - 4; i++) {
                    Sum = Sum + StringUtil.fuTurnzheng(bytes[i]);
                }
                int SumL = StringUtil.fuTurnzheng(bytes[bytes.length - 3]) + StringUtil.fuTurnzheng(bytes[bytes.length - 4] * 256);
                if (Sum == SumL) {
                    System.out.println("控制指令成功校验和：" + SumL);
                }
            }
        }
    }
    /**
     * 从客户端收到新的数据、读取完成时调用
     *
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)
    {
        ctx.flush();
    }

    /**
     * 当出现 Throwable 对象才会被调用，即当 Netty 由于 IO 错误或者处理器在处理事件时抛出的异常时
     *
     * @param ctx
     * @param cause
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
    {
        System.out.println("程序异常，断开客户端连接");
        //获取客户端的请求地址  取到的值为客户端的 ip+端口号
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();//设备请求地址（个人将设备的IP地址当作 map 的key）
        if(ctxMap.get(clientIp)!=null){//如果不为空就剔除
            ctxMap.remove(clientIp, ctx.channel());
        }else{//否则就将当前的设备ip+端口存进map  当做下发设备的标识的key
        }
        cause.printStackTrace();
        ctx.close();//抛出异常，断开与客户端的连接
        log.info(clientIp+"连接断开");
    }

    /**
     * 客户端与服务端第一次建立连接时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx)
    {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        if(ctxMap.get(clientIp)!=null){//如果不为空就不存
        }else{//否则就将当前的设备ip+端口存进map  当做下发设备的标识的key
            ctxMap.put(clientIp, ctx.channel());
        }
        log.info(clientIp+"连接");
    }

    /**
     * 客户端与服务端 断连时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception
    {
        super.channelInactive(ctx);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        if(ctxMap.get(clientIp)!=null){//如果不为空就剔除
            ctxMap.remove(clientIp, ctx.channel());
        }else{//否则就将当前的设备ip+端口存进map  当做下发设备的标识的key
        }
        ctx.close(); //断开连接时，必须关闭，否则造成资源浪费，并发量很大情况下可能造成宕机
        log.info(clientIp+"断开");
    }
    /**
     * 服务端当read超时, 会调用这个方法
     *
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception, IOException
    {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "读空闲";
                    break;
                case WRITER_IDLE:
                    eventType = "些空闲";
                    break;
                case ALL_IDLE:
                    eventType = "读写空闲";
                    break;
                default:
            }
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            log.info(date + " " + ctx.channel().remoteAddress() + " " + eventType);
        }
    }
}
