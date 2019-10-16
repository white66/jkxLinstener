package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.systemInfo.Role;
import com.rtstjkx.jkx.service.serviceImpl.RoleServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 角色控制器
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    ResponseCode responseCode;

    /**
     * 查询角色列表
     * @return
     */
    @GetMapping("/roleList")
    @RequiresPermissions("role:view")
    public ResponseCode roleList(){
        List<Role> roleList = roleService.roleList();
        return responseCode.success(roleList);
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping("/roleAdd")
    @RequiresPermissions("role:add")
    public ResponseCode addRole(Role role){
        Map<String,Object> resultMap = roleService.addRole(role);
        return responseCode.success(resultMap);
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @DeleteMapping("/roleDel")
    @RequiresPermissions("role:del")
    public ResponseCode delRole(Integer roleId){
        Map<String,Object> resultMap = roleService.delRole(roleId);
        return responseCode.success(resultMap);
    }
    /**
     * 修改角色
     * @param role
     * @return
     */
    @PostMapping("/roleUpdate")
    @RequiresPermissions("role:update")
    public ResponseCode updateRole(Role role){
        Map<String,Object> resultMap = roleService.updateRole(role);
        return responseCode.success(resultMap);
    }
}
