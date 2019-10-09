package com.rtstjkx.jkx.entity.systemInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 系统角色信息
 */
@Data
public class SysRole implements Serializable {
    private Integer Id;//角色Id
    private String sysRoleAva;//角色是否生效
    private String sysRoleDes;//角色描述
    private String sysRoleName;//角色名称
}
