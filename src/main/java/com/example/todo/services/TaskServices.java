package com.example.todo.services;


import java.util.List;

import org.springframework.stereotype.Component;

import com.example.todo.entities.Priority;
import com.example.todo.entities.Task;

@Component
public interface TaskServices {
	
	Task addTask(Task task);
	void removeTask(int id);
	Task updateTask(int id,Task task);
	Task getTaskbyId(int id);
	List<Task> getTasks(int userId);
	List<Task> getTasksofAPriority(Priority priority,int userId);
	List<Task> getCompletedTasks(int userId);
	List<Task> getInCompleteTasks(int userId);
	void markTaskComplete(int id);
}
