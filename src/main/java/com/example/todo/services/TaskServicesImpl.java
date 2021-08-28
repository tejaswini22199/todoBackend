package com.example.todo.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.todo.dao.TaskDao;
import com.example.todo.entities.Task;

public class TaskServicesImpl implements TaskServices {

	@Autowired
	private TaskDao taskDao;
	
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
	public Optional<Task> getTaskbyId(int id) {
		return taskDao.findById(id);
		
	
	}



}
