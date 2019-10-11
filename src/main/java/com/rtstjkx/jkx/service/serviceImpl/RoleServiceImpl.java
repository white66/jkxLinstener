package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.Role;
import com.rtstjkx.jkx.repository.systemInfo.RoleMapper;
import com.rtstjkx.jkx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    /**
     * 根据用户Id查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        List<Role> roles = roleMapper.findRoleByUserId(userId);
        return roles;
    }
}
