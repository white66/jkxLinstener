package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.bean.ResponseCode;
import com.rtstjkx.jkx.entity.Dsignal;
import com.rtstjkx.jkx.service.serviceImpl.SignalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/signal")
public class SignalController {
    @Autowired
    SignalServiceImpl signalService;
    @Autowired
    ResponseCode responseCode;

    @PostMapping("/signalList")
    public ResponseCode signalList(@RequestBody Dsignal dsignal){
        List<Dsignal> dsignals = signalService.signalList(dsignal);
        return responseCode.success(dsignals);
    }
}
