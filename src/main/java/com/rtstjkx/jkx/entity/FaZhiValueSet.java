package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 阀值信息
 */
@Data
public class FaZhiValueSet implements Serializable {
    private Integer id;
    private String WS_Code;//监控箱编号
    private String JLDYUP;//交流电压上限值
    private String JLDYDown;//交流电压下限值
    private String ZYQX;//左右倾斜阀值
    private String QHQX;//前后倾斜阀值
    private String SJADC;//水浸阀值
    private String WDUP;//温度上限
    private String WDDown;//温度下限
    private String YL1;//预留1
    private String YL2;//预留2
    private String YL3;
    private String YL4;
    private String YL5;
    private String YL6;
    private Integer UPDateTime;//上传时间间隔
}