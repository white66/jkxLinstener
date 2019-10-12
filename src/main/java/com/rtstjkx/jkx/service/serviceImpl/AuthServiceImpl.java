package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.repository.systemInfo.AuthMapper;
import com.rtstjkx.jkx.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;
    @Override
    public Set<String> findAuthByRoleIds(List<Integer> roleIds) {
        Set<String> sysAuthInfos = authMapper.findAuthByRoleId(roleIds);
        return sysAuthInfos;
    }
}
