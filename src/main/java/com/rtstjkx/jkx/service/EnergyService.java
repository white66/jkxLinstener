package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.entity.EnergyDay;
import com.rtstjkx.jkx.entity.EnergyMonth;
import com.rtstjkx.jkx.entity.EnergyYear;

import java.util.List;
import java.util.Map;

public interface EnergyService {

    List<EnergyDay> getEnergyDayByWS(Map<String,Object> params);

    List<EnergyMonth> getEnergyMonthByWS(Map<String,Object> params);

    List<EnergyYear> getEnergyYearByWS(Map<String,Object> params);

    List<EnergyDay> getEnergyDayByPCS(Map<String,Object> params);

    List<EnergyMonth> getEnergyMonthByPCS(Map<String,Object> params);

    List<EnergyYear> getEnergyYearByPCS(Map<String,Object> params);

    List<EnergyDay> getEnergyDay(Map<String,Object> params);

    List<EnergyMonth> getEnergyMonth(Map<String,Object> params);

    List<EnergyYear> getEnergyYear(Map<String, Object> params);
}
