package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;
@Data
public class wson_off implements Serializable {
    private Integer id;
    private String WS_Code;//监控箱编号
    private String DV121STA;//12V-1的状态
    private Integer DV121SXJCOMID;//对应的摄像机厂家ID
    private Integer DV121SXJID;//对应摄像机ID
    private String DV122STA;//12V-2的状态
    private Integer DV122SXJCOMID;//对应的摄像机厂家ID
    private Integer DV122SXJID;//对应摄像机ID
    private String DV123STA;//12V-3的状态
    private Integer DV123SXJCOMID;//对应的摄像机厂家ID
    private Integer DV123SXJID;//对应摄像机ID
    private String DV241STA;//24V-1的状态
    private Integer DV241SXJCOMID;//对应的摄像机厂家ID
    private Integer DV241SXJID;//对应摄像机ID
    private String DV242STA;//24V-2的状态
    private Integer DV242SXJCOMID;//对应的摄像机厂家ID
    private Integer DV242SXJID;//对应摄像机ID
    private String DV2201STA;//220V-1的状态
    private Integer DV2201SXJCOMID;
    private Integer DV2201SXJID;
    private String DV2202STA;//220V-1的状态
    private Integer DV2202SXJCOMID;
    private Integer DV2202SXJID;
    private String POE1STA;//POE-1的状态
    private Integer POE1SXJCOMID;
    private Integer POE1SXJID;
    private String POE2STA;//POE-2的状态
    private Integer POE2SXJCOMID;
    private Integer POE2SXJID;
    private String POE3STA;//POE-3的状态
    private Integer POE3SXJCOMID;
    private Integer POE3SXJID;
    private String POE4STA;//POE-4的状态
    private Integer POE4SXJCOMID;
    private Integer POE4SXJID;
}
