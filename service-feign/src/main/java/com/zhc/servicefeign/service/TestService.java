package com.zhc.servicefeign.service;

import com.zhc.servicefeign.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi", fallback = TestServiceImpl.class)
public interface TestService {

    /**
     * 声明式的，具体实现为service-hi服务当中的方法，实现类为熔断fallback的方法
     * @param name
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi(@RequestParam("name") String name);
}
