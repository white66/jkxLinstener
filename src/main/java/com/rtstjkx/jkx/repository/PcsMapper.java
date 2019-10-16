package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.PcsInformation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PcsMapper {
    List<PcsInformation> pcsList();

    int pcsAdd(PcsInformation pcsInformation);

    int pcsDel(Integer id);

    int pcsUpdate(PcsInformation pcsInformation);
}
