package com.example.todo.services;



import org.springframework.beans.factory.annotation.Autowired;


import com.example.todo.dao.UserDao;
import com.example.todo.entities.User;

public class UserServicesImpl implements UserServices {

	@Autowired
	private UserDao userDao;
	@Override
	public User addUser(User user) {
		return userDao.save(user);
		
	}

	@Override
	public void removeUser(int id) {
		userDao.deleteById(id);
	}

	

}
