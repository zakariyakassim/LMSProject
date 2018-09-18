package com.qa.lmsproject.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.model.CourseModuleModel;
import com.qa.lmsproject.model.ModuleModel;

public interface ModuleRepository extends JpaRepository<ModuleModel,Long>{

	ModuleModel findOneById(Long i);


}
