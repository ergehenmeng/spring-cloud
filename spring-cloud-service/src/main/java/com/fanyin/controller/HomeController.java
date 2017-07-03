package com.fanyin.controller;

import com.fanyin.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyin on 2017-07-03 15:08.
 */
@RestController
public class HomeController {

    @RequestMapping("/userList")
    public List<User> getUserList(){
        List<User> list = new ArrayList<>();
        list.add(new User(1L,"李四",22));
        return list;
    }
}
