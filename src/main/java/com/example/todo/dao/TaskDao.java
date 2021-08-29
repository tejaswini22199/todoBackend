package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.entities.Task;

@Repository
public interface TaskDao extends JpaRepository<Task,Integer> {

}
