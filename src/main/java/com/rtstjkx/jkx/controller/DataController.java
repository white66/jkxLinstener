package com.rtstjkx.jkx.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.Dsignal;
import com.rtstjkx.jkx.service.serviceImpl.DataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    DataServiceImpl dataService;
    @Autowired
    ResponseCode responseCode;
    /**
     * 查询派出所下某一个站点的历史数据
     * @param WS_Code
     * @return
     */
    @GetMapping("/get/{WS_Code}/{pageNo}/{pageNum}")
    public ResponseCode selectDataHistoryByCode(@PathVariable String WS_Code ,@PathVariable int pageSize,@PathVariable int pageNum){
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Dsignal> dataHistory = dataService.getDataHistory(WS_Code);
        return responseCode.success("查询成功",dataHistory);
    }
}
