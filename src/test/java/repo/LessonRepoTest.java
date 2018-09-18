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
import com.qa.lmsproject.model.LessonModel;
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.LessonRepository;
import com.qa.lmsproject.repository.ModuleRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@DataJpaTest
public class LessonRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private LessonRepository lessonRepo;
	
	@Test
	public void retriveByIdTest() {
		LessonModel model = new LessonModel("TestLessonName", "Easy", "Mr Wood");
		entityManager.persist(model);
		entityManager.flush(); 
		assertTrue(lessonRepo.findById(model.getId()).isPresent());
	}
}
