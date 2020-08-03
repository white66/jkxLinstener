package com.rtstjkx.jkxlistener.repository;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/7/7 12:55
 * @Version 1.0
 */
@Component
public interface OrderMapper {
    void insertOrder(Map<String,Object> param);
}
