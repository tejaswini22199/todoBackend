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
import com.example.todo.exceptions.userNotFoundException;


@Service
public class TaskServicesImpl implements TaskServices {
	Logger LOG=LoggerFactory.getLogger(TaskServicesImpl.class);
	
	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	@Override
	public List<Task> addTask(Task task,int userId) {
		try {
			if(userDao.existsById(userId)==false)
				throw new userNotFoundException();
			User user=userDao.getById(userId);
			user.addTask(task);
			return user.getTasks();
		}
		catch(userNotFoundException exception) {
			
		}
		
		
	}
	@Override
	public List<Task> getTasks(int userId) {
		
		return userDao.getById(userId).getTasks();
		
	}
	private Task getTaskById(int id) {
		return taskDao.getById(id);
	}
	@Override
	public void removeTask(int id,int userId)
	{
		User user=userDao.getById(userId);
		Task task=getTaskById(id);
		user.removeTask(task);
	
		taskDao.deleteById(id);
		
	}
	@Override
	public Task updateTask(int id,Task task,int userId) {
		List<Task> tasks= userDao.findById(userId).get().getTasks();
		Task updatedTask=tasks.stream().filter(userTask->userTask.getId()==id)
				.collect(Collectors.toList()).get(0);
		if(!task.getCategory().equals(updatedTask.getCategory()))
			updatedTask.setCategory(task.getCategory());
		if(!task.getPriority().equals(updatedTask.getPriority()))
				updatedTask.setPriority(task.getPriority());
		if(!task.getTaskName().equals(updatedTask.getTaskName()))
				updatedTask.setTaskName(task.getTaskName());
		Task updatedTask1=taskDao.getById(id);
		if(!task.getCategory().equals(updatedTask1.getCategory()))
			updatedTask1.setCategory(task.getCategory());
		if(!task.getPriority().equals(updatedTask1.getPriority()))
				updatedTask1.setPriority(task.getPriority());
		if(!task.getTaskName().equals(updatedTask1.getTaskName()))
				updatedTask1.setTaskName(task.getTaskName());
		tasks.add(id, updatedTask);
		userDao.findById(userId).get().setTasks(tasks);
		return updatedTask;
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
		// TODO Auto-generated method stub
		List<Task> inCompleteTasks=getTasks(userId);
		inCompleteTasks.stream().filter(task->task.isCompleted()==0)
		.collect(Collectors.toList());
		return inCompleteTasks;
	}

	@Override
	public void markTaskComplete(int id,int userId,int markComp) {
		LOG.info(markComp+"value");
		taskDao.getById(id).setCompleted(markComp);
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
