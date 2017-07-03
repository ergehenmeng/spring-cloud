package com.fanyin.service;

import org.springframework.stereotype.Component;

/**
 * Created by fanyin on 2017-07-03 16:44.
 */
@Component("helloServiceCallBack")
public class HelloServiceCallBack implements  HelloService {
    @Override
    public String say(String name) {
       return "熔断器生效了";
    }
}
