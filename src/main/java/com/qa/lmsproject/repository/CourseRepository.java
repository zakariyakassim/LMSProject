package com.qa.lmsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel,Long>{

}
