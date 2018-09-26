package com.qa.lmsproject.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.repository.LessonRepository;

@RestController
@RequestMapping("/api")
public class LessonController {
	@Autowired
	LessonRepository repo;
	
	@PostMapping("/lesson")
	public LessonModel createCourse(@Valid @RequestBody LessonModel mSDM) {
		LessonModel lesson = new LessonModel(mSDM.getName(), mSDM.getContent());
		return repo.save(lesson);
	}
	
	@GetMapping("/lesson")
	public List<LessonModel> getAllLessons(){
		return repo.findAll();
	}
	
	@DeleteMapping("/lesson/{id}")
	public ResponseEntity<?> deleteLesson(@PathVariable(value = "id")Long lessonId){
		LessonModel mSDM = repo.findById(lessonId).orElseThrow(()-> new ResourceNotFoundException("lesson","id",lessonId));
		repo.delete(mSDM);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/lesson/{id}")
	public LessonModel updateLesson(@PathVariable(value = "id") Long lessonId, @Valid @RequestBody LessonModel lessonDetails) {
		
		LessonModel mSDM = repo.findById(lessonId).orElseThrow(()-> new ResourceNotFoundException("Lesson","id",lessonId));
		mSDM.setName(lessonDetails.getName());
		mSDM.setDifficulty(lessonDetails.getDifficulty());
		mSDM.setTrainerName(lessonDetails.getTrainerName());
		mSDM.setLastModified(new Date());
		LessonModel updateLesson = repo.save(mSDM);
		return updateLesson;
	}
}
