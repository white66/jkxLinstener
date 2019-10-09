package com.rtstjkx.jkx.repository.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.SysUser;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    /**
     * 通过账户查询用户信息
     * @param userAccount
     * @return
     */
    SysUser findUserByAccount(String userAccount);
}
