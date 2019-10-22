package com.rtstjkx.jkxlistener.repository;


import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface AlarmMapper {
    /**
     * 插入数据到c_alarm表中
     * @param params
     */
    void addAlarm(Map<String, Object> params);
}
