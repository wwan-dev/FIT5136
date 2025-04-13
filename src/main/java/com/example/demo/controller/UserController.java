package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/hello/{username}") //监听hello请求
    public UserEntity getUser(@PathVariable("username") String userName){
        return userMapper.getByName(userName);
    }
}