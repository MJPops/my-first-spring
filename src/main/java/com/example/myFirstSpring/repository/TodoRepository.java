package com.example.myFirstSpring.repository;

import com.example.myFirstSpring.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<TodoEntity, Long> {
}
