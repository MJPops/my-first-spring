package com.example.myFirstSpring.service;

import com.example.myFirstSpring.entity.TodoEntity;
import com.example.myFirstSpring.entity.UserEntity;
import com.example.myFirstSpring.models.Todo;
import com.example.myFirstSpring.repository.TodoRepository;
import com.example.myFirstSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public Todo create(TodoEntity todo, Long userId){
        UserEntity user = userRepository.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepository.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepository.findById(id).get();
        todo.setCompleted(true);
        return Todo.toModel(todoRepository.save(todo));
    }
}
