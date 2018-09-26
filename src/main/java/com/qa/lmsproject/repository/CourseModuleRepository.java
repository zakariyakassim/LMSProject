package com.qa.lmsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.model.CourseModuleModel;
import com.qa.lmsproject.model.ModuleModel;


public interface CourseModuleRepository extends JpaRepository<CourseModuleModel, Long> {
	CourseModuleModel findByCourseId(Long courseID);
	CourseModuleModel findByModuleId(Long moduleID);
	List<CourseModuleModel> findAllByCourseId(CourseModel course);
	List<ModuleModel> findAllByModuleId(List<CourseModuleModel> cmm);
}
