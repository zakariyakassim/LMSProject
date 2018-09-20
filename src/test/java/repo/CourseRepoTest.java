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
import com.qa.lmsproject.repository.CourseRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@DataJpaTest
public class CourseRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Test
	public void retriveByIdTest() {
		CourseModel model = new CourseModel("Ifty's farm yard animals","Come along and join Ifty for some family fun!");
		entityManager.persist(model);
		entityManager.flush(); 
		assertTrue(courseRepo.findById(model.getId()).isPresent());
	}

}
