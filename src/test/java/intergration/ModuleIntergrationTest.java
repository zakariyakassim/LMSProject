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
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.CourseRepository;
import com.qa.lmsproject.repository.ModuleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@AutoConfigureMockMvc
public class ModuleIntergrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ModuleRepository repo;
	
//	@After
//	public void clearDB() {
//		repo.deleteAll();
//	}
	
	@Test
	public void findingAndRetrivingFromDatabase()
		throws Exception{
		repo.save(new ModuleModel("Drop Top","Flip Flop"));
		mvc.perform(get("/api/module")
		.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status() 
		.isOk())
		.andExpect(content()
		.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name", is("Drop Top")));
	}
	
	@Test
	public void createModuleTest()
			throws Exception{
			mvc.perform(MockMvcRequestBuilders.post("/api/module")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"name\" : \"Ifty's farm yard animals\", \"description\" : \"Come along and join Ifty for some family fun!\"}"))
			.andExpect(status()
			.isOk())
			.andExpect(content()
			.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.name", is("Ifty's farm yard animals")));
	}
	@Test
	public void deleteModuleTest()
			throws Exception{
			ModuleModel module = new ModuleModel("Drop Top","Flip Flop");
			repo.save(module);
			System.out.println("ID: " + module.getId());
			mvc.perform(MockMvcRequestBuilders.delete("/api/module/" + module.getId())
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
			System.out.println("ID: " + module.getId());
	}
	
	@Test
	public void updateModuleTest() throws Exception {
		ModuleModel module = new ModuleModel("Drop Top","Flip Flop");
		repo.save(module);
		mvc.perform(MockMvcRequestBuilders.put("/api/module/" + module.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\" : \"Please Stop\", \"description\" : \"James need to stop saying Drop Top\"}"))
				.andExpect(status()
				.isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name", is("Please Stop")));
	}

}
