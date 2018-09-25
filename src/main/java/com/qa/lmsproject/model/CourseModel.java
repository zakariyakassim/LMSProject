package com.qa.lmsproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="course")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate","lastModifed"},allowGetters = true)
public class CourseModel implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.TABLE)
	private Long Id;
	
	@NotBlank
	private String name;
	
	private String description;
	
	private boolean approved;
	
//	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	
	//@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date lastModified;
	
	public CourseModel() {
		super();
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}


	public Date getLastModified() {
		return lastModified;
	}


	public void setLastModified() {
		this.lastModified = new Date();
	}


	public CourseModel(String name, String description) {
		this.name = name;
		this.description = description;
		this.lastModified = new Date();
		this.createdDate = new Date();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Long getId() {
		return Id;
	}
	
	
}
