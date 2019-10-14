package com.rtstjkx.jkx.repository.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.Permission;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface AuthMapper {
    /**
     * 通过角色Id查询角色的权限信息
     * @return
     */
    Set<String> findAuthByRoleId(List<Integer> roleIds);

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
    int authAdd(Permission permission);

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    int authDel(Integer permissionId);

    /**
     * 修改权限
     * @param permission
     * @return
     */
    int authUpdate(Permission permission);
}
