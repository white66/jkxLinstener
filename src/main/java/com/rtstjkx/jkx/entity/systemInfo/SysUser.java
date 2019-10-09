package com.rtstjkx.jkx.entity.systemInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统用户信息
 */
@Data
public class SysUser implements Serializable {
    private Integer Id;//用户编号
    private String userAccount;//用户账号
    private String userPassword;//用户密码
}
