package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.repository.AlarmMapper;
import com.rtstjkx.jkx.repository.SignalMapper;
import com.rtstjkx.jkx.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 接受单片机数据根据不同的命令进行存储在不同的表
 */
@Service
public class RabbitmqServiceImpl {
    @Autowired
    SignalMapper signalMapper;
    @Autowired
    AlarmMapper alarmMapper;

    public void saveMsg(String msg){
        Map<String,Object> params = new LinkedHashMap<>();
        String WS_Code = msg.substring(0,8);
        byte[] bytes = StringUtil.toByteArray(msg);
        for ( byte by :bytes){
            System.out.print(by+" ");
        }
        params.put("wsCode",WS_Code);
        if(StringUtil.fuTurnzheng(bytes[8])==130){//82命令，将接受的数据插入到c_dsignal表中
            Double dsJldn = (double)(StringUtil.fuTurnzheng(bytes[17])*256+StringUtil.fuTurnzheng(bytes[18]))*256+(StringUtil.fuTurnzheng(bytes[16])*256+StringUtil.fuTurnzheng(bytes[15]))*0.01;
            params.put("dsJldy",(bytes[11]+bytes[12]*256)*0.1);//电压值
            params.put("dsJldl",(bytes[13]+bytes[14]*256)*0.1);//电流值
            params.put("dsJldn",dsJldn);//电能
            params.put("dsDC12dy",bytes[19]*0.1);//12V电压
            params.put("dsDC24dy",(256+bytes[20])*0.1);//24V电压
            params.put("dsWD",(StringUtil.fuTurnzheng(bytes[21]))*0.1);//温度
            params.put("dsSD",(StringUtil.fuTurnzheng(bytes[23])+StringUtil.fuTurnzheng(bytes[24])*256)*0.1);//湿度
            params.put("dsZYQX",bytes[25]);//左右倾斜
            params.put("dsQHQX",bytes[26]);//前后倾斜
            params.put("dsGMADC",StringUtil.fuTurnzheng(bytes[27])+StringUtil.fuTurnzheng(bytes[28]));//光敏
            params.put("dsSJADC",bytes[29]*256+bytes[30]);//水浸
            params.put("dsZTBYTEA",StringUtil.tenTurnTwo(bytes[31]));//状态字节1
            params.put("dsZTBYTEB",StringUtil.tenTurnTwo(bytes[32]));//状态字节2
            params.put("dsZTBYTEC",StringUtil.tenTurnTwo(bytes[33]));//状态字节3
            params.put("dsPMA",StringUtil.fuTurnzheng(bytes[34]));//PM2.5
            params.put("dsPMB",StringUtil.fuTurnzheng(bytes[36]));//PM10
            params.put("dsZS",bytes[38]);//噪音
            params.put("dsYL",bytes[40]);//雨量
            params.put("dsFL",bytes[42]);//风量
            params.put("dsDateTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            signalMapper.addDsignal(params);
        }else if(StringUtil.fuTurnzheng(bytes[8])==135){//87命令，存数据到c_alarm表中
            params.put("bITValueA",StringUtil.tenTurnTwo(bytes[11]));//状态字节1
            params.put("bITValueB",StringUtil.tenTurnTwo(bytes[12]));//状态字节2
            params.put("bITValueC",StringUtil.tenTurnTwo(bytes[13]));//状态字节3
            params.put("alarmTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            alarmMapper.addAlarm(params);
        }
    }

}
