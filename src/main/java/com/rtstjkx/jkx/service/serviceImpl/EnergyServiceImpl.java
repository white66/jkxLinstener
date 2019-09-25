package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.EnergyDay;
import com.rtstjkx.jkx.entity.EnergyMonth;
import com.rtstjkx.jkx.entity.EnergyYear;
import com.rtstjkx.jkx.repository.EnergyMapper;
import com.rtstjkx.jkx.service.EnergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnergyServiceImpl implements EnergyService{
    @Autowired
    EnergyMapper energyMapper;

    /**
     * 根据站点和日期查询日能耗详情
     * @param params
     * @return
     */
    @Override
    public List<EnergyDay> getEnergyDayByWS(Map<String, Object> params) {
        List<EnergyDay> energyDays = energyMapper.getEnergyDayByWS(params);
        return energyDays;
    }
    /**
     * 根据站点和日期查询月能耗详情
     * @param params
     * @return
     */
    @Override
    public List<EnergyMonth> getEnergyMonthByWS(Map<String, Object> params) {
        List<EnergyMonth> energyMonths = energyMapper.getEnergyMonthByWS(params);
        return energyMonths;
    }

    /**
     * 根据站点和日期查询年能耗详情
     * @param params
     * @return
     */
    @Override
    public List<EnergyYear> getEnergyYearByWS(Map<String, Object> params) {
        List<EnergyYear> energyYears = energyMapper.getEnergyYearByWS(params);
        return energyYears;
    }

    /**
     * 根据派出所和日期查询派出所的日能耗值
     * @param params
     * @return
     */
    @Override
    public List<EnergyDay> getEnergyDayByPCS(Map<String, Object> params) {
        List<EnergyDay> energyDays = energyMapper.getEnergyDayByPCS(params);
        return energyDays;
    }
    /**
     * 根据派出所和日期查询派出所的月能耗值
     * @param params
     * @return
     */
    @Override
    public List<EnergyMonth> getEnergyMonthByPCS(Map<String, Object> params) {
        List<EnergyMonth> energyMonths = energyMapper.getEnergyMonthByPCS(params);
        return energyMonths;
    }
    /**
     * 根据派出所和日期查询派出所的年能耗值
     * @param params
     * @return
     */
    @Override
    public List<EnergyYear> getEnergyYearByPCS(Map<String, Object> params) {
        List<EnergyYear> energyYears = energyMapper.getEnergyYearByPCS(params);
        return energyYears;
    }

    /**
     * 根据时间日期查询全区的日能耗值总和
     * @param params
     * @return
     */
    @Override
    public List<EnergyDay> getEnergyDay(Map<String, Object> params) {
        List<EnergyDay> energyDays = energyMapper.getEnergyDay(params);
        return energyDays;
    }
    /**
     * 根据时间日期查询全区的月能耗值总和
     * @param params
     * @return
     */
    @Override
    public List<EnergyMonth> getEnergyMonth(Map<String, Object> params) {
        List<EnergyMonth> energyMonths = energyMapper.getEnergyMonth(params);
        return energyMonths;
    }
    /**
     * 根据时间日期查询全区的年能耗值总和
     * @param params
     * @return
     */
    @Override
    public List<EnergyYear> getEnergyYear(Map<String, Object> params) {
        List<EnergyYear> energyYears = energyMapper.getEnergyYear(params);
        return energyYears;
    }
}
