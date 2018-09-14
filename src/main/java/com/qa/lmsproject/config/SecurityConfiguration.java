package com.qa.lmsproject.config;

import java.util.Collection;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.qa.lmsproject.model.User;
import com.qa.lmsproject.repository.UserRepo;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		
	  auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery(
			"select username,password, enabled from user where username=?")
		.authoritiesByUsernameQuery(
			"select username, type from user where username=?");
	  
//	  List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//	  authorities.add(new SimpleGrantedAuthority("SYSADMIN"));
//
//	  UserDetails user = new org.springframework.security.core.userdetails.User("user@example.com", passwordEncoder.encode("s3cr3t"), authorities);
//
//	  userDetailsManager.createUser(user);
//	  Create a UsernamePasswordAuthenticationToken
//
//	  Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
//	  Add the Authentication to the SecurityContext
//
//	  SecurityContextHolder.getContext().setAuthentication(authentication);
	}	
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//	  http.authorizeRequests()
//		.antMatchers("/hello").access("hasRole('ROLE_ADMIN')")		
//		.anyRequest().permitAll()
//		.and()
//		  .formLogin().loginPage("/login")
//		  .usernameParameter("username").passwordParameter("password")
//		.and()
//		  .logout().logoutSuccessUrl("/login?logout")	
//		 .and()
//		 .exceptionHandling().accessDeniedPage("/403")
//		.and()
//		  .csrf();
//	}
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests().regexMatchers(".*api.*").fullyAuthenticated().and()
				// .addFilterBefore(customFilter(), BasicAuthenticationFilter.class)
				.formLogin().loginPage("/login").loginProcessingUrl("/login/processing");
		httpSecurity.csrf().disable();
	}
}
