package com.qa.lmsproject.controller;

import java.util.Date;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.User;
import com.qa.lmsproject.repository.UserRepo;;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepo myRepository;

	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
		User checkUsername = null;
		
		try {
			checkUsername = myRepository.findOneByUsername(username)
					.orElseThrow(() -> new ResourceNotFoundException("User not found", "", username));
		} catch (ResourceNotFoundException e) {
			return "{\"result\": \"User does not exist! \" }";
		}
		
		

		if (checkUsername != null && BCrypt.checkpw(password, checkUsername.getPassword())) {
			checkUsername.setLoginStatus(true);
			myRepository.save(checkUsername);
			return "{\"result\": \"Login successful!\", \"username\":\"" + username + "\" }";
		}

		else if (checkUsername != null && !BCrypt.checkpw(password, checkUsername.getPassword())) {

			return "{\"result\": \"Incorrect password! \" }";
		}

		return null;

	}
	
	@PostMapping("/signout")
	public String signOut(@RequestParam("username") String username) {
		User user = myRepository.findOneByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "Username", username));
		user.setLoginStatus(false);
		myRepository.save(user);
		return "{\"result\": \"Logout successful!\"}";
	}
	
	@PostMapping("/newUser")
	public User createUser(@Valid @RequestBody User mSDM) {
		mSDM.setPassword(BCrypt.hashpw(mSDM.getPassword(), BCrypt.gensalt()));
		mSDM.setCreatedDate(new Date());
		return myRepository.save(mSDM);
	}
	


}