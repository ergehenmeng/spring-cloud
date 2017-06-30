package com.fanyin.controller;

import com.fanyin.entity.User;
import com.fanyin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author fanyin
 * @create 2017-06-29 11:33
 */
@RestController
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/index/{id}")
    public Date index(@PathVariable Long id){
        User user = userMapper.getUserById(id);
        System.out.println(user);
        return new Date();
    }


}
