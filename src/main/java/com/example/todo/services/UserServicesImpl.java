package com.example.todo.services;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dao.UserDao;
import com.example.todo.entities.User;


@Service
public class UserServicesImpl implements UserServices {
	
	Logger LOG=LoggerFactory.getLogger(UserServicesImpl.class);
	@Autowired
	private UserDao userDao;
	
	@Override
	public User addUser(User user) {
		LOG.info("The count of users,{}", userDao.count());
	
		return userDao.save(new User(user));
		
	}
	
	@Override
	public User getUser(int id) {
		return userDao.getById(id);
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
