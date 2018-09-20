package com.qa.lmsproject;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.qa.lmsproject.model.User;

public class UserTest {
	
	@Test
	public void testFirstName() {
		User user = new User();
		user.setFirstName("David");
		assertEquals("Incorrect first name", "David", user.getFirstName());
	}
	
	@Test
	public void testLastName() {
		User user = new User();
		user.setLastName("Rymer");
		assertEquals("Incorrect last name", "Rymer", user.getLastName());
	}
	
	@Test
	public void testUsername() {
		User user = new User();
		user.setUsername("Lob230");
		assertEquals("Incorrect username", "Lob230", user.getUsername());
	}
	
	@Test
	public void testEmailAddress() {
		User user = new User();
		user.setEmailAddress("David@Test.com");
		assertEquals("Incorrect email address", "David@Test.com", user.getEmailAddress());
		
	}
	
	@Test
	public void testPassword() {
		User user = new User();
		user.setPassword("password");
		assertEquals("Incorrect password", "password", user.getPassword());
	}
	
	@Test
	public void testCreatedDate() {
		User user = new User();
		user.setCreatedDate(new Date());
		assertEquals("Incorrect created date", new Date(), user.getCreatedDate());
	}
	
	@Test
	public void testType() {
		User user = new User();
		user.setType("SYSADMIN");
		assertEquals("Incorrect user type", "SYSADMIN", user.getType());
	}
	
	@Test
	public void testLoginStatus() {
		User user = new User();
		user.setLoginStatus(true);
		assertEquals("Incorrect login status", true, user.isLoginStatus());
	}
	
	@Test
	public void testEnabled() {
		User user = new User();
		user.setEnabled(true);
		assertEquals("User has not been enabled correctly", true, user.isEnabled());
	}
	
	@Test
	public void testSuspendedUntil() {
		User user = new User();
		Date date = new Date();
		user.setSuspendedUntil(date);
		assertEquals("Incorrect suspension date", date, user.getSuspendedUntil());
	}
	
	
	
	

}
