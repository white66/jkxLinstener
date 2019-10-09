package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.SysUser;
import com.rtstjkx.jkx.repository.systemInfo.UserMapper;
import com.rtstjkx.jkx.service.systemInfo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 根据账户查询用户信息
     * @param userAccount
     * @return
     */
    @Override
    public SysUser findUserByAccount(String userAccount) {
        SysUser user = userMapper.findUserByAccount(userAccount);
        return user;
    }
}
