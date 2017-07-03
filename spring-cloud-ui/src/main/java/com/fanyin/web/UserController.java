package com.fanyin.web;

import com.fanyin.entity.User;
import com.fanyin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by fanyin on 2017-07-03 14:32.
 */
@RestController
public class UserController {



    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public ResponseEntity<List<User>> getListUser(){

        return new ResponseEntity<List<User>>(userService.getList(), HttpStatus.OK);
    }

}
