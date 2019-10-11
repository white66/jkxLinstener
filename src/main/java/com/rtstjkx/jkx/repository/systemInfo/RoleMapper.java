package com.rtstjkx.jkx.repository.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleMapper {
    /**
     * 根据用户的ID查询用户所拥有的的角色信息
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(Integer userId);
}
