package com.example.todo.services;


import com.example.todo.entities.User;

public interface UserServices {
	User addUser(User user);
	void removeUser(int id);
	
}
