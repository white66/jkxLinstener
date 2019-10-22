package com.rtstjkx.jkxlistener.task;

import com.rtstjkx.jkxlistener.service.serviceImpl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
@Configuration
public class Mytask {
    @Autowired
    DataServiceImpl dataService;
    /**
     * 统计每天的能耗值，并写入数据库
     */
    @Scheduled(cron = "0 59 23 * * *")//每天23点59分0秒时执行
    public void energyDay(){
        System.out.println("启动每日定时任务！！！");
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(nowDate);
        dataService.selectEnergyDay(date);
    }

    /**
     *统计每月的能耗值，并写入数据库
     */
    @Scheduled(cron = "0 59 23 28-31 * ?")//每月最后一天执行
    public void energyMonth(){
        System.out.println("启动每月定时任务");
        final Calendar c = Calendar.getInstance();
        if (c.get(Calendar.DATE) == c.getActualMaximum(Calendar.DATE)) {
            //是最后一天
            System.out.println("启动每月定时任务");
            dataService.selectEnergyMonth();
        }else{
            System.out.println("今天不是本月最后一天");
        }
    }
    /**
     *
     */
    @Scheduled(cron = "0 59 23 31 12 ?")//每年最后一天执行
    public void energyYear(){
        System.out.println("启动每年定时任务");
        dataService.selectEnergyYear();
    }
}
