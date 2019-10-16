package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.systemInfo.Permission;
import com.rtstjkx.jkx.service.serviceImpl.AuthServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 权限控制器
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthServiceImpl authService;
    @Autowired
    ResponseCode responseCode;

    /**
     *查询权限列表
     * @return
     */
    @GetMapping("/authList")
    public ResponseCode authList(){
        List<Permission> permissionList = authService.authList();
        return responseCode.success(permissionList);
    }

    /**
     * 查询角色所拥有的的权限
     * @param roleId
     * @return
     */
    @GetMapping("/findAuthByRoleId")
    public ResponseCode findAuthByRoleId(Integer roleId){
        List<Integer> params = new ArrayList<>();
        params.add(roleId);
        Set<String> permissionList = authService.findAuthByRoleIds(params);
        return responseCode.success(permissionList);
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @PostMapping("/authAdd")
    public ResponseCode authAdd(Permission permission){
        Map<String,Object> resultMap = authService.authAdd(permission);
        return responseCode.success(resultMap);
    }

    /**
     * 删除权限
     * @param permissionId
     * @return
     */
    @DeleteMapping("/authDel")
    public ResponseCode authDel(Integer permissionId){
        Map<String,Object> resultMap = authService.authDel(permissionId);
        return responseCode.success(resultMap);
    }

    /**
     * 修改权限
     * @param permission
     * @return
     */
    @PostMapping("/authUpdate")
    public ResponseCode authUpdate(Permission permission){
        Map<String,Object> resultMap = authService.authUpdate(permission);
        return responseCode.success(resultMap);
    }
}
