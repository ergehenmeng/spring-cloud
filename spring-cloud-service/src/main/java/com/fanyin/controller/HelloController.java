package com.fanyin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fanyin on 2017-07-03 15:45.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @RequestMapping("/say")
    public String say(String name){
        return "我是 " + name + "请求端口号:" + port;
    }
}
