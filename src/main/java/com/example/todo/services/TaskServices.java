package com.example.todo.services;


import java.util.List;

import com.example.todo.entities.Category;
import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;

public interface TaskServices {
	
	Task addTask(Task task);
	void removeTask(int id);
	Task updateTask(Task task);
	Task getTaskbyId(int id);
	List<Task> getTasks(int userId);
	List<Task> getTasksofAPriority(Priority priority,int userId);
	List<Task> getTasksofACategory(Category category,int userId);
	List<Task> getCompletedTasks(int userId);
	List<Task> getInCompleteTasks(int userId);
	void markTaskComplete(int id);
}
