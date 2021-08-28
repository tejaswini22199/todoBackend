package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.entities.User;

public interface UserDao extends JpaRepository<User,Integer>{

}
