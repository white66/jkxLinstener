package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.Permission;
import com.rtstjkx.jkx.repository.systemInfo.AuthMapper;
import com.rtstjkx.jkx.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;

    /**
     * 根据角色ID查询所拥有的权限
     * @param roleIds
     * @return
     */
    @Override
    public Set<String> findAuthByRoleIds(List<Integer> roleIds) {
        Set<String> sysAuthInfos = authMapper.findAuthByRoleId(roleIds);
        return sysAuthInfos;
    }

    /**
     * 查询权限列表
     * @return
     */
    @Override
    public List<Permission> authList() {
        List<Permission> permissionList = authMapper.authList();
        return permissionList;
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @Override
    public Map<String, Object> authAdd(Permission permission) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref= authMapper.authAdd(permission);
        if(ref>0){
            resultMap.put("msg","添加成功");
            resultMap.put("permission",permission);
        }else{
            resultMap.put("msg","添加失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> authDel(Integer permissionId) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = authMapper.authDel(permissionId);
        if(ref>0){
            resultMap.put("msg","删除成功");
        }else{
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> authUpdate(Permission permission) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = authMapper.authUpdate(permission);
        if(ref>0){
            resultMap.put("msg","修改成功");
            resultMap.put("permission",permission);
        }else{
            resultMap.put("msg","修改失败");
        }
        return resultMap;
    }
}
