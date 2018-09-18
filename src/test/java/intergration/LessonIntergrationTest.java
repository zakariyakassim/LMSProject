package intergration;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.repository.CourseRepository;
import com.qa.lmsproject.repository.LessonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@AutoConfigureMockMvc
public class LessonIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private LessonRepository repo;
	
//	@After
//	public void clearDB() {
//		repo.deleteAll();
//	}
	
	@Test
	public void findingAndRetrivingFromDatabase()
		throws Exception{
		repo.save(new LessonModel("TestLessonName", "Easy", "Mr Wood"));
		mvc.perform(get("/api/lesson")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status() 
		.isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name", is("TestLessonName")));
	}
	
	@Test
	public void createLessonTest()
			throws Exception{
			mvc.perform(MockMvcRequestBuilders.post("/api/lesson")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"name\" : \"TestLesson\", \"difficulty\" : \"Easy\", \"trainerName\" : \"Mr White\"}"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name", is("TestLesson")));
	}
	
	@Test
	public void deleteLessonTest()
			throws Exception{
			LessonModel lesson = new LessonModel("TestLessonName", "Easy", "Mr Wood");
			repo.save(lesson);
			System.out.println("ID: " + lesson.getId());
			mvc.perform(MockMvcRequestBuilders.delete("/api/lesson/" + lesson.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			System.out.println("ID: " + lesson.getId());
	}
	
	@Test
	public void updateLessonTest() throws Exception {
		LessonModel lesson = new LessonModel("TestLessonName", "Easy", "Mr Wood");
		repo.save(lesson);
		mvc.perform(MockMvcRequestBuilders.put("/api/lesson/" + lesson.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"TestLesson\", \"difficulty\" : \"Easy\", \"trainerName\" : \"Mr White\"}"))
				.andExpect(status()
				.isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("TestLesson")));
	}
}
