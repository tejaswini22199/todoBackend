package com.example.todo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dao.UserDao;
import com.example.todo.entities.User;

@Service
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
	
	@Override
	public boolean userExists(User user) {
		// TODO Auto-generated method stub
		return userDao.findAll().stream().anyMatch(currentUser-> currentUser.equals(user));

	}
	
	@Override
	public boolean validateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUsers()
	{
		return userDao.findAll();
	}

}
