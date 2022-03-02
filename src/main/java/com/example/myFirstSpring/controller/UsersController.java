package com.example.myFirstSpring.controller;

import com.example.myFirstSpring.entity.UserEntity;
import com.example.myFirstSpring.exceptions.UserAlreadyExistException;
import com.example.myFirstSpring.exceptions.UserNotFoundException;
import com.example.myFirstSpring.repository.UserRepository;
import com.example.myFirstSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(Long id) {
        try {
            userService.getUser(id);
            return ResponseEntity.ok(userService.getUser(id));
        }catch (UserNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/post")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("User is registered");
        } catch (UserAlreadyExistException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
