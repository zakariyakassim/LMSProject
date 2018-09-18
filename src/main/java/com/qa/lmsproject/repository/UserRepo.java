package com.qa.lmsproject.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.lmsproject.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	
public Optional<User> findOneByUsername(String username);
	
	
	  
	
}
