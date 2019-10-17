package com.rtstjkx.jkx.repository;

import com.rtstjkx.jkx.entity.Dsignal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SignalMapper {
    /**
     * 添加信号数据到C_dsignal表中
     * @param params
     * @return
     */
    void addDsignal(Map<String,Object> params);

    List<Dsignal> signalList(Dsignal dsignal);
}
