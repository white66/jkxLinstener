package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class WorkSiteState implements Serializable {
    private Integer id;
    private String WS_Code;//监控箱编号
    private String BITValueA;//状态字节1
    private String BITValueB;//状态字节2
    private String BITValueC;//状态字节3
    private Date alarmTime;//告警时间
}
