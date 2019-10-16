package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.WorkSite;
import com.rtstjkx.jkx.repository.WorkSiteMapper;
import com.rtstjkx.jkx.service.WorkSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class WorkSiteServiceImpl implements WorkSiteService {
    @Autowired
    WorkSiteMapper workSiteMapper;

    /**
     * 查询监控点列表
     * @return
     */
    @Override
    public List<WorkSite> workSiteList() {
        List<WorkSite> workSites = workSiteMapper.workSiteList();
        return workSites;
    }

    /**
     * 根据条件查询监控点详情
     * @param workSite
     * @return
     */
    @Override
    public List<WorkSite> workSiteOne(WorkSite workSite) {
        List<WorkSite> workSites = workSiteMapper.workSiteOne(workSite);
        return workSites;
    }

    /**
     * 添加监控点
     * @param workSite
     * @return
     */
    @Override
    public Map<String, Object> workSiteAdd(WorkSite workSite) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = workSiteMapper.workSiteAdd(workSite);
        if(ref>0){
            resultMap.put("msg","添加成功");
            resultMap.put("workSite",workSite);
        }else{
            resultMap.put("msg","添加失败");
        }
        return resultMap;
    }

    /**
     * 删除监控点
     * @param wsCode
     * @return
     */
    @Override
    public Map<String, Object> workSiteDel(WorkSite wsCode) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = workSiteMapper.workSiteDel(wsCode);
        if(ref>0){
            resultMap.put("msg","添加成功");
        }else{
            resultMap.put("msg","添加失败");
        }
        return resultMap;
    }

    /**
     * 修改监控点信息
     * @param workSite
     * @return
     */
    @Override
    public Map<String, Object> workSiteUpdate(WorkSite workSite) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = workSiteMapper.workSiteUpdate(workSite);
        if(ref>0){
            resultMap.put("msg","修改成功");
            resultMap.put("workSite",workSite);
        }else{
            resultMap.put("msg","修改失败");
        }
        return resultMap;
    }
}
