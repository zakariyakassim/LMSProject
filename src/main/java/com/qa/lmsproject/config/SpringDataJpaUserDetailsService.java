package com.qa.lmsproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.qa.lmsproject.model.User;
import com.qa.lmsproject.repository.UserRepo;

@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

	private final UserRepo repository;

	@Autowired
	public SpringDataJpaUserDetailsService(UserRepo repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = this.repository.findByUsername(name);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getType()));
	}
	
}