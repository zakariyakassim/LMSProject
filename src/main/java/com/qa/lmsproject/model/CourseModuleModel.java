package com.qa.lmsproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.repository.CourseRepository;
import com.qa.lmsproject.repository.ModuleRepository;

@Entity
@Table(name ="courseModule")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate"},allowGetters = true)
public class CourseModuleModel implements Serializable{
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "courseId", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private CourseModel courseId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "moduleId", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private ModuleModel moduleId;
		
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	

	public CourseModuleModel() {
		this.createdDate = new Date();
	}
	
	

	public CourseModuleModel(CourseModel courseId, ModuleModel moduleId) {
		this.courseId = courseId;
		this.moduleId = moduleId;
		this.createdDate = new Date();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CourseModel getCourseId() {
		return courseId;
		
	}

	public void setCourseId(CourseModel courseId) {
		this.courseId = courseId;
	}

	public ModuleModel getModuleId() {
		return moduleId;
	}

	public void setModuleId(ModuleModel moduleId) {
		this.moduleId = moduleId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	

}
