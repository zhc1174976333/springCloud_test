package com.zhc.servicefeign.service.impl;

import com.zhc.servicefeign.service.TestService;
import org.springframework.stereotype.Component;

@Component
public class TestServiceImpl implements TestService {
    @Override
    public String hi(String name) {
        return "ERROE, SORRY," +name + "!";
    }
}
