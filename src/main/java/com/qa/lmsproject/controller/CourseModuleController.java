package com.qa.lmsproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.model.CourseModuleModel;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.CourseModuleRepository;
import com.qa.lmsproject.repository.CourseRepository;
import com.qa.lmsproject.repository.ModuleRepository;

@RestController
@RequestMapping("/api")
public class CourseModuleController {

	@Autowired
	private CourseModuleRepository repo;
	
	@Autowired
	private CourseRepository repositoryCourse;
	
	@Autowired
	private ModuleRepository repositoryModule;
	 
	@PostMapping("/coursemodule")	
	public void AddModuleToCourse(@RequestParam("courseId") Long courseId, @RequestParam("moduleId") Long moduleId ) {
		CourseModel course = repositoryCourse.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		ModuleModel module = repositoryModule.findById(moduleId).orElseThrow(()-> new ResourceNotFoundException("module","id",moduleId));
		CourseModuleModel courseModule = new CourseModuleModel(course,module);
		repo.save(courseModule);

	}
		
    @GetMapping("/coursemodule/{courseId}")
	public String getModule(@PathVariable (value = "courseId") Long courseId) {
    	System.out.println("courseId" + courseId);
		CourseModel course = repositoryCourse.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		
		
		List<CourseModuleModel> CourseModuleModelList =  repo.findAllByCourseId(course);
		List<Long> cmmLongs = new ArrayList<Long>();
		
		
		for(CourseModuleModel i : CourseModuleModelList) {
			cmmLongs.add(i.getModuleId().getId());
		}
		JSONArray jsonArray = new JSONArray();
		JSONObject json = new JSONObject();;
		for(Long i : cmmLongs) {
			System.out.println("Where is this module "+i);
			try{
				Optional<ModuleModel> m = repositoryModule.findOneById(i);
				json.put("name",m.get().getName());
				json.put("description",m.get().getDescription());
				json.put("id",m.get().getId());
				json.put("lastModifiedDate",m.get().getLastModified());
				json.put("createDate",m.get().getCreatedDate());
				jsonArray.put(json);
			}catch(Exception e){
				System.out.println("Is there any exception");
			}
		}
		return jsonArray.toString() ;
	} 
	

}
