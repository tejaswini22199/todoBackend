package com.example.todo.services;

import java.util.List;

import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;
import com.example.todo.entities.User;

public interface UserServices {
	User addUser(User user);
	void removeUser(int id);
	List<Task> getTasks(int id);
	List<Task> getTasks();
	List<Task> getTasksofAPriority(Priority priority);
	List<Task> getCompletedTasks();
	List<Task> getInCompleteTasks();
	Task markTaskComplete(int id);
}
