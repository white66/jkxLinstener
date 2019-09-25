package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 单片机采集的信号数据
 */
@Data
public class Dsignal implements Serializable {
    private Integer DS_ID;
    private String WS_Code;//监控箱编号
    private Double DS_Jldy;//交流电压
    private Double DS_Jldl;//交流电流
    private Double DS_Jldn;//交流电能
    private String DS_DC12dy;//12V
    private String DS_DC24dy;//24V
    private String DS_WD;//温度
    private String DS_SD;//湿度
    private String DS_ZYQX;//左右倾斜
    private String DS_QHQX;//前后倾斜
    private String DS_GMADC;//光敏ADC
    private String DS_SJADC;//水浸
    private String DS_ZTBYTEA;//状态字节1
    private String DS_ZTBYTEB;//状态字节2
    private String DS_ZTBYTEC;//状态字节3
    private String DS_PMA;//PM2.5
    private String DS_PMB;//PM10
    private String DS_ZS;//噪声
    private String DS_YL;//雨量
    private String DS_FL;//风量
    private String DS_YLA;//预留1
    private String DS_YLB;//预留2
    private String DS_YLC;//预留3
    private String DS_YLD;//预留4
    private Date DS_DateTime;//采集时间
}