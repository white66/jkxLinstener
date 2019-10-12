package com.rtstjkx.jkx.service;


import com.rtstjkx.jkx.entity.systemInfo.Role;

import java.util.List;
import java.util.Map;

public interface RoleService {
    /**
     * 通过用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);

    /**
     * 查询所有角色列表
     * @return
     */
    List<Role> roleList();

    /**
     * 添加角色
     * @param role
     * @return
     */
    Map<String,Object> addRole(Role role);

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    Map<String,Object> delRole(Integer roleId);

    /**
     * 修改角色
     * @param role
     * @return
     */
    Map<String,Object> updateRole(Role role);
}
