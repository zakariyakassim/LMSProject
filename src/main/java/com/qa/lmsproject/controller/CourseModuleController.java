package com.qa.lmsproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addCourseAndModule")
	public void addCourseAndModule(@RequestBody String string ){
		JSONObject json = null;
		try {
			json = new JSONObject(string);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		CourseModel course = null;
		try {
			course = new CourseModel(json.getString("name"),json.getString("description"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		repositoryCourse.save(course);
		try {
			for(int i = 0; i < json.getJSONArray("modules").length();i++) {
				ModuleModel module = new ModuleModel(json.getJSONArray("modules").getJSONObject(i).getString("name"), json.getJSONArray("modules").getJSONObject(i).getString("description"));
				repositoryModule.save(module);
				CourseModuleModel courseModule = new CourseModuleModel(course,module);
				repo.save(courseModule);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	@PostMapping("/coursemodule")	
	public void addModuleToCourse(@RequestParam("courseId") Long courseId, @RequestParam("moduleId") Long moduleId ) {
		CourseModel course = repositoryCourse.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		ModuleModel module = repositoryModule.findById(moduleId).orElseThrow(()-> new ResourceNotFoundException("module","id",moduleId));
		CourseModuleModel courseModule = new CourseModuleModel(course,module);
		repo.save(courseModule);

	}
	@CrossOrigin(origins = "http://localhost:3000")	
    @GetMapping("/coursemodule/{courseId}")
	public String getModule(@PathVariable (value = "courseId") Long courseId) {
		CourseModel course = repositoryCourse.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","id",courseId));
		
		
		List<CourseModuleModel> CourseModuleModelList =  repo.findAllByCourseId(course);
		List<Long> cmmLongs = new ArrayList<Long>();
		
		
		for(CourseModuleModel i : CourseModuleModelList) {
			cmmLongs.add(i.getModuleId().getId());
		}
		
		JSONArray jsonArray = new JSONArray();
		JSONObject json;
		for(Long i : cmmLongs) {
			try{
				json = new JSONObject();
				ModuleModel m = repositoryModule.findOneById(i);
				json.put("name",m.getName());
				json.put("description",m.getDescription());
				json.put("id",m.getId());
				json.put("lastModifiedDate",m.getLastModified());
				json.put("createDate",m.getCreatedDate());
				jsonArray.put(json);
			}catch(Exception e){
				System.out.println("There any exception");
			}
		}
		return jsonArray.toString() ;
	}
	
	 @CrossOrigin(origins = "http://localhost:3000")
	 @GetMapping("/coursemodule")
	 public String getAllCourseModules(){

		JSONArray jsonArray = new JSONArray();
		JSONObject json;
		List<CourseModel> allCourseModels = repositoryCourse.findAll();
		for(CourseModel i : allCourseModels) {
			try{
				json = new JSONObject();
				json.put("name",i.getName());
				json.put("description",i.getDescription());
				json.put("id",i.getId());
				json.put("lastModifiedDate",i.getLastModified());
				json.put("createDate",i.getCreatedDate());
				json.put("modules", getModule(i.getId()));
				jsonArray.put(json);
			}catch(Exception e){
				System.out.println("There any exception");
			}
		}
		return jsonArray.toString() ;
	}

}
