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


    /**
     * 如果调用失败,则会执行fallbackMethod方法 注意:回调方法的参数应和原始参数一致
     * @param name
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "sayCallBack")
    public String say(String name) {
        return restTemplate.getForObject("http://spring-cloud-service/say?name=" + name,String.class);
    }

    public String sayCallBack(String name){
        return "调用出错啦" + name;
    }
}
