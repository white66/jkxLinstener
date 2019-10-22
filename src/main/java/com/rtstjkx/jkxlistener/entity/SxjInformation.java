package com.rtstjkx.jkxlistener.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 摄像机信息
 */
@Data
public class SxjInformation implements Serializable {
    private Integer id;
    private Integer SXJComId;//摄像机厂家ID
    private String SXJName;//摄像机名称
    private String SXJType;//摄像机类型
}
