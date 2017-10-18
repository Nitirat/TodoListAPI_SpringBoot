package com.example.todoListAPI.service;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoListAPI.TodoListApiApplication;
import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.repositories.TaskRepository;

@Service
public class TaskService {
	
	private static final Logger logger = LoggerFactory.getLogger(TodoListApiApplication.class);
	
	@Autowired
    private TaskRepository taskRepository;
	
	public List<Task> getAllTask() throws Exception {
        return taskRepository.findAll();
    }
	
	public Task getTaskById(String id) throws Exception {
        return taskRepository.findOne(id);
    }
	
	public Task saveTask(Task task) throws Exception {
        return taskRepository.save(task);
    }
	
	public Task updateTask(Task task) throws Exception {
		return saveTask(task);
	}
	
	public Task updateStatus(Task task) throws Exception {
		logger.info(task.getId()+" : Update Status To : "+!task.isDone());
		task.setDone(!task.isDone());
        return taskRepository.save(task);
    }
	
	public void removeTask(Task task) throws Exception {
        taskRepository.delete(task);
    }
}
