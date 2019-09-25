package com.rtstjkx.jkx.service.serviceImpl;

import com.rtstjkx.jkx.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String open(String msg) {
        return "succes";
    }
}
