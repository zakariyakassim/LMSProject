package webTest;



import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SiteName {
	
	static ExtentTest test;
	static ExtentReports report;
	static WebDriver driver;
	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Documentation\\report.html",true);
	}
	
	@Before
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void siteName() throws InterruptedException {
		test = report.startTest("Site Name Test");
		driver.get("http://localhost:3000/home");
		
		WebElement title = driver.findElement(By.xpath("//*[@id=\"navigation\"]/div/a"));
		assertTrue(title.isDisplayed());
	}
	
	
	@After
	public void shutDown() {
		driver.quit();
	}

}

