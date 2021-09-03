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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	
	private String taskName;
	
	@Enumerated(EnumType.STRING)
	private Priority priority;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	private int isCompleted=0;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="user_id",nullable=false)
	@JsonIgnore
	private User user;
	
	public Task() {
		super();
	}
	public Task(Task task) {
		super();
		this.id=task.id;
		this.taskName=task.getTaskName();
		this.priority=task.getPriority();
		this.isCompleted=task.isCompleted();
		this.user=task.getUser();
				
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
	public void setId(int id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}

	
	
	public void setUser(User user) {
//		if(sameAsOld(user))
//			return;
//		User Olduser=this.user;
//		if(Olduser!=null)
//			Olduser.removeTask(this);
//		if(user!=null)
//		user.addTask(this);
		this.user=user;
	}
	

   public int isCompleted() {
		return isCompleted;
	}
	public void setCompleted(int isCompleted) {
		this.isCompleted = isCompleted;
	}
	
}
