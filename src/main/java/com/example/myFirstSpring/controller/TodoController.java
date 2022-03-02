package com.example.myFirstSpring.controller;

import com.example.myFirstSpring.entity.TodoEntity;
import com.example.myFirstSpring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/post")
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long userId) {
        return ResponseEntity.ok(todoService.create(todo, userId));
    }

    @PutMapping("/put")
    public ResponseEntity completeTodo(@RequestParam Long todoId) {
        return ResponseEntity.ok(todoService.complete(todoId));
    }
}
