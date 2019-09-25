package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.service.serviceImpl.AlarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 告警信息
 */
@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    AlarmServiceImpl alarmServiceImpl;

    /**
     * 查询全区当前时间的告警总数
     * @return
     */
    @GetMapping("/get/alarms")
    public Map<String, Object> selectAlarmList(){
        Map<String, Object> alarmList = alarmServiceImpl.getAlarmList();
        return alarmList;
    }

    /**
     * 查询指定派出所下的站点告警总和
     * @param PCS_Code
     * @return
     */
    @GetMapping("/get/alarms/{PCS_Code}")
    public Map<String,Object> selectAlarmByPCS(@PathVariable  String PCS_Code){
        Map<String,Object> alarmList = alarmServiceImpl.getAlarmByPCS(PCS_Code);
        return alarmList;
    }
}
