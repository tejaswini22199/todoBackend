package com.example.todo.entities;

import java.util.List;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int Id;
	private String name;
	private String email;
	private String password;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private List<Task> tasks;
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
}
