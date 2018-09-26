package com.qa.lmsproject;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.qa.lmsproject.model.LessonModel;

public class LessonTest {
	
	@Test
	public void testLessonName() {
		LessonModel lesson = new LessonModel();
		lesson.setName("Java introduction");
		assertEquals("No Lesson by that name",lesson.getName());
	}
	
	@Test
	public void testLessonContent() {
		LessonModel lesson = new LessonModel();
		lesson.setContent("The two-part Introduction to Java programming tutorial is meant for software developers");
		assertEquals("No lesson content can be found",lesson.getContent());
	}
	
	@Test
	public void testLessonDuration() {
		LessonModel lesson = new LessonModel();
		lesson.setDuration(50);
		assertEquals("No duration avliable for the lesson",lesson.getDuration());
	}
	
	@Test
	public void testLessonDifficulty() {
		LessonModel lesson = new LessonModel();
		lesson.setDifficulty("Beginer");
		assertEquals("Lesson difficult is not set",lesson.getDifficulty());
	}
	
	@Test
	public void testLessonTrainerName() {
		LessonModel lesson = new LessonModel();
		lesson.setTrainerName("Kristoher Duff");
		assertEquals("No trainer name currently present", lesson.getTrainerName());
	}
	
	@Test
	public void testLessonQa() {
		LessonModel lesson = new LessonModel();
		lesson.setQa("QA");
		assertEquals("No QA currently being used",lesson.getQa());
	}
	

}
