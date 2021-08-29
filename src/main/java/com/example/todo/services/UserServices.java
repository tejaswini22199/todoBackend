package com.example.todo.services;

import java.util.List;

import com.example.todo.entities.User;


public interface UserServices {
	User addUser(User user);
	void removeUser(int id);
	boolean userExists(User user);
	boolean validateUser(User user);
	List<User> getUsers();
}
