// Importing package in this code module
package com.cg.controller;
//Importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.AuthenticationRequest;
import com.cg.model.AuthenticationResponse;
import com.cg.model.UserModel;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;
import com.cg.utils.JwtUtils;

//Annotation 
@RestController
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/dashboard")
    private String testingToken() {
        return "Welcome to DashBoard";
	}
	// Save operation
	@PostMapping("/register")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel user = new UserModel();
		user.setUsername(username);
		user.setPassword(password);
		try {
			userRepository.save(user);
		}catch(Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error registration for User"));
		}
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Successful Registration for User" + username));
		
	}
	
	
	// Save operation
	@PostMapping("/login")
	private ResponseEntity<?> authenticationClient(@RequestBody AuthenticationRequest authenticationRequest){
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		
		
		try {
			authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		}catch(Exception e){
			return ResponseEntity.ok(new AuthenticationResponse("Please provide a valid username and password" + username));
			
		}
		UserDetails loadedUser = userService.loadUserByUsername(username);
		String generatedToken = jwtUtils.generateToken(loadedUser);
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));
		
	}
	
	

}
