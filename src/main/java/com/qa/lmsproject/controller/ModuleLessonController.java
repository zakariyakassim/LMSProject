package com.qa.lmsproject.controller;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.lmsproject.exception.ResourceNotFoundException;
import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.model.ModuleLessonModel;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.LessonRepository;
import com.qa.lmsproject.repository.ModuleLessonRepository;
import com.qa.lmsproject.repository.ModuleRepository;

@RestController
@RequestMapping("/api")
public class ModuleLessonController {
	
	@Autowired
	private ModuleLessonRepository repo;
	
	@Autowired
	private ModuleRepository repoModule;
	
	@Autowired
	private LessonRepository repoLesson;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/addLesson")
	public void addLesson(@RequestBody String string) {
		JSONObject json = null;
		try {
			json = new JSONObject(string);
		     }catch(JSONException event) {
			   event.printStackTrace();
		  }
		LessonModel lesson = null;
		try {
			lesson = new LessonModel(json.getString("name"),json.getString("content"));
			
		}catch (JSONException event) {
			event.printStackTrace();
		}
		repoLesson.save(lesson);
		try {
			for(int i = 0; i < json.getJSONArray("module").length();i++) {
				ModuleModel module = new ModuleModel(json.getJSONArray("module").getJSONObject(i).getString("name"), json.getJSONArray("module").getJSONObject(i).getString("content"));
				repoModule.save(module);
				ModuleLessonModel ModuleLesson = new ModuleLessonModel(module,lesson);
				repo.save(ModuleLesson);
			}
			}catch (JSONException event) {
					event.printStackTrace();
		}
	}
	
	
	@PostMapping("/lessonModule")
	public void addLessonToModule(@RequestParam("moduleId") Long moduleId, @RequestParam("lessonId") Long lessonId) {
		LessonModel lesson = repoLesson.findById(lessonId).orElseThrow(()-> new ResourceNotFoundException("lesson","id",lessonId));
		ModuleModel module = repoModule.findById(moduleId).orElseThrow(()-> new ResourceNotFoundException("module","id",moduleId));
		ModuleLessonModel moduleLesson = new ModuleLessonModel(module,lesson);
		repo.save(moduleLesson);
	}
	
	
	@CrossOrigin(origins = "Http://localhost:8080")
	@GetMapping("/lessonModule/{lessonId}")
	public String getLesson(@PathVariable (value ="lessonId") Long lessonId) {
		LessonModel lesson = repoLesson.findById(lessonId).orElseThrow(()-> new ResourceNotFoundException("lesson","id",lessonId));
		
		List<ModuleLessonModel> ModuleLessonModelList = repo.findAllByLessonId(lesson);
		List<Long> mLMLong = new ArrayList<Long>();
		
		for(ModuleLessonModel l : ModuleLessonModelList) {
			mLMLong.add(l.getModuleId().getId());
		}
		
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		for (Long l : mLMLong ) {
			try {
				LessonModel lm = repoLesson.findOneById(l);
				jsonObject.put("name",  lm.getName());
				jsonObject.put("qa",  lm.getQa());
				jsonObject.put("trainerName",  lm.getTrainerName());
				jsonObject.put("duration",  lm.getDuration());
				jsonObject.put("difficulty",  lm.getDifficulty());
				jsonObject.put("content",  lm.getContent());
				jsonObject.put("lastModifiedDate",lm.getLastModified());
				jsonObject.put("createDate",lm.getCreatedDate());
				jsonArray.put(jsonObject);
			}catch(Exception event){
				System.out.println("There was an exception with the jsonObject and JsonArray");
			}
		}
			return jsonArray.toString();
	}
		
	
	}