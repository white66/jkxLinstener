package com.rtstjkx.jkx.service.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.SysAuthInfo;

import java.util.List;

public interface AuthService {
    List<String> findAuthByRoleIds(List<Integer> roleIds);
}
