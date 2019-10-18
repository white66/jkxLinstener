package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.entity.Dsignal;
import com.rtstjkx.jkx.repository.SignalMapper;
import com.rtstjkx.jkx.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SignalServiceImpl implements SignalService {
    @Autowired
    SignalMapper signalMapper;

    @Override
    public List<Dsignal> signalList(Dsignal dsignal) {
        List<Dsignal> dsignals = signalMapper.signalList(dsignal);
        return dsignals;
    }
}
