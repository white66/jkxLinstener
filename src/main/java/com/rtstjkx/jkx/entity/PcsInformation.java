package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 派出所信息
 */
@Data
public class PcsInformation implements Serializable {
    private Integer id;
    private String pcsCode;//派出所编号
    private String pcsName;//派出所名称
    private String pcsAreaId;//派出所区域ID
}
