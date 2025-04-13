package com.example.demo.entity;

import java.util.Date;

//用户的实体类
public class UserEntity {

    private Long id;
    private String userName;
    private Integer age;
    private String email;
    private Date createTime;
    private Date updateTime;
    private Integer version;

    public UserEntity(Long id, String userName, Integer age, String email, Date createTime, Date updateTime, Integer version) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.email = email;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}