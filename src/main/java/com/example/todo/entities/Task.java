package com.example.todo.entities;




import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;



import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String taskName;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private int isCompleted=0;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	@JsonIgnore
	private User user;
	public Task() {
		super();
	}
	public Task(int id, String taskName, Priority priority, Category category, int isCompleted, User user) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.priority = priority;
		this.category = category;
		this.isCompleted = isCompleted;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public String getTaskName() {
		return taskName;
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
		this.taskName = taskName;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setUser(User user) {
		if(sameAsOld(user))
			return;
		User Olduser=this.user;
		if(Olduser!=null)
			Olduser.removeTask(this);
		if(user!=null)
		user.addTask(this);
	}
	
	private boolean sameAsOld(User newUser) {
		return user==null? newUser==null : user.equals(newUser);
	}
	public int isCompleted() {
		return isCompleted;
	}
	public void setCompleted(int isCompleted) {
		this.isCompleted = isCompleted;
	}
	
}
