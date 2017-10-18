package com.example.todoListAPI.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.todoListAPI.domain.Task;

public interface TaskRepository extends MongoRepository<Task, String>{ }
