package com.example.todo.entities;

import java.util.Locale.Category;

import javax.annotation.Priority;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="task")
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String TaskName;
	private Priority priority;
	private Category category;
	boolean isCompleted;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	public int getId() {
		return id;
	}
	public String getTaskName() {
		return TaskName;
	}
	public Priority getPriority() {
		return priority;
	}
	public Category getCategory() {
		return category;
	}
	public User getUser() {
		return user;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
}
