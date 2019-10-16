package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.entity.systemInfo.Permission;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AuthService {
    /**
     * 根据角色ID查询所拥有的权限
     * @param roleIds
     * @return
     */
    Set<String> findAuthByRoleIds(List<Integer> roleIds);

    /**
     * 查询权限列表
     * @return
     */
    List<Permission> authList();

    /**
     * 添加权限
     * @param permission
     * @return
     */
    Map<String,Object> authAdd(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    Map<String,Object> authDel(Integer permissionId);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    Map<String,Object> authUpdate(Permission permission);
}
