package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AlarmInformation implements Serializable {
    private Integer id;
    private String alarmName;//告警名称
    private Integer alarmBitAddress;//告警bit位置
}
