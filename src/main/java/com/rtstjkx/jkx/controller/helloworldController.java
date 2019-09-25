package com.rtstjkx.jkx.controller;

import com.rtstjkx.jkx.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class helloworldController {
    @Autowired
    HelloService helloService;
    @GetMapping("/hello")
    public String hello(){

        return "hello world!";
    }
}
