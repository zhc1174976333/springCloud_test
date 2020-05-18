package com.zhc.servicefeign.controller;

import com.zhc.servicefeign.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return testService.hi(name);
    }
}
