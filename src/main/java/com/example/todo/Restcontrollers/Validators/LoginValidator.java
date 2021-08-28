package com.example.todo.Restcontrollers.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.entities.User;
import com.example.todo.services.UserServices;

@RestController
@RequestMapping("/api/validate")
public class LoginValidator {
	@Autowired
	private UserServices service;
	
	@RequestMapping(value="/api/validate",method=RequestMethod.POST)
	boolean validate(@RequestBody User user) {
		return service.userExists(user);
	}
}
