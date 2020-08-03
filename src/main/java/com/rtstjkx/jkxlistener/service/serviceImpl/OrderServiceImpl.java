package com.rtstjkx.jkxlistener.service.serviceImpl;

import com.rtstjkx.jkxlistener.repository.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/7/7 13:04
 * @Version 1.0
 */
@Service
public class OrderServiceImpl {
    @Autowired
    OrderMapper orderMapper;
    public void inserOrder(Map<String, Object> param) {
        orderMapper.insertOrder(param);
    }
}
