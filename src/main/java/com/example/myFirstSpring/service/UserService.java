package com.example.myFirstSpring.service;

import com.example.myFirstSpring.entity.UserEntity;
import com.example.myFirstSpring.exceptions.UserAlreadyExistException;
import com.example.myFirstSpring.exceptions.UserNotFoundException;
import com.example.myFirstSpring.models.User;
import com.example.myFirstSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUserName(user.getUserName()) != null) {
            throw new UserAlreadyExistException("User with this userName already contains");
        }
        return userRepository.save(user);
    }

    public User getUser(Long id) throws UserNotFoundException {
        UserEntity user = userRepository.findById(id).get();

        if (user == null){
            throw new UserNotFoundException("User not found");
        }
        return User.toModel((user));
    }
}
