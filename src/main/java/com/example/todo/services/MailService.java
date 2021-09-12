//package com.example.todo.services;
//
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
//import org.springframework.stereotype.Service;
//
//import com.example.todo.entities.User;
//
//@Service
//public class MailService {
//	
//	private JavaMailSender mailSender;
//	
//	public void sendMail(User user,String token) throws MailException {
//		SimpleMailMessage message=new SimpleMailMessage();
//		message.setTo(user.getEmail());
//		message.setText("here is your magical secret token. pls click on this link to get yourself verified"+"http://localhost:8080/api/auth/accountVerification/"+token);
//		mailSender.send(message);
//	}
//}
