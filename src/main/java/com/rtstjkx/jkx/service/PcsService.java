package com.rtstjkx.jkx.service;

import com.rtstjkx.jkx.entity.PcsInformation;

import java.util.List;
import java.util.Map;

public interface PcsService {

    List<PcsInformation> pcsList();

    Map<String,Object> pcsAdd(PcsInformation pcsInformation);

    Map<String,Object> pcsDel(Integer id);

    Map<String,Object> pcsUpdate(PcsInformation pcsInformation);
}
