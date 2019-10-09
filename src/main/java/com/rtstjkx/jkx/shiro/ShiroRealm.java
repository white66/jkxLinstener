package com.rtstjkx.jkx.shiro;

import com.rtstjkx.jkx.entity.systemInfo.SysRole;
import com.rtstjkx.jkx.entity.systemInfo.SysUser;
import com.rtstjkx.jkx.service.serviceImpl.AuthServiceImpl;
import com.rtstjkx.jkx.service.serviceImpl.RoleServiceImpl;
import com.rtstjkx.jkx.service.serviceImpl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    private static Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    @Autowired
    UserServiceImpl userService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    AuthServiceImpl authService;
    /**
     * 权限配置，注入权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        //根据用户Id查询角色信息
        List<SysRole> roleList = roleService.findRoleByUserId(user.getId());
        List<Integer> roleIds = new ArrayList<>();
        Set<String> roleSet = new HashSet<>();
        for (SysRole role: roleList) {
            roleIds.add(role.getId());
            roleSet.add(role.getSysRoleName());
        }
        // 放入角色信息
        simpleAuthorizationInfo.setRoles(roleSet);
        //放入权限信息
        List<String> sysAuthInfos = authService.findAuthByRoleIds(roleIds);
        simpleAuthorizationInfo.setStringPermissions(new HashSet<>(sysAuthInfos));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询用户信息
        SysUser user = userService.findUserByAccount(userToken.getUsername());
        if(user == null){
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getUserPassword(), getName());
    }
}
