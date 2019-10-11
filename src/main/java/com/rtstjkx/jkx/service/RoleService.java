package com.rtstjkx.jkx.service;


import com.rtstjkx.jkx.entity.systemInfo.Role;

import java.util.List;

public interface RoleService {
    /**
     * 通过用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);
}
