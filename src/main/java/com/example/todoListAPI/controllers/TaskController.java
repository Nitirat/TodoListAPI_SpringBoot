package com.example.todoListAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoListAPI.domain.ResponseMessage;
import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping({"/", "/tasks"})
	public ResponseEntity<List<Task>> getAllTask() throws Exception {
		return new ResponseEntity<List<Task>>(taskService.getAllTask(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable String id) throws Exception {
		Task task = taskService.getTaskById(id);
		if (task == null){
            throw new Exception("Task Not Found !!");
        }
		return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
	
	@PostMapping(value = "/tasks")
	public ResponseEntity<Task> saveTask(@RequestBody Task task) throws Exception {		
        return new ResponseEntity<Task>(taskService.saveTask(task), HttpStatus.OK);
    }
	
	@PatchMapping(value = "/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) throws Exception {
		Task taskValue = taskService.getTaskById(task.getId());
        if (taskValue == null){
            throw new Exception("Task Not Found !!");
        }
        return new ResponseEntity<Task>(taskService.updateTask(task), HttpStatus.OK);
    }
	
	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<Task>  updateStatus(@PathVariable("id") String id) throws Exception {
		Task task = taskService.getTaskById(id);
        if (task == null){
            throw new Exception("Task Not Found !!");
        }
        return new ResponseEntity<Task>(taskService.updateStatus(task), HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/tasks/{id}")
	public ResponseEntity<ResponseMessage> removeTaskById(@PathVariable("id") String id) throws Exception  {
		Task task = taskService.getTaskById(id);
		if (task == null){
            throw new Exception("Task Not Found !!");
        }
		taskService.removeTask(task);
		return new ResponseEntity<ResponseMessage>(new ResponseMessage("Task Deleted !! "), HttpStatus.OK);
    }	

}
