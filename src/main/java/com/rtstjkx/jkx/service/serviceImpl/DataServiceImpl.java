package com.rtstjkx.jkx.service.serviceImpl;

import com.github.pagehelper.PageInfo;
import com.rtstjkx.jkx.entity.Dsignal;
import com.rtstjkx.jkx.repository.DataMapper;
import com.rtstjkx.jkx.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DataServiceImpl implements DataService{
    @Autowired
    DataMapper dataMapper;

    /**
     * 定时任务查询电表每天的23点59分时交流电能和00点00分时交流电能之差作为每日能耗值，并存入到energyDay表中
     * @param DS_DateTime
     */
    @Override
    public void selectEnergyDay(String DS_DateTime){
        String DS_DateTimeEnd = DS_DateTime+" 23:59:00";
        String DS_DateTimeStart = DS_DateTime+" 00:00:00";
        List<Dsignal> dsignalsEnd = dataMapper.selectEnergy(DS_DateTimeEnd);
        List<Dsignal> dsignalsStart = dataMapper.selectEnergy(DS_DateTimeStart);
        int refNum = 0;
        for (int i=0;i< dsignalsEnd.size();i++){
            Map<String ,Object> param = new LinkedHashMap<>();
            for(int j=0 ; j<dsignalsStart.size();j++){
                if (dsignalsEnd.get(i).getWsCode().equals(dsignalsStart.get(j).getWsCode())){
                    Double energy = dsignalsEnd.get(i).getDsJldn() - dsignalsStart.get(j).getDsJldn();
                    param.put("WS_Code",dsignalsEnd.get(i).getWsCode());
                    param.put("energyDay",energy);
                    param.put("dateTime",DS_DateTime);
                    refNum = dataMapper.insertEnergyDay(param);
                    if(refNum>0){
                        System.out.println("每日能耗数据插入成功！！！");
                    }
                }
            }
        }
    }

    /**
     * 每月最后一天统计每个站点的月能耗值
     */
    @Override
    public void selectEnergyMonth() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat sdfEnd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String endDate = sdfEnd.format(nowDate);
        String dateTemple = sdf.format(nowDate);
        String startDate = dateTemple+"-01 00:00:00";
        List<Dsignal> dsignalListEnd = dataMapper.selectEnergy(endDate);
        List<Dsignal> dsignalListStart = dataMapper.selectEnergy(startDate);
        int refNum = 0;
        for (int i=0;i< dsignalListEnd.size();i++){
            Map<String ,Object> param = new LinkedHashMap<>();
            for(int j=0 ; j<dsignalListStart.size();j++){
                if (dsignalListEnd.get(i).getWsCode().equals(dsignalListStart.get(j).getWsCode())){
                    Double energy = dsignalListEnd.get(i).getDsJldn() - dsignalListStart.get(j).getDsJldn();
                    param.put("WS_Code",dsignalListEnd.get(i).getWsCode());
                    param.put("energyMonth",energy);
                    param.put("dateTime",nowDate);
                    refNum = dataMapper.insertEnergyMonth(param);
                    if(refNum>0){
                        System.out.println("每月能耗数据插入成功！！！");
                    }
                }
            }
        }
    }
    /**
     * 每年最后一天统计每个站点的年能耗值
     */
    @Override
    public void selectEnergyYear() {
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String dateTemple = sdf.format(nowDate);
        String endDate = dateTemple+"-12-31 23:59:00";
        String startDate = dateTemple+"-01-01 00:00:00";
        List<Dsignal> dsignalsEnd = dataMapper.selectEnergy(endDate);
        List<Dsignal> dsignalsStart = dataMapper.selectEnergy(startDate);
        int refNum = 0;
        for (int i=0;i< dsignalsEnd.size();i++){
            Map<String ,Object> param = new LinkedHashMap<>();
            for(int j=0 ; j<dsignalsStart.size();j++){
                if (dsignalsEnd.get(i).getWsCode().equals(dsignalsStart.get(j).getWsCode())){
                    Double energy = dsignalsEnd.get(i).getDsJldn() - dsignalsStart.get(j).getDsJldn();
                    param.put("WS_Code",dsignalsEnd.get(i).getWsCode());
                    param.put("energyYear",energy);
                    param.put("dateTime",nowDate);
                    refNum = dataMapper.insertEnergyYear(param);
                    if(refNum>0){
                        System.out.println("每年能耗数据插入成功！！！");
                    }
                }
            }
        }
    }
}