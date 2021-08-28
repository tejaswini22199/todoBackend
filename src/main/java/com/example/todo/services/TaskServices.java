package com.example.todo.services;


import java.util.Optional;

import com.example.todo.entities.Task;

public interface TaskServices {
	
	Task addTask(Task task);
	void removeTask(int id);
	Task updateTask(int id,Task task);
	Optional<Task> getTaskbyId(int id);
}
