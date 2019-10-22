package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 单片机采集的信号数据
 */
@Data
public class Dsignal implements Serializable {
    private Integer dsID;
    private String wsCode;//监控箱编号
    private Double dsJldy;//交流电压
    private Double dsJldl;//交流电流
    private Double dsJldn;//交流电能
    private String dsDC12dy;//12V
    private String dsDC24dy;//24V
    private String dsWD;//温度
    private String dsSD;//湿度
    private String dsZYQX;//左右倾斜
    private String dsQHQX;//前后倾斜
    private String dsGMADC;//光敏ADC
    private String dsSJADC;//水浸
    private String dsZTBYTEA;//状态字节1
    private String dsZTBYTEB;//状态字节2
    private String dsZTBYTEC;//状态字节3
    private String dsPMA;//PM2.5
    private String dsPMB;//PM10
    private String dsZS;//噪声
    private String dsYL;//雨量
    private String dsFL;//风量
    private String dsYLA;//预留1
    private String dsYLB;//预留2
    private String dsYLC;//预留3
    private String dsYLD;//预留4
    private Date dsDateTime;//采集时间
}