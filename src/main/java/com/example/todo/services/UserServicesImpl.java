package com.example.todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.todo.dao.TaskDao;
import com.example.todo.dao.UserDao;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;
import com.example.todo.entities.User;

public class UserServicesImpl implements UserServices {

	@Autowired
	private TaskDao taskDao;
	@Autowired
	private UserDao userDao;
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Task> getTasks(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTasksofAPriority(Priority priority) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getCompletedTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getInCompleteTasks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task markTaskComplete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
