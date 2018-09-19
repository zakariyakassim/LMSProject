package com.qa.lmsproject.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

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
				.authoritiesByUsernameQuery("select username, type from user where username=?");
	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	//
	// http.authorizeRequests()
	// .antMatchers("/hello").access("hasRole('ROLE_ADMIN')")
	// .anyRequest().permitAll()
	// .and()
	// .formLogin().loginPage("/login")
	// .usernameParameter("username").passwordParameter("password")
	// .and()
	// .logout().logoutSuccessUrl("/login?logout")
	// .and()
	// .exceptionHandling().accessDeniedPage("/403")
	// .and()
	// .csrf();
	// }

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests().regexMatchers(".*api.*").permitAll().and().httpBasic();
		httpSecurity.csrf().disable();
	}
}
