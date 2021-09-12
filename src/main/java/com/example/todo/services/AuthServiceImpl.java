//package com.example.todo.services;
//
//
//
//import java.time.Instant;
//import java.util.UUID;
//
//import javax.transaction.Transactional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.example.todo.dao.UserDao;
//import com.example.todo.dao.VerificationDao;
//import com.example.todo.dto.LoginRequest;
//import com.example.todo.dto.RegisterRequest;
//import com.example.todo.entities.User;
//import com.example.todo.entities.VerificationToken;
//
//@Service
//public class AuthServiceImpl implements AuthService{
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private UserDao userDao;
//	
//	@Autowired
//	private VerificationDao verifyToken;
//	
//	@Autowired
//	private MailService mailService;
//	
//	@Override
//	@Transactional
//	public void signUp(RegisterRequest request) {
//		User user=new User();
//		user.setName(request.getUsername());
//		user.setPassword(passwordEncoder.encode(request.getPassword())); 
//		user.setEmail(request.getEmail());
//		user.setCreatedAt(Instant.now());
//		user.setIsenabled(false);
//		userDao.save(user);
//		String token=generateToken(user);
//		mailService.sendMail(user,token);
//	}
//	
//	private String generateToken(User user) {
//		String token=UUID.randomUUID().toString();
//		VerificationToken Token=new VerificationToken();
//		Token.setToken(token);
//		Token.setUser(user);
//		//Token.setExpiryTime(null);
//		verifyToken.save(Token);
//		return token;
//	}
//	@Override
//	public void login(LoginRequest request) {
//		
//	}
//
//}
