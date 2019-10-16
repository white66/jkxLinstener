package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.WorkSite;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface WorkSiteMapper {
    /**
     * 查询监控点列表
     * @return
     */
    List<WorkSite> workSiteList();

    /**
     * 根据多条件查询监控点信息
     * @param workSite
     * @return
     */
    List<WorkSite> workSiteOne(WorkSite workSite);

    /**
     * 添加监控点
     * @param workSite
     * @return
     */
    int workSiteAdd(WorkSite workSite);

    /**
     * 删除监控点
     * @param wsCode
     * @return
     */
    int workSiteDel(WorkSite wsCode);

    /**
     * 修改监控点
     * @param workSite
     * @return
     */
    int workSiteUpdate(WorkSite workSite);
}
