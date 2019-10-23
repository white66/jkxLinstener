package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 每日能耗信息
 */
@Data
public class EnergyDay implements Serializable {
    private Integer id;
    private String wsCode;//监控箱编号
    private Float energyDay;//每天的能耗值
    private Date dateTime;//日期（年、月、日）
    private Integer pcsCode;//派出所编号
    private String pcsName;//派出所名称
}
