package com.qa.lmsproject.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="moduleLesson")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate","lastModifed"},allowGetters = true)
public class ModuleLessonModel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "moduleId", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private ModuleModel moduleId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "lessonId", nullable = false)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JsonIgnore
	private LessonModel lessonId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	public ModuleLessonModel() {
		this.createdDate = new Date();
	}
	
	public ModuleLessonModel(ModuleModel moduleId, LessonModel lessonId) {
		this.moduleId = moduleId;
		this.lessonId = lessonId;
		this.createdDate = new Date();
		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public ModuleModel getModuleId() {
		return moduleId;
	}
	public void setModuleId(ModuleModel moduleId) {
		this.moduleId = moduleId;
	}
	
	public LessonModel getLessonId() {
		return lessonId;
	}
	public void setLessonId(LessonModel lessonId) {
		this.lessonId = lessonId;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
}
