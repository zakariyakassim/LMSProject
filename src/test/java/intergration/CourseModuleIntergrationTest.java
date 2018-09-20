package intergration;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.qa.lmsproject.LmsprojectApplication;
import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.model.CourseModuleModel;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.CourseModuleRepository;
import com.qa.lmsproject.repository.CourseRepository;
import com.qa.lmsproject.repository.ModuleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@AutoConfigureMockMvc
public class CourseModuleIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private CourseModuleRepository repo;
	
	@Autowired
	private ModuleRepository moduleRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
//	@After
//	public void clearDB() {
//		repo.deleteAll();
//		moduleRepo.deleteAll();
//		courseRepo.deleteAll();
//	}
	

	
	@Test
	public void addingToDatabase()
		throws Exception{
		CourseModel course = new CourseModel("addingtodatabaseCourseName","addingtodatabaseCourseName");
		courseRepo.save(course);
		
		ModuleModel module = new ModuleModel("addingtodatabaseName","addingtodatabaseName");
		moduleRepo.save(module);

		mvc.perform(post("/api/coursemodule")
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			.param("courseId",course.getId().toString())
			.param("moduleId",module.getId().toString()))
			.andExpect(status() 
			.isOk());
	}
	
	@Test
	public void gettingData()
		throws Exception{
		CourseModel course = new CourseModel("TestName","TestDescription");
		ModuleModel module = new ModuleModel("TestName2","TestDescriuption2");
		CourseModuleModel courseModule = new CourseModuleModel(course,module);
		courseRepo.save(course);
		moduleRepo.save(module);
		repo.save(courseModule);
		mvc.perform(get("/api/coursemodule/"+courseModule.getCourseId().getId())
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status() 
		.isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.ALL_VALUE))
		.andExpect(jsonPath("$[0].name", is("TestName2")));
		
	}


}
