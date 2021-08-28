package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.entities.Task;

public interface TaskDao extends JpaRepository<Task,Integer> {

}
