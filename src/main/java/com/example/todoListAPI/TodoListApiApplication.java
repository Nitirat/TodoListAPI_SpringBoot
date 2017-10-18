package com.example.todoListAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.repositories.TaskRepository;

@SpringBootApplication
public class TodoListApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoListApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner setup(TaskRepository taskRepository) {
		return (args) -> {
			taskRepository.save(new Task("Stand-up meeting","10.00 AM"));
			taskRepository.save(new Task("Retrospective","Friday"));
		};
	}
}
