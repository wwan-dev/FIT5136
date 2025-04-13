package com.example.demo.service;
import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    public List<UserEntity> getall(){
        return userMapper.getAll();
    }
    public UserEntity selectById(long id){
        return userMapper.getById(id);
    }
    public UserEntity getByName(String username){
        return userMapper.getByName(username);
    }

}
