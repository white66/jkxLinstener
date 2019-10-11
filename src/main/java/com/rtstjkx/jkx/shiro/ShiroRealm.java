package com.rtstjkx.jkx.shiro;

import com.rtstjkx.jkx.entity.systemInfo.Role;
import com.rtstjkx.jkx.entity.systemInfo.User;
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

/**
 * 自定义 shiroRealm, 主要是重写其认证、授权
 */
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
     * @return 权限信息，包括角色以及权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        //根据用户Id查询角色信息,一个用户可能拥有多个角色
        List<Role> roleList = roleService.findRoleByUserId(user.getUserId());
        List<Integer> roleIds = new ArrayList<>();
        Set<String> roleSet = new HashSet<>();
        for (Role role: roleList) {
            roleIds.add(role.getRoleId());
            roleSet.add(role.getRole());
        }
        // 放入角色信息
        simpleAuthorizationInfo.setRoles(roleSet);
        //放入权限信息
        Set<String> sysAuthInfos = authService.findAuthByRoleIds(roleIds);
        simpleAuthorizationInfo.setStringPermissions(sysAuthInfos);
        return simpleAuthorizationInfo;
    }

    /**
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     * @param authenticationToken
     * @return 身份验证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        //根据用户名查询用户对象
        User user = userService.findUserByAccount(userToken.getUsername());
        //账号不存在
        if(null == user) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        //账号锁定
        if(user.getState() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        return new SimpleAuthenticationInfo(user, user.getPassWord(), getName());
    }
}
