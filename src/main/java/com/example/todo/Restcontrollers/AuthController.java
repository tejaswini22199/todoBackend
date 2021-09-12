//package com.example.todo.Restcontrollers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.todo.dto.LoginRequest;
//import com.example.todo.dto.RegisterRequest;
//import com.example.todo.services.AuthService;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//	
//	@Autowired
//	private AuthService authService;
//	
//	@RequestMapping(value="/signup",method=RequestMethod.POST)
//	public ResponseEntity<String> signUp(@RequestBody RegisterRequest request) {
//		authService.signUp(request);
//		return new ResponseEntity<>("User created successfully",HttpStatus.OK);
//	}
////	@RequestMapping(value="/accountVerification/{token}",method=RequestMethod.GET)
////	public verifyToken()
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public ResponseEntity<String> login(@RequestBody LoginRequest request){
//		authService.login(request);
//		return new ResponseEntity<>("User logged in",HttpStatus.OK);
//	}
//}
