package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.entity.EnergyDay;
import com.rtstjkx.jkx.entity.EnergyMonth;
import com.rtstjkx.jkx.entity.EnergyYear;
import com.rtstjkx.jkx.service.serviceImpl.EnergyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/energy")
public class EnergyController {
    @Autowired
    EnergyServiceImpl energyService;
    /**
     * 根据站点和时间查询日能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energydayws/{WS_Code}/{dateTime}")
    public Map<String,Object> energyDayByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String,Object> params= new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("WS_Code",WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDayByWS(params);
        resultMap.put("rows",resultList);
        return resultMap;
    }
    /**
     * 根据站点和时间查询月能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energymonthws/{WS_Code}/{dateTime}")
    public Map<String,Object> energyMonthByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        params.put("WS_Code",WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonthByWS(params);
        resultMap.put("rows",resultList);
        return resultMap;
    }

    /**
     * 根据站点和时间查询年能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energyyearws/{WS_Code}/{dateTime}")
    public Map<String,Object> energyYearByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String, Object> params = new LinkedHashMap<>();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        params.put("WS_Code" ,WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyYear> resultList  =energyService.getEnergyYearByWS(params);
        resultMap.put("rows",resultList);
        return resultMap;
    }

    /**
     * 根据派出所和时间查询派出所下所有站点日能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energydaypcs/{PCS_Code}/{dateTime}")
    public Map<String,Object> energyDayByPCS(@PathVariable String PCS_Code,@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDayByPCS(params);
        resultMap.put("rows", resultList);
        return resultMap;
    }
    /**
     * 根据派出所和时间查询派出所下所有站点月能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energymonthpcs/{PCS_Code}/{dateTime}")
    public Map<String,Object> energyMonthByPCS(@PathVariable String PCS_Code, @PathVariable String dateTime){
        Map<String, Object> params = new LinkedHashMap<>();
        Map<String, Object> resultMap = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonthByPCS(params);
        resultMap.put("rows",resultList);
        return resultMap;
    }
    /**
     * 根据派出所和时间查询派出所下所有站点年能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energyyearpcs/{PCS_Code}/{dateTime}")
    public Map<String,Object> energyYearByPCS(@PathVariable String PCS_Code, @PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyYear> resultList = energyService.getEnergyYearByPCS(params);
        resultMap.put("rows",resultList);
        return  resultMap;
    }

    /**
     * 根据时间日期查询全区的日能耗值总和
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energyday/{dateTime}")
    public Map<String,Object> energyDay(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDay(params);
        resultMap.put("rows",resultList);
        return  resultMap;
    }
    /**
     * 根据时间日期查询全区的月能耗值总和
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energymonth/{dateTime}")
    public Map<String,Object> energyMonth(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonth(params);
        resultMap.put("rows",resultList);
        return  resultMap;
    }
    /**
     * 根据时间日期查询全区的年能耗值总和
     * @param dateTime
     * @return
     */
    @RequestMapping("/get/energyyear/{dateTime}")
    public Map<String,Object> energyYear(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        Map<String,Object> resultMap = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyYear> resultList = energyService.getEnergyYear(params);
        resultMap.put("rows",resultList);
        return  resultMap;
    }
}
