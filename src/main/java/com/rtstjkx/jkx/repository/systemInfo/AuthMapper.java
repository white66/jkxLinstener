package com.rtstjkx.jkx.repository.systemInfo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface AuthMapper {
    /**
     * 通过角色Id查询角色的权限信息
     * @return
     */
    Set<String> findAuthByRoleId(List<Integer> roleIds);
}
