package com.rtstjkx.jkx.repository;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface SignalMapper {
    /**
     * 添加信号数据到C_dsignal表中
     * @param params
     */
    void addDsignal(Map<String,Object> params);
}
