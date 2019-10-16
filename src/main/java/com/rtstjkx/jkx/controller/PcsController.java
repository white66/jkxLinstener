package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.PcsInformation;
import com.rtstjkx.jkx.service.serviceImpl.PcsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 派出所控制器
 */
@RestController
@RequestMapping("/pcs")
public class PcsController {
    @Autowired
    PcsServiceImpl pcsService;
    @Autowired
    ResponseCode responseCode;

    /**
     * 查询所有派出所信息
     * @return
     */
    @GetMapping("/pcsList")
    public ResponseCode pcsList(){
        List<PcsInformation> pcsInformations = pcsService.pcsList();
        return responseCode.success(pcsInformations);
    }

    /**
     * 添加派出所
     * @param pcsInformation
     * @return
     */
    @PostMapping("/pcsAdd")
    public ResponseCode pcsAdd(@RequestBody  PcsInformation pcsInformation){
        Map<String,Object> resultMap = pcsService.pcsAdd(pcsInformation);
        return responseCode.success(resultMap);
    }

    /**
     * 删除派出所
     * @param id
     * @return
     */
    @DeleteMapping("/pcsDel")
    public ResponseCode pcsDel(@RequestBody Integer id ){
        Map<String,Object> resultMap = pcsService.pcsDel(id);
        return responseCode.success(resultMap);
    }

    /**
     * 修改派出所信息
     * @param pcsInformation
     * @return
     */
    @PostMapping("/pcsUpdate")
    public ResponseCode pcsUpdate(@RequestBody PcsInformation pcsInformation){
        Map<String,Object> resultMap = pcsService.pcsUpdate(pcsInformation);
        return  responseCode.success(resultMap);
    }
}
