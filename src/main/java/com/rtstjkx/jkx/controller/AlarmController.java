package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.PcsInformation;
import com.rtstjkx.jkx.service.serviceImpl.AlarmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 告警信息
 */
@RestController
@RequestMapping("/alarm")
public class AlarmController {
    @Autowired
    AlarmServiceImpl alarmServiceImpl;
    @Autowired
    ResponseCode responseCode;

    /**
     * 查询全区当前时间的告警总数
     * @return
     */
    @GetMapping("/alarmList")
    public ResponseCode selectAlarmList(){
        Map<String, Object> alarmList = alarmServiceImpl.getAlarmList();
        return responseCode.success(alarmList);
    }

    /**
     * 查询指定派出所下的站点告警总和
     * @param pcs
     * @return
     */
    @PostMapping("/alarmByPcs")
    public ResponseCode selectAlarmByPcs(@RequestBody PcsInformation pcs){
        Map<String,Object> alarmList = alarmServiceImpl.getAlarmByPCS(pcs);
        return responseCode.success(alarmList);
    }
}
