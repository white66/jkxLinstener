package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.systemInfo.SysAuthInfo;
import com.rtstjkx.jkx.repository.systemInfo.AuthMapper;
import com.rtstjkx.jkx.service.systemInfo.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;
    @Override
    public List<String> findAuthByRoleIds(List<Integer> roleIds) {
        List<String> sysAuthInfos = authMapper.findAuthByRoleId(roleIds);
        return sysAuthInfos;
    }
}
