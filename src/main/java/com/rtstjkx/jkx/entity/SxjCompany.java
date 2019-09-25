package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 摄像机厂家信息
 */
@Data
public class SxjCompany implements Serializable {
    private Integer id;
    private String SXJCom;//摄像机厂家名称
    private String SXJYA;//预留1
    private String SXJYB;//预留
    private String SXJYC;
}
