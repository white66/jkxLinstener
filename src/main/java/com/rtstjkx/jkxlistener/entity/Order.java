package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/7/7 13:06
 * @Version 1.0
 */
@Data
public class Order {
    private String wsIp;
    private String bITValueA;//状态字节1
    private String bITValueB;//状态字节2
    private String bITValueC;//状态字节3
    private String operationType;//操作指令类型
    private String orderTime;//控制命令操作时间
}
