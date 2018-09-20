package com.qa.lmsproject.controller;

import java.nio.file.attribute.UserPrincipal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.config.SpringDataJpaUserDetailsService;
import com.qa.lmsproject.model.User;
import com.qa.lmsproject.repository.UserRepo;;

@RestController
@RequestMapping("/api")
public class UserController {
 
	@Autowired
	UserRepo myRepository;

//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
//		User checkUsername = null;
//		
//		try {
//			checkUsername = myRepository.findOneByUsername(username)
//					.orElseThrow(() -> new ResourceNotFoundException("User not found", "", username));
//		} catch (ResourceNotFoundException e) {
//			return "{\"result\": \"User does not exist! \" }";
//		}
//		if (checkUsername != null && BCrypt.checkpw(password, checkUsername.getPassword())) {
//			checkUsername.setLoginStatus(true);
//			myRepository.save(checkUsername);
//			return "{\"result\": \"Login successful!\", \"username\":\"" + username + "\" }";
//		}
//
//		else if (checkUsername != null && !BCrypt.checkpw(password, checkUsername.getPassword())) {
//
//			return "{\"result\": \"Incorrect password! \" }";
//		}
//
//		return null;
//
//	}
	
//	@PostMapping("/signout")
//	public String signOut(@RequestParam("username") String username) {
//		User user = myRepository.findOneByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "Username", username));
//		user.setLoginStatus(false);
//		myRepository.save(user);
//		return "{\"result\": \"Logout successful!\"}";
//	}
	
	@GetMapping("/user")
	public String findUsers() {
		return "Hello Dale!";
	}
	
	@PostMapping("/newUser")
	public User createUser(@RequestBody @Valid User user) {
		return this.userRepo.save(user);
	}
	
	@Autowired
	UserRepo userRepo;
	
	
}