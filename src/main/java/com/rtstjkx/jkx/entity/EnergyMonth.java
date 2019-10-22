package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 每月能耗信息
 */
@Data
public class EnergyMonth implements Serializable {
    private Integer id;
    private String wsCode;//监控箱编号
    private Float energyMonth;//每月的能耗值
    private Date dateTime;//日期（年、月、日）
    private String PCS_Code;//派出所编号
    private String PCS_Name;//派出所名称
}
