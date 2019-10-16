package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.bean.CacheUser;
import com.rtstjkx.jkx.entity.systemInfo.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据账户查询用户信息
     * @param userAccount
     * @return
     */
    User findUserByAccount(String userAccount);

    /**
     * 登录时验证用户名和密码
     * @param userName
     * @param passWord
     * @return
     */
    CacheUser login(String userName, String passWord);

    /**
     * description: 登出
     * create time: 2019/6/28 16:30
     */
    void logout();

    /**
     * 查询用户列表信息
     * @return
     */
    List<User> listUsers();

    /**
     * 添加用户
     * @param user
     * @return
     */
    Map<String,Object> addUser(User user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Map<String,Object> delUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    Map<String,Object> updateUser(User user);
}
