package com.example.todo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entities.Task;
import com.example.todo.entities.User;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer> {
	List<Task> findByUser(User user);
}
