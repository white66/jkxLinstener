package com.rtstjkx.jkx.service.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.SysRole;

import java.util.List;

public interface RoleService {
    /**
     * 通过用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    List<SysRole> findRoleByUserId(Integer userId);
}
