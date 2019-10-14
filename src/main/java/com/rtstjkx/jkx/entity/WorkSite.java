package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkSite implements Serializable {
    private String WS_Code;//监控箱编号
    private String WS_Name;//监控点名称
    private String WS_IP;//监控箱IP
    private String WS_Org_Code;//责任人
    private String WS_Area_Code;//区域ID
    private String WS_DWS_Code;//设备ID
    private Double WS_Longitude;//经度
    private Double WS_Latitude;//维度
    private String WS_Operators;//维护人
    private String WS_Num;//预留
    private String WS_State;//状态
}
