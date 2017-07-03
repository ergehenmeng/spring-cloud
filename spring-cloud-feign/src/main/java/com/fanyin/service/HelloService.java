package com.fanyin.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign调用方式是基于接口形式 整合了ribbon
 */
@FeignClient(value = "spring-cloud-service",fallback = HelloServiceCallBack.class)
public interface HelloService {

    @RequestMapping("/say")
    String say(@RequestParam("name")String name);

}
