package com.zhc.serviceribbon.controller;

import com.zhc.serviceribbon.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name) {
        return testService.hiService(name);
    }
}
