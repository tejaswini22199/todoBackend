package com.example.todo.Restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.Task;
import com.example.todo.services.TaskServices;

@RestController
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskServices service;
	
	@RequestMapping(value="/tasks",method=RequestMethod.GET)
	List<Task> getTasks(int userId)
	{
		return service.getTasks(userId);
	}
	@RequestMapping(value="/tasks",method=RequestMethod.POST)
	Task addTask(@RequestBody Task task)
	{
		return service.addTask(task);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT)
	void editTask(@RequestBody Task task ,@PathVariable("id") int id)
	{
		service.updateTask(id, task);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	void removeTask(@PathVariable("id") int id)
	{
		service.removeTask(id);
	}
	@RequestMapping(value="/tasks/markComp/{id}",method=RequestMethod.PUT)
	void markComplete(@PathVariable("id") int id)
	{
		service.markTaskComplete(id);
	}
	
}
