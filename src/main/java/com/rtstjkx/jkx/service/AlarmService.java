package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.entity.PcsInformation;

import java.util.Map;

public interface AlarmService {
    /*
     * 查询全区总告警数
     * @return Map<String,Object>
     */
    Map<String,Object> getAlarmList();

    /**
     *查询指定派出所下的站点告警总和
     * @param pcs
     * @param pcs
     * @return
     */
    Map<String,Object> getAlarmByPCS(PcsInformation pcs);
}
