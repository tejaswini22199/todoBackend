package com.example.todo.Restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.Category;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;
import com.example.todo.services.TaskServices;

@RestController
@RequestMapping("/api")
public class TaskController {
	

	@Autowired
	private TaskServices service;
	

	@RequestMapping(value="/tasks",method=RequestMethod.GET)
	List<Task> getTasks(@RequestParam(name="userId") int userId,@RequestParam(name="priority") Priority priority,@RequestParam(name="category") Category category)
	{
		if(priority.equals(Priority.NULL)==true && category.equals(Category.NULL)==true)
			return service.getTasks(userId);
		if(priority.equals(Priority.NULL)==true && category.equals(Category.NULL)==false)
			return service.getTasksofACategory(category, userId);
		if(priority.equals(Priority.NULL)==false && category.equals(Category.NULL)==true)
		return service.getTasksofAPriority(priority, userId);
		List<Task> list1=service.getTasksofACategory(category, userId);
		List<Task> list2= service.getTasksofAPriority(priority, userId);
		list1.retainAll(list2);
		return list1;
	}
	@RequestMapping(value="/tasks",method=RequestMethod.POST)
	List<Task> addTask(@RequestBody Task task,@RequestParam("userId") int userId)
	{
		
		return service.addTask(task,userId);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT)
	Task editTask(@RequestBody Task task ,@PathVariable("id") int id,@RequestParam("userId") int userId)
	{
		//not working correctly (not updating in usersDao as well as TasksDao
		return service.updateTask(id, task,userId);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	void removeTask(@PathVariable("id") int id,@RequestParam("userId") int userId)
	{
		service.removeTask(id,userId);
	}
	@RequestMapping(value="/task/{id}",method=RequestMethod.PUT)
	void markComplete(@PathVariable("id") int id,@RequestParam("userId") int userId,@RequestParam("markComp") int markComp)
	{
		//not working properly
		service.markTaskComplete(id,userId,markComp);
	}
	
	
}
