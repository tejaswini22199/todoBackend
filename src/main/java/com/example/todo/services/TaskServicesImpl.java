package com.example.todo.services;


import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dao.TaskDao;
import com.example.todo.dao.UserDao;

import com.example.todo.entities.Category;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;
import com.example.todo.entities.User;

import com.example.todo.exceptions.ResourceNotFoundException;


@Service
public class TaskServicesImpl implements TaskServices {
	Logger LOG=LoggerFactory.getLogger(TaskServicesImpl.class);
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public Task addTask(Task task) {
	
		return taskDao.save(task);
	}
	
	@Override
	public List<Task> getTasks(int userId) {
		
		User user=getUserById(userId);
		LOG.info(user.toString());
		return user.getTasks();
		
	}
	
	private User getUserById(int userId) {
		
		if(userDao.existsById(userId)==false)
			throw new ResourceNotFoundException("User doesn't exist");
		User user=userDao.getById(userId);
		return user;
	}
	
	private Task getTaskById(int id) {
		
		if(taskDao.getById(id)==null) {
			throw new ResourceNotFoundException("Task doesn't exist");
		}
		return taskDao.getById(id);
	}
	@Override
	public void removeTask(int id)
	{
		taskDao.deleteById(id);
		
	}
	@Override
	public Task updateTask(Task task) {
		return taskDao.save(task);
	}

	@Override
	public Task getTaskbyId(int id) {
		return taskDao.findById(id).get();
		
	
	}

	

	@Override
	public List<Task> getTasksofAPriority(Priority priority,int userId) {
		List<Task> tasks=getTasks(userId);
		List<Task> filteredList=tasks.stream().filter(task->task.getPriority().equals(priority))
		.collect(Collectors.toList());
		return filteredList;
	}

	@Override
	public List<Task> getCompletedTasks(int userId) {
		List<Task> completedTasks=getTasks(userId);
		completedTasks.stream().filter(task->task.isCompleted()==1)
		.collect(Collectors.toList());
		return completedTasks;
	}

	@Override
	public List<Task> getInCompleteTasks(int userId) {
		List<Task> inCompleteTasks=getTasks(userId);
		inCompleteTasks.stream().filter(task->task.isCompleted()==0)
		.collect(Collectors.toList());
		return inCompleteTasks;
	}

	@Override
	public void markTaskComplete(int id) {
		Task task=getTaskbyId(id);
		task.setCompleted(1-task.isCompleted());
		taskDao.save(task);
//		Task task=(Task)userDao.findById(userId).get().getTasks().stream().filter(userTask->userTask.getId()==id);
//		task.setCompleted(markComp);
	}

	@Override
	public List<Task> getTasksofACategory(Category category, int userId) {
		List<Task> tasks=getTasks(userId);
		List<Task> filteredList=tasks.stream().filter(task->task.getCategory().equals(category))
		.collect(Collectors.toList());
		return filteredList;
	}

}
