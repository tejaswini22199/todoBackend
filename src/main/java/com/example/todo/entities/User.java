package com.example.todo.entities;

import java.util.ArrayList;
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
	@OneToMany(cascade=CascadeType.MERGE,fetch=FetchType.LAZY,mappedBy="user",orphanRemoval=true)
	private List<Task> tasks=new ArrayList<Task>();
	public User() {
		super();
	}
	public User(int id, String name, String email, String password, List<Task> tasks) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.tasks = tasks;
	}
	
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
		return new ArrayList<Task>(tasks);
	}
	public void addTask(Task task)
	{
		if(tasks.contains(task))
			return;
		tasks.add(task);
		task.setUser(this);
	}
	public void removeTask(Task task) {
		if(!tasks.contains(task))
			return;
		tasks.remove(task);
		task.setUser(null);
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
