package com.rtstjkx.jkxlistener.controller;

import com.rtstjkx.jkxlistener.bean.ResponseCode;
import com.rtstjkx.jkxlistener.entity.Dsignal;
import com.rtstjkx.jkxlistener.netty.BootNettyHandler;
import com.rtstjkx.jkxlistener.util.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 下发控制指令前端控制器
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @GetMapping("/orderState")
    public int orderState( Dsignal dsignal){
        System.out.println("---可以进来---"+dsignal.getWsIp());
        //执行设备控制    根据product.getUrl() 上个类写入map  的key  取到map中的 ChanlHandlerContext  执行writeAndFlush发送数据
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        byte[] msg =StringUtil.orderMsg(dsignal);
        buff.writeBytes(msg);
        if(null!= BootNettyHandler.ctxMap.get(dsignal.getWsIp())){
            BootNettyHandler.ctxMap.get(dsignal.getWsIp()).writeAndFlush(buff);
            return 1;
        }else{
            return 0;
        }
    }

}
