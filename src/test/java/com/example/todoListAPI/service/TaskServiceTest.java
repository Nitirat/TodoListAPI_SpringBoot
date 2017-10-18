package com.example.todoListAPI.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.todoListAPI.domain.Task;
import com.example.todoListAPI.repositories.TaskRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class TaskServiceTest {
	
	@Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void getAllTask() throws Exception{
    	List<Task> taskList = new ArrayList<Task>();
        taskList.add(new Task("Stand-up meeting","10.00 AM"));
        taskList.add(new Task("Retrospective","Friday"));
        when(taskRepository.findAll()).thenReturn(taskList);        
        List<Task> result = taskService.getAllTask();
        assertEquals(2, result.size());
    }
    
    @Test
    public void saveTask() throws Exception{
        Task task = new Task("Stand-up meeting","12.00 AM");
        when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.saveTask(task);
        assertEquals("Stand-up meeting", result.getSubject());
        assertEquals("12.00 AM", result.getDetail());
        assertEquals(false, result.isDone());
    }
    
    @Test
    public void getTaskById() throws Exception{
        Task task = new Task("1","Retrospective","Friday", true);
        when(taskRepository.findOne("1")).thenReturn(task);        
        Task result = taskService.getTaskById("1");
        assertEquals("1", result.getId());
        assertEquals("Retrospective", result.getSubject());
        assertEquals("Friday", result.getDetail());
        assertEquals(true, result.isDone());
    }    
    
    @Test
    public void removeTask() throws Exception{
        Task task = new Task("7","Retrospective","Friday", true);
        taskService.removeTask(task);
        verify(taskRepository, times(1)).delete(task);
    }
    
    @Test
    public void updateStatus() throws Exception{
    	Task task = new Task("9","Retrospective","Friday", true);
    	when(taskRepository.save(task)).thenReturn(task);
        Task result = taskService.updateStatus(task);
        assertEquals("Retrospective", result.getSubject());
        assertEquals("Friday", result.getDetail());
        assertEquals(false, result.isDone());
    }

}
