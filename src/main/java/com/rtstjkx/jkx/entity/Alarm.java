package com.rtstjkx.jkx.entity;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 告警信息
 */
@Data
public class Alarm implements Serializable {
    private Integer id;
    private String bITValueA;//状态字节1
    private Integer bITCode;//
    private String wsCode;//监控箱编号
    private String bITValueB;//状态字节2
    private String bITValueC;//状态字节3
    private Date alarmTime;//告警时间
}
