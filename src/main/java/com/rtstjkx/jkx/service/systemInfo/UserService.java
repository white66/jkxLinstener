package com.rtstjkx.jkx.service.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.SysUser;

public interface UserService {
    /**
     * 根据账户查询用户信息
     * @param userAccount
     * @return
     */
    SysUser findUserByAccount(String userAccount);
}
