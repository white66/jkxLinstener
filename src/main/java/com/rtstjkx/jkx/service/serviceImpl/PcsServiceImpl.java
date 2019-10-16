package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.PcsInformation;
import com.rtstjkx.jkx.repository.PcsMapper;
import com.rtstjkx.jkx.service.PcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PcsServiceImpl implements PcsService {
    @Autowired
    PcsMapper pcsMapper;

    public List<PcsInformation> pcsList() {
        List<PcsInformation> pcsInformations = pcsMapper.pcsList();
        return pcsInformations;
    }

    @Override
    public Map<String, Object> pcsAdd(PcsInformation pcsInformation) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = pcsMapper.pcsAdd(pcsInformation);
        if(ref>0){
            resultMap.put("msg","添加成功");
            resultMap.put("pcsInformation",pcsInformation);
        }else{
            resultMap.put("msg","添加失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> pcsDel(Integer id) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = pcsMapper.pcsDel(id);
        if(ref>0){
            resultMap.put("msg","删除成功");
        }else{
            resultMap.put("msg","删除失败");
        }
        return resultMap;
    }

    @Override
    public Map<String, Object> pcsUpdate(PcsInformation pcsInformation) {
        Map<String,Object> resultMap = new LinkedHashMap<>();
        int ref = pcsMapper.pcsUpdate(pcsInformation);
        if(ref>0){
            resultMap.put("msg","修改成功");
            resultMap.put("pcsInformation",pcsInformation);
        }else{
            resultMap.put("msg","修改失败");
        }
        return resultMap;
    }
}
