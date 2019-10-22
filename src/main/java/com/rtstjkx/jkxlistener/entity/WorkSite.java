package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WorkSite implements Serializable {
    private String wsCode;//监控箱编号
    private String wsName;//监控点名称
    private String wsIp;//监控箱IP
    private String wsOrgCode;//责任人
    private String wsAreaCode;//区域ID
    private String wsDwsCode;//设备ID
    private Double wsLongitude;//经度
    private Double wsLatitude;//维度
    private String wsSysCode;//所属派出所ID
    private String wsOperators;//维护人
    private String wsNum;//预留
    private String wsState;//状态
    private Integer pageSize;
    private Integer pageNum;
    private String pcsCode;//派出所编号
    private String pcsName;//派出所名称
    private String pcsAreaId;//派出所区域ID
}
