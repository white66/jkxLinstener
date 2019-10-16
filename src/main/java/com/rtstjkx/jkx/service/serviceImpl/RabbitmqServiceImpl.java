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
        String WS_Code = msg.substring(0,7);
        byte[] bytes = StringUtil.toByteArray(msg);
        for ( byte by :bytes){
            System.out.print(by+" ");
        }
        params.put("WS_Code",WS_Code);
        if(StringUtil.fuTurnzheng(bytes[8])==130){//82命令，将接受的数据插入到c_dsignal表中
            Double DS_Jldy = (bytes[11]+bytes[12]*256)*0.1;
            Double DS_Jldl = (bytes[13]+bytes[14]*256)*0.1;
            Double DS_Jldn = (double)(StringUtil.fuTurnzheng(bytes[17])*256+StringUtil.fuTurnzheng(bytes[18]))*256+(StringUtil.fuTurnzheng(bytes[16])*256+StringUtil.fuTurnzheng(bytes[15]))*0.01;
            params.put("DS_Jldy",DS_Jldy);//电压值
            params.put("DS_Jldl",DS_Jldl);//电流值
            params.put("DS_Jldn",DS_Jldn);//电能
            params.put("DS_DC12dy",bytes[19]*0.1);//12V电压
            params.put("DS_DC24dy",(256+bytes[20])*0.1);//24V电压
            params.put("DS_WD",(StringUtil.fuTurnzheng(bytes[21]))*0.1);//温度
            params.put("DS_SD",(StringUtil.fuTurnzheng(bytes[23])+StringUtil.fuTurnzheng(bytes[24])*256)*0.1);//湿度
            params.put("DS_ZYQX",bytes[25]);//左右倾斜
            params.put("DS_QHQX",bytes[26]);//前后倾斜
            params.put("DS_GMADC",StringUtil.fuTurnzheng(bytes[27])+StringUtil.fuTurnzheng(bytes[28]));//光敏
            params.put("DS_SJADC",bytes[29]*256+bytes[30]);//水浸
            params.put("DS_ZTBYTEA",StringUtil.tenTurnTwo(bytes[31]));//状态字节1
            params.put("DS_ZTBYTEB",StringUtil.tenTurnTwo(bytes[32]));//状态字节2
            params.put("DS_ZTBYTEC",StringUtil.tenTurnTwo(bytes[33]));//状态字节3
            params.put("DS_PMA",StringUtil.fuTurnzheng(bytes[34]));//PM2.5
            params.put("DS_PMB",StringUtil.fuTurnzheng(bytes[36]));//PM10
            params.put("DS_ZS",bytes[38]);//噪音
            params.put("DS_YL",bytes[40]);//雨量
            params.put("DS_FL",bytes[42]);//风量
            params.put("DS_DateTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            signalMapper.addDsignal(params);
        }else if(StringUtil.fuTurnzheng(bytes[8])==135){//87命令，存数据到c_alarm表中
            params.put("DS_ZTBYTEA",StringUtil.tenTurnTwo(bytes[11]));//状态字节1
            params.put("DS_ZTBYTEB",StringUtil.tenTurnTwo(bytes[12]));//状态字节2
            params.put("DS_ZTBYTEC",StringUtil.tenTurnTwo(bytes[13]));//状态字节3
            params.put("AlarmTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            alarmMapper.addAlarm(params);
        }
    }

}
