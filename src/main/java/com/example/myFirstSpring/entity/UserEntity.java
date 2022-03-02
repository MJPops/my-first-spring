package com.example.myFirstSpring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<TodoEntity> todoEntities;


    public UserEntity() {
    }

    public UserEntity(long id) {
        this.id = id;
    }

    public UserEntity(long id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public UserEntity(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TodoEntity> getTodoEntities() {
        return todoEntities;
    }

    public void setTodoEntities(List<TodoEntity> todoEntities) {
        this.todoEntities = todoEntities;
    }
}
