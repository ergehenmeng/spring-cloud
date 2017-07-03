package com.fanyin.service.impl;

import com.fanyin.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fanyin on 2017-07-03 15:36.
 */
@Service("helloService")
public class HelloServiceImpl implements HelloService{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    @HystrixCommand(fallbackMethod = "sayCallBack")
    public String say(String name) {
        return restTemplate.getForObject("http://spring-cloud-service/say?name=" + name,String.class);
    }

    public String sayCallBack(){
        return "调用出错啦";
    }
}
