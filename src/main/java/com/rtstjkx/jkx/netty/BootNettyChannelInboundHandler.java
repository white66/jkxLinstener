package com.rtstjkx.jkx.netty;

import com.rtstjkx.jkx.rabbitmq.RabbitProducer;
import com.rtstjkx.jkx.util.StringUtil;
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


/**
 * I/O数据读写处理类
 */
@Component
@ChannelHandler.Sharable
@Slf4j
public class BootNettyChannelInboundHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    RabbitProducer rabbitProducer;
    /**
     * 从客户端收到新的数据时，这个方法会在收到消息时被调用
     *
     * @param ctx
     * @param msg
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
    {
        SocketChannel channel = (SocketChannel) ctx.channel();
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        //将字符串转成每两个字符加空格形式的字符串 7D 7D 21 3C C5 3B 0D 0D 7D 7D 25 3C
        String regex = "(.{2})";
        String input = msg.toString().replaceAll (regex, "$1 ");
        log.info(channel.localAddress().getHostString()+":  "+input);
        System.out.println ("服务端接受信息为： "+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " 接收到消息："+input);
        byte[] bytes = StringUtil.toByteArray(msg.toString());
       for (byte byt : bytes){
            System.out.print(byt+" ");
        }
        if(bytes.length>4&&bytes[4]==125&&bytes[5]==125&&bytes[bytes.length-1]==13&&bytes[bytes.length-2]==13){
            if(StringUtil.fuTurnzheng(bytes[8])==130){
                int Sum =0;
                for(int i=4;i<bytes.length-4;i++){
                    Sum=Sum+StringUtil.fuTurnzheng(bytes[i]);
                }
                int SumL = StringUtil.fuTurnzheng(bytes[bytes.length-3])+StringUtil.fuTurnzheng(bytes[bytes.length-4]*256);
                if(Sum==SumL){
                    System.out.println("校验成功，数据有效");
                    byte[] backMeg = StringUtil.backMag(0X82);
                    buff.writeBytes(backMeg);
                    ctx.writeAndFlush(buff);
                    rabbitProducer.sendMsg(msg.toString());
                }
            }
        }else if(StringUtil.fuTurnzheng(bytes[8])==135){
            int Sum =0;
            for(int i=4;i<bytes.length-4;i++){
                Sum=Sum+StringUtil.fuTurnzheng(bytes[i]);
            }
            System.out.println("检验值："+Sum);
            int SumL = StringUtil.fuTurnzheng(bytes[bytes.length-3])+StringUtil.fuTurnzheng(bytes[bytes.length-4]*256);
            System.out.println("校验和："+SumL);
            if(Sum==SumL){
                byte[] backMeg = StringUtil.backMag(0X87);
                buff.writeBytes(backMeg);
                ctx.writeAndFlush(buff);
                rabbitProducer.sendMsg(msg.toString());
            }
        }
            //回应客户端
            //ctx.writeAndFlush("I got it");
    }

    /**
     * 从客户端收到新的数据、读取完成时调用
     *
     * @param ctx
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws IOException
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
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws IOException
    {
        System.out.println("程序异常，断开客户端连接");
        cause.printStackTrace();
        ctx.close();//抛出异常，断开与客户端的连接
    }

    /**
     * 客户端与服务端第一次建立连接时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception, IOException
    {
        SocketChannel channel = (SocketChannel) ctx.channel();
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        System.out.println("有一客户端链接到本服务端"+"  IP:" + clientIp);
        log.info(clientIp+"连接");
    }

    /**
     * 客户端与服务端 断连时 执行
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception, IOException
    {
        super.channelInactive(ctx);
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        ctx.close(); //断开连接时，必须关闭，否则造成资源浪费，并发量很大情况下可能造成宕机
        System.out.println("连接断开:"+clientIp);
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
