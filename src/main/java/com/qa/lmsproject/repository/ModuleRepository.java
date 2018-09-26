package com.qa.lmsproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.lmsproject.model.ModuleModel;

public interface ModuleRepository extends JpaRepository<ModuleModel,Long>{

	ModuleModel findOneById(Long i);


}
