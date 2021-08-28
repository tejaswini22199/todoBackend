package com.example.todo.services;


import org.springframework.stereotype.Component;

import com.example.todo.entities.User;

@Component
public interface UserServices {
	User addUser(User user);
	void removeUser(int id);
	boolean userExists(User user);
	boolean validateUser(User user);
}
