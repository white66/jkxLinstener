package com.rtstjkx.jkx.repository.systemInfo;

import com.rtstjkx.jkx.entity.systemInfo.SysAuthInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AuthMapper {
    /**
     * 通过角色Id查询角色的权限信息
     * @return
     */
    List<String> findAuthByRoleId( List<Integer> roleIds);
}
