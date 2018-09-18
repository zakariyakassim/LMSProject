package com.qa.lmsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.LessonModel;

public interface LessonRepository extends JpaRepository<LessonModel,Long>{

}
