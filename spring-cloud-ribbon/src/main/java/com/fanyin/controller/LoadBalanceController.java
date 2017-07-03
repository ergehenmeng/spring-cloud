package com.fanyin.controller;

import com.fanyin.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanyin on 2017-07-03 15:34.
 */
@RestController
public class LoadBalanceController {

    @Autowired
    private HelloService helloService;

    @Value("${server.port}")
    private int port;

    @RequestMapping("/say")
    public String say(String name){
        return helloService.say(name);
    }

    @RequestMapping("/route")
    public String route(String name){
        return name + ",路由生效了,端口:" + port;
    }
}
