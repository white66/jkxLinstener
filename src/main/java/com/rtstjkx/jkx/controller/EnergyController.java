package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.EnergyDay;
import com.rtstjkx.jkx.entity.EnergyMonth;
import com.rtstjkx.jkx.entity.EnergyYear;
import com.rtstjkx.jkx.service.serviceImpl.EnergyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/energy")
public class EnergyController {
    @Autowired
    EnergyServiceImpl energyService;
    @Autowired
    ResponseCode responseCode;
    /**
     * 根据站点和时间查询日能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energydayws/{WS_Code}/{dateTime}")
    public ResponseCode energyDayByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String,Object> params= new LinkedHashMap<>();
        params.put("WS_Code",WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDayByWS(params);
        return responseCode.success(resultList);
    }
    /**
     * 根据站点和时间查询月能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energymonthws/{WS_Code}/{dateTime}")
    public ResponseCode energyMonthByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("WS_Code",WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonthByWS(params);
        return responseCode.success(resultList);
    }

    /**
     * 根据站点和时间查询年能耗值
     * @param WS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energyyearws/{WS_Code}/{dateTime}")
    public ResponseCode energyYearByWS(@PathVariable String WS_Code,@PathVariable String dateTime){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("WS_Code" ,WS_Code);
        params.put("dateTime",dateTime);
        List<EnergyYear> resultList  =energyService.getEnergyYearByWS(params);
        return responseCode.success(resultList);
    }

    /**
     * 根据派出所和时间查询派出所下所有站点日能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energydaypcs/{PCS_Code}/{dateTime}")
    public ResponseCode energyDayByPCS(@PathVariable String PCS_Code,@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDayByPCS(params);
        return responseCode.success(resultList);
    }
    /**
     * 根据派出所和时间查询派出所下所有站点月能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energymonthpcs/{PCS_Code}/{dateTime}")
    public ResponseCode energyMonthByPCS(@PathVariable String PCS_Code, @PathVariable String dateTime){
        Map<String, Object> params = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonthByPCS(params);
        return responseCode.success(resultList);
    }
    /**
     * 根据派出所和时间查询派出所下所有站点年能耗值总和
     * @param PCS_Code
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energyyearpcs/{PCS_Code}/{dateTime}")
    public ResponseCode energyYearByPCS(@PathVariable String PCS_Code, @PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("PCS_Code",PCS_Code);
        params.put("dateTime",dateTime);
        List<EnergyYear> resultList = energyService.getEnergyYearByPCS(params);
        return  responseCode.success(resultList);
    }

    /**
     * 根据时间日期查询全区的日能耗值总和
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energyday/{dateTime}")
    public ResponseCode energyDay(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyDay> resultList = energyService.getEnergyDay(params);
        return  responseCode.success(resultList);
    }
    /**
     * 根据时间日期查询全区的月能耗值总和
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energymonth/{dateTime}")
    public ResponseCode energyMonth(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyMonth> resultList = energyService.getEnergyMonth(params);
        return  responseCode.success(resultList);
    }
    /**
     * 根据时间日期查询全区的年能耗值总和
     * @param dateTime
     * @return
     */
    @GetMapping("/get/energyyear/{dateTime}")
    public ResponseCode energyYear(@PathVariable String dateTime){
        Map<String,Object> params = new LinkedHashMap<>();
        params.put("dateTime", dateTime);
        List<EnergyYear> resultList = energyService.getEnergyYear(params);
        return  responseCode.success(resultList);
    }
}
