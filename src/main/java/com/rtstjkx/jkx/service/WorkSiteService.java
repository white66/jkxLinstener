package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.entity.WorkSite;

import java.util.List;
import java.util.Map;

public interface WorkSiteService {

    List<WorkSite> workSiteList();

    List<WorkSite> workSiteOne(WorkSite workSite);

    Map<String, Object> workSiteAdd(WorkSite workSite);

    Map<String, Object> workSiteDel(WorkSite wsCode);

    Map<String, Object> workSiteUpdate(WorkSite workSite);
}
