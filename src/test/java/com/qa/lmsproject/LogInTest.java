package com.qa.lmsproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.User;
import com.qa.lmsproject.repository.UserRepo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { LmsprojectApplication.class })
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureMockMvc
public class LogInTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private MockMvc mvc;
	
	@Before
	public void clearDB() {
		userRepo.deleteAll();
	}
	
	@Test
	public void testSignOut() throws Exception {
		userRepo.save(new User("David", "Rymer", "DRymer", "password", "SYSADMIN"));
		User user = userRepo.findOneByUsername("DRymer").orElseThrow(() -> new ResourceNotFoundException("User", "Username", "DRymer"));
		user.setLoginStatus(true);
		userRepo.save(user);
		mvc.perform(MockMvcRequestBuilders.get("/api/signout")).andExpect(status().isOk());
		user = userRepo.findOneByUsername("DRymer").orElseThrow(() -> new ResourceNotFoundException("User", "Username", "DRymer"));
		assertEquals("User not successfully logged out", false, user.isLoginStatus());
	}
	
	@Test
	public void testSignIn() {
		userRepo.save(new User("David", "Rymer", "DRymer", "password", "SYSADMIN"));
		try {
			mvc.perform(MockMvcRequestBuilders.get("/api/user")).andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindById() {
		User user = new User("David", "Rymer", "DRymer", "password", "SYSADMIN");
		entityManager.persist(user);
		entityManager.flush();
		assertTrue("Repository not successfully created", userRepo.findById(user.getId()).isPresent());
	}
	
	@Test
	public void testFindByOneUsername() {
		User user = new User("David", "Rymer", "DRymer", "password", "SYSADMIN");
		entityManager.persist(user);
		entityManager.flush();
		assertTrue("User not found", userRepo.findOneByUsername(user.getUsername()).isPresent());
	}
}
