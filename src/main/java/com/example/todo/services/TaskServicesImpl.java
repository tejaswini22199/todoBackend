package com.example.todo.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.todo.dao.TaskDao;
import com.example.todo.dao.UserDao;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;

public class TaskServicesImpl implements TaskServices {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	@Override
	public Task addTask(Task task) {
		return taskDao.save(task);
		
	}

	@Override
	public void removeTask(int id) {
	taskDao.deleteById(id);
		
	}
	@Override
	public Task updateTask(int id,Task task) {
		// TODO Auto-generated method stub
		Task updatedTask=taskDao.getById(id);
		if(!task.getCategory().equals(updatedTask.getCategory()))
		updatedTask.setCategory(task.getCategory());
		if(!task.getPriority().equals(updatedTask.getPriority()))
			updatedTask.setPriority(task.getPriority());
		if(!task.getTaskName().equals(updatedTask.getTaskName()))
			updatedTask.setTaskName(task.getTaskName());
		return updatedTask;
	}

	@Override
	public Task getTaskbyId(int id) {
		return taskDao.findById(id).get();
		
	
	}

	@Override
	public List<Task> getTasks(int userId) {
		// TODO Auto-generated method stub
		
		return userDao.getById(userId).getTasks();
		
	}

	@Override
	public List<Task> getTasksofAPriority(Priority priority,int userId) {
		List<Task> tasks=getTasks(userId);
		List<Task> filteredList=tasks.stream().filter(task->!task.getPriority().equals(priority))
		.collect(Collectors.toList());
		return filteredList;
	}

	@Override
	public List<Task> getCompletedTasks(int userId) {
		List<Task> completedTasks=getTasks(userId);
		completedTasks.stream().filter(task->task.isCompleted()==true)
		.collect(Collectors.toList());
		return completedTasks;
	}

	@Override
	public List<Task> getInCompleteTasks(int userId) {
		// TODO Auto-generated method stub
		List<Task> inCompleteTasks=getTasks(userId);
		inCompleteTasks.stream().filter(task->task.isCompleted()==false)
		.collect(Collectors.toList());
		return inCompleteTasks;
	}

	@Override
	public void markTaskComplete(int id) {
		taskDao.getById(id).setCompleted(true);
		
	}

}
