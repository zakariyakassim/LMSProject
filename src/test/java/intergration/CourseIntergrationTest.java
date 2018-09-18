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
import com.qa.lmsproject.repository.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@AutoConfigureMockMvc
public class CourseIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private CourseRepository repo;
	
//	@After
//	public void clearDB() {
//		repo.deleteAll();
//	}
	
	@Test
	public void findingAndRetrivingFromDatabase()
		throws Exception{
		repo.save(new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!"));
		mvc.perform(get("/api/course")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status() 
		.isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name", is("Ifty's farm yard animals")));
	}
	
	@Test
	public void createCourseTest()
			throws Exception{
			mvc.perform(MockMvcRequestBuilders.post("/api/course")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"name\" : \"Ifty's farm yard animals\", \"description\" : \"Come along and join Ifty for some family fun!\"}"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name", is("Ifty's farm yard animals")));
	}
	
	@Test
	public void deleteCourseTest()
			throws Exception{
			CourseModel course = new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!");
			repo.save(course);
			System.out.println("ID: " + course.getId());
			mvc.perform(MockMvcRequestBuilders.delete("/api/course/" + course.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			System.out.println("ID: " + course.getId());
	}
	
	@Test
	public void updateCourseTest() throws Exception {
		CourseModel course = new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!");
		repo.save(course);
		mvc.perform(MockMvcRequestBuilders.put("/api/course/" + course.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"James farm yard animals\", \"description\" : \"Come along and join James for some family fun!\"}"))
				.andExpect(status()
				.isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("James farm yard animals")));
	}
	
	@Test
	public void findCourseReg() throws Exception {
		repo.save(new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!"));
		mvc.perform(get("/api/course/ifty")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status() 
		.isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name", is("Ifty's farm yard animals")));
	}

}
