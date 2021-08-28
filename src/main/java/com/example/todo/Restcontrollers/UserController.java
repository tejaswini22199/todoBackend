package com.example.todo.Restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.User;
import com.example.todo.services.UserServices;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserServices userService;
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	User register(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	@RequestMapping(value="/users",method=RequestMethod.DELETE)
	void deleteUser(@PathVariable("id") int id)
	{
		userService.removeUser(id);
	}
}
