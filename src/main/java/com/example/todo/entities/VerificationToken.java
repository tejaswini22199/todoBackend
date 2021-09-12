//package com.example.todo.entities;
//
//import java.time.Instant;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class VerificationToken {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;
//	private String token;
//	@OneToOne(fetch=FetchType.LAZY)
//	private User user;
//	private Instant expiryTime;
//	
//	public VerificationToken() {
//		super();
//	}
//	
//	public VerificationToken(int id, String token, User user, Instant expiryTime) {
//		super();
//		this.id = id;
//		this.token = token;
//		this.user = user;
//		this.expiryTime = expiryTime;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
//	public Instant getExpiryTime() {
//		return expiryTime;
//	}
//	public void setExpiryTime(Instant expiryTime) {
//		this.expiryTime = expiryTime;
//	}
//	@Override
//	public String toString() {
//		return "VerificationToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryTime=" + expiryTime
//				+ "]";
//	}
//	
//}
