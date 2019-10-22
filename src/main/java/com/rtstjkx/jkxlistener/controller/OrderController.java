package com.rtstjkx.jkxlistener.controller;

import com.rtstjkx.jkxlistener.bean.ResponseCode;
import com.rtstjkx.jkxlistener.entity.Dsignal;
import com.rtstjkx.jkxlistener.entity.WorkSite;
import com.rtstjkx.jkxlistener.netty.BootNettyHandler;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 下发控制指令前端控制器
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    ResponseCode responseCode;
    @PostMapping("/orderState")
    public ResponseCode orderState(@RequestBody Dsignal dsignal,@RequestBody WorkSite workSite){
        //执行设备控制    根据product.getUrl() 上个类写入map  的key  取到map中的 ChannelHandlerContext  执行writeAndFlush发送数据
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        byte[] msg = new byte[3];
        msg[0] = Byte.parseByte(dsignal.getDsZTBYTEA());
        msg[1] = Byte.parseByte(dsignal.getDsZTBYTEB());
        msg[2] = Byte.parseByte(dsignal.getDsZTBYTEC());
        buff.writeBytes(msg);
        if(null!= BootNettyHandler.ctxMap.get(workSite.getWsIp())){
            BootNettyHandler.ctxMap.get(workSite.getWsIp()).channel().writeAndFlush(buff);
            return responseCode.success("命令发送成功");
        }else{
            return responseCode.failure("命令发送失败");
        }
    }

}
