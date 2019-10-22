package com.rtstjkx.jkxlistener.service;

public interface DataService {

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
