package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.Alarm;
import org.springframework.stereotype.Component;

import java.util.Date;
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
     * @param PCS_Code
     * @return
     */
    List<Alarm> getAlarmByPCS(String PCS_Code);
}
