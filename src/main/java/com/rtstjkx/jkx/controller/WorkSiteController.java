package com.rtstjkx.jkx.controller;

import com.github.pagehelper.PageHelper;
import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.WorkSite;
import com.rtstjkx.jkx.service.serviceImpl.WorkSiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 监控点管理控制器
 */
@RestController
@RequestMapping("/workSite")
public class WorkSiteController {
    @Autowired
    WorkSiteServiceImpl workSiteService;
    @Autowired
    ResponseCode responseCode;

    /**
     * 查询监控点列表
     * @return
     */
    @PostMapping("/workSiteList")
    public ResponseCode workSiteList(@RequestBody WorkSite workSite){
        PageHelper.startPage(workSite.getPageNum(),workSite.getPageSize());
        List<WorkSite> workSites = workSiteService.workSiteList();
        return responseCode.success(workSites);
    }

    /**
     * 根据条件查询监控点
     * @param workSite
     * @return
     */
    @PostMapping("/workSiteOne")
    public ResponseCode workSiteOne(@RequestBody WorkSite workSite){
        List<WorkSite> workSites = workSiteService.workSiteOne(workSite);
        return responseCode.success(workSites);
    }

    /**
     * 添加监控点
     * @param workSite
     * @return
     */
    @PostMapping("/workSiteAdd")
    public ResponseCode workSiteAdd(@RequestBody WorkSite workSite){
        Map<String, Object> resultMap = workSiteService.workSiteAdd(workSite);
        return responseCode.success(resultMap);
    }
    /**
     * 删除监控点
     * @param workSite
     * @return
     */
    @DeleteMapping("/workSiteDel")
    public ResponseCode workSiteDel(@RequestBody WorkSite workSite){
        Map<String, Object> resultMap = workSiteService.workSiteDel(workSite);
        return responseCode.success(resultMap);
    }

    /**
     * 修改监控点
     * @param workSite
     * @return
     */
    @PostMapping("/workSiteUpdate")
    public ResponseCode workSiteUpdate(@RequestBody WorkSite workSite){
        Map<String, Object> resultMap = workSiteService.workSiteUpdate(workSite);
        return responseCode.success(resultMap);
    }
}
