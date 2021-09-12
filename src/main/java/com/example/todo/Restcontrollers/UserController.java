package com.example.todo.Restcontrollers;

import java.util.List;

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
	
	@Autowired
	public UserController(UserServices userService) {
		super();
		this.userService = userService;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	User save(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	User getUser(@PathVariable("id") int id)
	{
		return userService.getUser(id);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	List<User> getUsers()
	{
		return userService.getUsers();
	}
	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
	void deleteUser(@PathVariable("id") int id)
	{
		userService.removeUser(id);
	}
	
}
