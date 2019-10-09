package com.rtstjkx.jkx.entity;

import lombok.Data;
import java.io.Serializable;

/**
 * 告警信息
 */
@Data
public class Alarm implements Serializable {
    private Integer id;
    private String BITValueA;//状态字节1
    private Integer BITCode;//
    private String WS_Code;//监控箱编号
    private String BITValueB;//状态字节2
    private String BITValueC;//状态字节3
    private java.sql.Date alarmTime;//告警时间
}
