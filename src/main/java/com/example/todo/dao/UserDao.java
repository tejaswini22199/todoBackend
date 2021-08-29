package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entities.User;

@Repository
public interface UserDao extends JpaRepository<User,Integer>{
	Boolean existsByemail(String email);
	Boolean existsByname(String name);

}
