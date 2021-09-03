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

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	
	@NotEmpty(message="user name can't be empty")
	@Size(max=25)
	private String name;
	
	@NotEmpty(message="email can't be empty")
	@Size(max=25)
	private String email;
	
	
	@Size(max=25)
	private String password;
	@OneToMany(
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER,
			mappedBy="user",
			orphanRemoval=true
			)
	@Fetch(FetchMode.SELECT)
	@BatchSize(size=30)
	private List<Task> tasks=new ArrayList<Task>();
	public User() {
		super();
	}
	public User(User user) {
		super();
		this.Id=user.Id;
		this.name=user.getName();
		this.email=user.getEmail();
		this.password=user.getPassword();
		this.tasks=user.getTasks();
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
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Task> getTasks() {
		return new ArrayList<Task>(tasks);
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + ", password=" + password + ", tasks=" + tasks
				+ "]";
	}
	
}
