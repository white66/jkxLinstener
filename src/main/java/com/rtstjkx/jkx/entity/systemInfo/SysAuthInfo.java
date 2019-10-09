package com.rtstjkx.jkx.entity.systemInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统权限信息
 */
@Data
public class SysAuthInfo implements Serializable {
    private Integer Id;//权限ID
    private String sysAuthName;//权限名称
    private String sysAuthUrl;//权限请求的url 例如: user/login
    private String sysAuthPermission;//权限的的名称例如 user:login
    private String sysAuthAva;//权限是否生效
    private String sysAuthType;//权限类型 菜单还是按钮
    private String sysAuthDes;//权限描述
}
