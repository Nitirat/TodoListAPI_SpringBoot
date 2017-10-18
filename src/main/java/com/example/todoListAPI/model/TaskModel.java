package com.example.todoListAPI.model;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.repositories.TaskRepository;

@Service
public class TaskModel {
	
	@Autowired
    private TaskRepository taskRepository;
	
	public List<Task> getAllTask() throws Exception {
        return taskRepository.findAll();
    }
	
	public Task getTaskById(String id) throws Exception {
		Task task = taskRepository.findOne(id);
		if (task == null){
            throw new Exception("Task Not Found !!");
        }
        return task;
    }
	
	public Task saveTask(Task task) throws Exception {
        return taskRepository.save(task);
    }
	
	public Task updateTask(Task task) throws Exception {
		Task taskValue = taskRepository.findOne(task.getId());
        if (taskValue == null){
            throw new Exception("Task Not Found !!");
        }
		return saveTask(task);
	}
	
	public Task updateStatus(String id) throws Exception {
		Task task = taskRepository.findOne(id);
        if (task == null){
            throw new Exception("Task Not Found !!");
        }
		
		if(task.getStatus().equals("Pending"))
			task.setStatus("Done");
		else
			task.setStatus("Pending");
        return taskRepository.save(task);
    }
	
	public void removeTask(String id) throws Exception {
		Task task = taskRepository.findOne(id);
		if (task == null){
            throw new Exception("Task Not Found !!");
        }
        taskRepository.delete(task);
    }
}
