package com.rtstjkx.jkx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 公司信息
 */
@Data
public class Company implements Serializable {
    private Integer id;
    private String comName;//公司名称
}
