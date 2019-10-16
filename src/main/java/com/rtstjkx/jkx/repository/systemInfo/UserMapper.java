package com.rtstjkx.jkx.repository.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    /**
     * 通过账户查询用户信息
     * @param userAccount
     * @return
     */
    User findUserByAccount(String userAccount);

    /**
     * 查詢用戶列表
     * @return
     */
    List<User> findUserList();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param user
     * @return
     */
    int delUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUser(User user);
}
