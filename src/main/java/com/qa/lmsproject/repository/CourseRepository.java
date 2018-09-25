package com.qa.lmsproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qa.lmsproject.model.CourseModel;

public interface CourseRepository extends JpaRepository<CourseModel,Long>{
	
//	public List<CourseModel> findByName(String name);
	
	@Query(value = "SELECT * FROM course WHERE name LIKE %:name% ORDER BY last_modified DESC" , 
			  nativeQuery = true)
			List<CourseModel> findUserReg(@Param("name") String name);
}
