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
import com.qa.lmsproject.model.ModuleModel;
import com.qa.lmsproject.repository.ModuleRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LmsprojectApplication.class})
@DataJpaTest
public class ModuleRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ModuleRepository moduelRepo;
	
	@Test
	public void retriveByIdTest() {
		ModuleModel model = new ModuleModel("Drop Top","Flip flop");
		entityManager.persist(model);
		entityManager.flush(); 
		assertTrue(moduelRepo.findById(model.getId()).isPresent());
	}
	
}
