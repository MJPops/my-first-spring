package com.example.myFirstSpring.models;

import com.example.myFirstSpring.entity.UserEntity;

public class User {

    private Long id;
    private String userName;

    public static User toModel(UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setUserName(entity.getUserName());
        return model;
    }

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String userName) {
        this.id = id;
        this.userName = userName;
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
}
