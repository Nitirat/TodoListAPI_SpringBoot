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

import com.example.todoListAPI.domain.ResponseDelete;
import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.model.TaskModel;

@RestController
public class TaskController {
	
	@Autowired
	private TaskModel taskModel;
	
	@GetMapping({"/", "/tasks"})
	public ResponseEntity<List<Task>> getAllTask() throws Exception {
		return new ResponseEntity<List<Task>>(taskModel.getAllTask(), HttpStatus.OK);
    }
	
	@GetMapping(value = "/tasks/{id}")
	public ResponseEntity<Task> getTaskById(@PathVariable String id) throws Exception {		
		return new ResponseEntity<Task>(taskModel.getTaskById(id), HttpStatus.OK);
    }
	
	@PostMapping(value = "/tasks")
	public ResponseEntity<Task> saveTask(@RequestBody Task task) throws Exception {
        return new ResponseEntity<Task>(taskModel.saveTask(task), HttpStatus.OK);
    }
	
	@PatchMapping(value = "/tasks")
	public ResponseEntity<Task> updateTask(@RequestBody Task task) throws Exception {
        return new ResponseEntity<Task>(taskModel.updateTask(task), HttpStatus.OK);
    }
	
	@PutMapping(value = "/tasks/{id}")
	public ResponseEntity<Task>  updateTaskPending(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Task>(taskModel.updateStatus(id), HttpStatus.OK);
    }
	
	@DeleteMapping(value = "/tasks/{id}")
	public ResponseEntity<ResponseDelete> removeTaskById(@PathVariable String id) throws Exception  {
		taskModel.removeTask(id);
		return new ResponseEntity<ResponseDelete>(new ResponseDelete("Task Deleted !! "), HttpStatus.OK);
    }
	
	

}
