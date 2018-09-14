package com.qa.lmsproject;

import static org.junit.Assert.assertTrue;

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
	
	@Before
	public void clearDB() {
		userRepo.deleteAll();
	}

	@Test
	public void testFindByOneUsername() {
		User user = new User("David", "Rymer", "DRymer", "password", "SYSADMIN", "test.test@test.com");
		entityManager.persist(user);
		entityManager.flush();
		assertTrue("User not found", userRepo.findOneByUsername(user.getUsername()).isPresent());
	}
}
