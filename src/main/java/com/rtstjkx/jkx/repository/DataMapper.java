package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.Dsignal;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public interface DataMapper {
    /**
     * 统计报表时查询各站点的能耗值
     * @param DS_DateTime
     * @return
     */
    List<Dsignal> selectEnergy(String DS_DateTime);
    /**
     * 插入每日统计的能耗值到energyDay表中
     * @param param
     * @return
     */
    int insertEnergyDay(Map<String,Object> param);
    /**
     * 插入每月统计的能耗值到energyMonth表中
     * @param param
     * @return
     */
    int insertEnergyMonth(Map<String,Object> param);

    /**
     * 插入每年统计的能耗值到energyYear表中
     * @param param
     * @return
     */
    int insertEnergyYear(Map<String,Object> param);
}
