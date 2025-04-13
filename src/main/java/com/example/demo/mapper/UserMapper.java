package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    void insert(UserEntity userPO);

    void update(UserEntity userPO);

    void deleteById(Long userId);

    List<UserEntity> getAll();

    UserEntity getById(Long userId);
    UserEntity getByName(String name);
}