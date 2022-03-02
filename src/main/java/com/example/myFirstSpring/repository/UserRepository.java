package com.example.myFirstSpring.repository;

import com.example.myFirstSpring.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity findByUserName(String userName);
}
