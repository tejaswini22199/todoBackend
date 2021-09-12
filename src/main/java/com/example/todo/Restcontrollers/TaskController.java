package com.example.todo.Restcontrollers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.dao.TaskDao;
import com.example.todo.dto.TaskRequest;
import com.example.todo.entities.Category;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;
import com.example.todo.entities.User;
import com.example.todo.services.TaskServices;
import com.example.todo.services.UserServices;


@RestController
@RequestMapping("/api")
public class TaskController {
	

	Logger LOG=LoggerFactory.getLogger(TaskController.class);
	@Autowired
	private TaskServices service;
	
	@Autowired
	private UserServices userService;
	
	@Autowired
	private TaskDao taskDao;
	
	public TaskController(TaskServices service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(value="/tasks/{userId}",method=RequestMethod.GET)
	List<Task> getTasks(@PathVariable(name="userId") int userId,@RequestParam(name="priority") Priority priority,@RequestParam(name="category") Category category)
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
	Task addTask(@RequestBody TaskRequest taskRequest)
	{
		int userId=taskRequest.getUser_id();
		User user=userService.getUser(userId);
		
		Task task=new Task();
		
		task.setTaskName(taskRequest.getTaskName());
		task.setCategory(taskRequest.getCategory());
		task.setPriority(taskRequest.getPriority());
		task.setUser(user);

		return service.addTask(task);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.PUT)
	Task editTask(@RequestBody TaskRequest taskRequest,@PathVariable("id") int id)
	{
		Task task=service.getTaskbyId(id);
		task.setCategory(taskRequest.getCategory());
		task.setPriority(taskRequest.getPriority());
		task.setTaskName(taskRequest.getTaskName());
		task.setCompleted(taskRequest.getIsCompleted());
		return service.updateTask(task);
	}
	@RequestMapping(value="/tasks/{id}",method=RequestMethod.DELETE)
	void removeTask(@PathVariable("id") int id)
	{
		service.removeTask(id);
	}
	@RequestMapping(value="/task/{id}",method=RequestMethod.PUT)
	void markComplete(@PathVariable("id") int id)
	{
		//not working properly
		service.markTaskComplete(id);
	}
	
	@RequestMapping(value="/tasks/{user_id}/complete",method=RequestMethod.GET)
	List<Task> getCompleteTasks(@PathVariable("user_id") int userId){
		return service.getCompletedTasks(userId);
	}
	
	@RequestMapping(value="/tasks/{user_id}/incomplete",method=RequestMethod.GET)
	List<Task> getInCompleteTasks(@PathVariable("user_id") int userId){
		return service.getInCompleteTasks(userId);
	}
	
}
