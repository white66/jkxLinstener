package com.rtstjkx.jkxlistener.controller;

import com.rtstjkx.jkxlistener.entity.Dsignal;
import com.rtstjkx.jkxlistener.entity.Order;
import com.rtstjkx.jkxlistener.netty.BootNettyHandler;
import com.rtstjkx.jkxlistener.service.serviceImpl.OrderServiceImpl;
import com.rtstjkx.jkxlistener.util.StringUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 下发控制指令前端控制器
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @GetMapping("/orderState")
    public int orderState( Dsignal dsignal){
        System.out.println("---可以进来---"+dsignal.getWsIp());
        //执行设备控制    根据product.getUrl() 上个类写入map  的key  取到map中的 ChanlHandlerContext  执行writeAndFlush发送数据
        Map<String,Object> param = new HashMap<>();
        ByteBuf buff = Unpooled.buffer();//netty需要用ByteBuf传输
        byte[] msg =StringUtil.orderMsg(dsignal);
        buff.writeBytes(msg);
        if(null!= BootNettyHandler.ctxMap.get(dsignal.getWsIp())){
            BootNettyHandler.ctxMap.get(dsignal.getWsIp()).writeAndFlush(buff);
            param.put("wsIp",dsignal.getWsIp());
            param.put("bITValueA",dsignal.getDsZTBYTEA());
            param.put("bITValueB",dsignal.getDsZTBYTEB());
            param.put("bITValueC",dsignal.getDsZTBYTEC());
            param.put("operationType",dsignal.getOperationType());
            param.put("orderTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            orderService.inserOrder(param);
            log.info("下发命令"+msg.toString()+"成功");
            return 1;
        }else{
            log.info("下发命令失败");
            return 0;
        }
    }

}
