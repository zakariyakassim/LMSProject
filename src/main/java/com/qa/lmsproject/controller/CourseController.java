package com.qa.lmsproject.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.repository.CourseRepository;

@RestController
@RequestMapping("/api")
public class CourseController {
	@Autowired
	CourseRepository repo;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/course")
	public CourseModel createCourse(@Valid @RequestBody CourseModel mSDM) {
		CourseModel course = new CourseModel(mSDM.getName(),mSDM.getDescription());
		return repo.save(course);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/course")
	public List<CourseModel> getAllCourses(){
		System.out.println("this is seDKFEKKF");
		return repo.findAll();
	}
	
	@GetMapping("/course/{name}")
	public List<CourseModel> getCourseByName(@PathVariable(value = "name") String name){
		return repo.findUserReg(name);
	}
	

	
	@DeleteMapping("/course/{id}")
	public ResponseEntity<?> deleteCourse(@PathVariable(value = "id")Long courseId){
		CourseModel mSDM = repo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		repo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/course/{id}")
	public CourseModel updateCourse(@PathVariable(value = "id") Long courseId, @Valid @RequestBody CourseModel courseDetails) {
		
		CourseModel mSDM = repo.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		mSDM.setName(courseDetails.getName());
		mSDM.setDescription(courseDetails.getDescription());
		mSDM.setApproved(courseDetails.isApproved());
		mSDM.setLastModified();
		CourseModel updateCourse = repo.save(mSDM);
		return updateCourse;
	}
}
