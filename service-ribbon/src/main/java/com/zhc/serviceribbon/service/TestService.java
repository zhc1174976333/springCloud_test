package com.zhc.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {

    @Autowired
    RestTemplate restTemplate;

    // 熔断返回方法
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        // 调用 service-hi服务
        return restTemplate.getForObject("http://service-hi/hi?name="+name, String.class);
    }

    public String hiError (String name) {
        return name + "-ERROE!";
    }
}
