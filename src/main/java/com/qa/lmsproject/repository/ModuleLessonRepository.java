package com.qa.lmsproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.model.ModuleLessonModel;
import com.qa.lmsproject.model.ModuleModel;


public interface ModuleLessonRepository extends JpaRepository<ModuleLessonModel, Long> {
	ModuleLessonModel findByLessonId(LessonModel lessonID);
	ModuleLessonModel findByModuleId(ModuleModel moduleID);
	List<ModuleLessonModel> findAllByLessonId(LessonModel lesson);
	List<ModuleModel> findAllByModuleId(List<ModuleLessonModel> mln);
}
