package com.rtstjkx.jkx.service;

import com.github.pagehelper.PageInfo;
import com.rtstjkx.jkx.entity.Dsignal;

import java.util.List;
import java.util.Map;
public interface DataService {
    /**
     * 获取派出所站点的历史数据
     * @return
     */
    PageInfo<Dsignal> getDataHistory(String WS_Code);

    /**
     * 每天23时59分统计每个站点的日能耗值
     * @param DS_DateTime
     */
    void selectEnergyDay(String DS_DateTime);

    /**
     * 每月最后一天统计每个站点的月能耗值
     */
    void selectEnergyMonth();

    /**
     * 每年最后一天统计每个站点的年能耗值
     */
    void selectEnergyYear();
}
