package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.Role;
import com.rtstjkx.jkx.repository.systemInfo.RoleMapper;
import com.rtstjkx.jkx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询角色列表
     * @return
     */
    @Override
    public List<Role> roleList() {
        List<Role> roles = roleMapper.roleList();
        return roles;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> addRole(Role role) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = roleMapper.addRole(role);
        if(ref>0){
            resultMap.put("msg","添加角色成功");
            resultMap.put("role",role);
        }else{
            resultMap.put("msg","添加角色失败");
        }
        return resultMap;
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @Override
    public Map<String, Object> delRole(Integer roleId) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = roleMapper.delRole(roleId);
        if(ref>0){
            resultMap.put("msg","删除角色成功");
        }else{
            resultMap.put("msg","删除角色失败");
        }
        return resultMap;
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @Override
    public Map<String, Object> updateRole(Role role) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = roleMapper.updateRole(role);
        if(ref>0){
            resultMap.put("msg","修改角色成功");
            resultMap.put("role",role);
        }else{
            resultMap.put("msg","修改角色失败");
        }
        return resultMap;

    }
}
