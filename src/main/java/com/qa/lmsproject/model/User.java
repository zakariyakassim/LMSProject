package com.qa.lmsproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdDate" }, allowGetters = true)
public class User implements Serializable {

	public User() {
	}

	public User(String firstName, String lastName, String username, String password, String type, String emailAddress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.type = type;
		this.emailAddress = emailAddress;
	}

	@Id
	private String username;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String emailAddress;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private boolean enabled;

	// @Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;

	@Column(nullable = false)
	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	private Date suspendedUntil;

	@Column(nullable = false)
	private boolean loginStatus;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getSuspendedUntil() {
		return suspendedUntil;
	}

	public void setSuspendedUntil(Date suspendedUntil) {
		this.suspendedUntil = suspendedUntil;
	}

	public boolean isLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
