package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.SysRole;
import com.rtstjkx.jkx.repository.systemInfo.RoleMapper;
import com.rtstjkx.jkx.service.systemInfo.RoleService;
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
    public List<SysRole> findRoleByUserId(Integer userId) {
        List<SysRole> roles = roleMapper.findRoleByUserId(userId);
        return roles;
    }
}
