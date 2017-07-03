package com.fanyin.service.impl;

import com.fanyin.entity.User;
import com.fanyin.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyin on 2017-07-03 14:33.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    final String SERVICE_NAME = "spring-cloud-service";

    @Override
    @HystrixCommand(fallbackMethod = "getListFallBack")
    public List<User> getList() {
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/userList",List.class);
    }

    private List<User> getListFallBack(){
        List<User> list = new ArrayList<>();
        User user = new User("张三",21);
        list.add(user);
        return list;
    }
}
