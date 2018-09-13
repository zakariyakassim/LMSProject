package webTest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
	static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
	}
	
	@Before
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openQCSite() throws InterruptedException {
		driver.get("http://localhost:3000/home");
	 
	}
	
	@After
	public void shutDown() {
		driver.quit();
	}

}
