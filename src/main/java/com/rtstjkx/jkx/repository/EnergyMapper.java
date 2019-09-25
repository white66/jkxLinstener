package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.EnergyDay;
import com.rtstjkx.jkx.entity.EnergyMonth;
import com.rtstjkx.jkx.entity.EnergyYear;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface EnergyMapper {
    /**
     * 根据站点和日期查询日能耗详情
     * @param params
     * @return
     */
    List<EnergyDay> getEnergyDayByWS(Map<String,Object> params);
    /**
     * 根据站点和日期查询月能耗详情
     * @param params
     * @return
     */
    List<EnergyMonth> getEnergyMonthByWS(Map<String,Object> params);
    /**
     * 根据站点和日期查询年能耗详情
     * @param params
     * @return
     */
    List<EnergyYear> getEnergyYearByWS(Map<String,Object> params);
    /**
     * 根据派出所和日期查询派出所日能耗详情
     * @param params
     * @return
     */
    List<EnergyDay> getEnergyDayByPCS(Map<String,Object> params);
    /**
     * 根据派出所和日期查询派出所月能耗详情
     * @param params
     * @return
     */
    List<EnergyMonth> getEnergyMonthByPCS(Map<String,Object> params);
    /**
     * 根据派出所和日期查询派出所年能耗详情
     * @param params
     * @return
     */
    List<EnergyYear> getEnergyYearByPCS(Map<String,Object> params);

    /**
     * 根据时间日期查询全区的日能耗值总和
     * @param params
     * @return
     */
    List<EnergyDay> getEnergyDay(Map<String,Object> params);
    /**
     * 根据时间日期查询全区的月能耗值总和
     * @param params
     * @return
     */
    List<EnergyMonth> getEnergyMonth(Map<String,Object> params);
    /**
     * 根据时间日期查询全区的年能耗值总和
     * @param params
     * @return
     */
    List<EnergyYear> getEnergyYear(Map<String,Object> params);
}
