package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.Alarm;
import com.rtstjkx.jkx.entity.PcsInformation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AlarmMapper {
    /**
     * 查询全区各项报警信息
     * @return   List<Alarm>
     */
    List<Alarm> getAlarmList();

    /**
     * 查询每个派出所下的站点告警总和
     * @param pcs
     * @return
     */
    List<Alarm> getAlarmByPCS(PcsInformation pcs);

    /**
     * 插入数据到c_alarm表中
     * @param params
     */
    void addAlarm(Map<String,Object> params);
}
