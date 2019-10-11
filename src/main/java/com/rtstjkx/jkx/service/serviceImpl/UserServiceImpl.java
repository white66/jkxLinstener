package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.bean.CacheUser;
import com.rtstjkx.jkx.exception.LoginException;
import com.rtstjkx.jkx.entity.systemInfo.User;
import com.rtstjkx.jkx.repository.systemInfo.UserMapper;
import com.rtstjkx.jkx.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    /**
     * 根据账户查询用户信息
     * @param userAccount
     * @return
     */
    @Override
    public User findUserByAccount(String userAccount) {
        User user = userMapper.findUserByAccount(userAccount);
        return user;
    }

    /**
     * 登录时验证用户名和密码是否存在
     * @param userName
     * @param passWord
     * @return
     */
    @Override
    public CacheUser login(String userName, String passWord) {
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();

        // 将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);

        CacheUser cacheUser;
        // 4、认证
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            User user = (User) currentUser.getPrincipals().getPrimaryPrincipal();
            cacheUser = CacheUser.builder()
                    .token(currentUser.getSession().getId().toString())
                    .build();
            BeanUtils.copyProperties(user, cacheUser);
            log.warn("CacheUser is {}", cacheUser.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new LoginException("账号不存在!", e);
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new LoginException("密码不正确!", e);
        } catch (AuthenticationException e) {
            log.error("身份验证异常:", e);
            throw new LoginException("用户验证失败!", e);
        }
        return cacheUser;
    }

    /**
     * 登出
     */
    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }

    /**
     * 查询用户列表
     * @return
     */
    @Override
    public List<User> listUsers() {
       List<User> users = userMapper.findUserList();
        return users;
    }
}
