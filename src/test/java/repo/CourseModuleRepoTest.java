package repo;



import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.lmsproject.LmsprojectApplication;
import com.qa.lmsproject.model.CourseModel;
import com.qa.lmsproject.model.CourseModuleModel;
import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.CourseModuleRepository;
import com.qa.lmsproject.repository.LessonRepository;
import com.qa.lmsproject.repository.ModuleRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@DataJpaTest
public class CourseModuleRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CourseModuleRepository courseModuleRepo;
	
	@Test
	public void retriveByIdTest() {
		CourseModel course = new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!");
		entityManager.persist(course);
		ModuleModel module = new ModuleModel("Drop Top","Flip flop");
		entityManager.persist(module);
		CourseModuleModel courseModule = new CourseModuleModel(course, module);
		entityManager.persist(courseModule);
		entityManager.flush(); 
		assertTrue(courseModuleRepo.findById(courseModule.getId()).isPresent());
	}
}
