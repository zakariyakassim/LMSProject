package webTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class NavigationTest {
	
	static ExtentTest test;
	static ExtentReports report;
	static WebDriver driver;
	
	
	@BeforeClass
	public static void init() {
		System.out.println("on test start");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver.exe");
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Documentation\\report.html",true);
		
	}
	
	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void testAddCoursesBtn() {
		test = report.startTest("Add Course Test");
		
		driver.get("http://localhost:3000/AddCourse");
		test.log(LogStatus.PASS, "Open broswer to the Add Courses page");
		
		WebElement courseTitle = (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.id("formCourse")));
		           courseTitle.click();
		           courseTitle.sendKeys("Java Programming");
		try {
			assertTrue(courseTitle.isDisplayed());
			test.log(LogStatus.PASS, "Inserted Course title");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Could not insert into the course title");
		}
		
		WebElement courseDescript= (new WebDriverWait(driver,5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"formAbout\"]")));
		courseDescript.click();
		courseDescript.sendKeys("Java Programming description testing");
		try {
			assertTrue(courseDescript.isDisplayed());
			test.log(LogStatus.PASS, "Inserted Course description");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Could not insert into the course description");
		}
		
		WebElement courseModule= (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addCourse-form-container\"]/div[3]/div/input")));
		courseModule.click();
		courseModule.sendKeys("Java");
		try {
			assertTrue(courseModule.isDisplayed());
			test.log(LogStatus.PASS, "Inserted Course Module title");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Could not insert into the module");
		}
		WebElement courseModuleBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addCourse-form-container\"]/div[3]/div/button")));
		           courseModuleBtn.click();
		WebElement moduleTitleCheck = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("add-module-table")));

		try {
		   	assertTrue(moduleTitleCheck.isDisplayed());
		   	test.log(LogStatus.PASS, "Clicked the module button to add the Java module and is being displayed on the page ");
		 }catch(AssertionError ar) {
		   		test.log(LogStatus.FAIL, "Module is not being displayed ");
		 }
		WebElement courseSubmiteBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addCourse-form-container\"]/div[4]/button")));
		courseSubmiteBtn.click();
	
	}
	
	@Test
	public void testNavigation() {
		test = report.startTest("Navigation Test");
		
		driver.get("http://localhost:3000/");
        test.log(LogStatus.PASS, "The Browser opens to the home page ");
		
		WebElement courseBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
		           courseBtn.click();
		WebElement checkItem = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/section/div/p")));

	try {
		assertTrue(checkItem.isDisplayed());
		test.log(LogStatus.PASS, "Can click on the courses button and verify that its looking at the courses page");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Did not go to course page");
		}
	    WebElement accountBtn =(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"nav-dropdown\"]")));
	               accountBtn.click();
	    WebElement addCourseBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("add-course")));
	               addCourseBtn.click();
	    
	    WebElement checkaddCourse = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("addCourse-form-container")));
	try {
		assertTrue(checkaddCourse.isDisplayed());
		test.log(LogStatus.PASS, "Can go into the add courses page under the Account navigation dropDown menu");
	}catch(AssertionError ar) {
		test.log(LogStatus.FAIL, "The add course button could not be found or does not exist ");
	}
	     WebElement homeBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
                    homeBtn.click();
         WebElement checkHome = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
	try {
		assertTrue (checkHome.isDisplayed());
		test.log(LogStatus.PASS, "Was able to get back to the home page and verify its in the home Page Component");
	}catch(AssertionError ar) {
		test.log(LogStatus.FAIL, "Was unable to locate the Home component to verify that we got back to the home Page");
	}
	}
	
	@Test
	public void siteName(){
		test = report.startTest("Site Name Test");
		
		driver.get("http://localhost:3000/");
		test.log(LogStatus.PASS, "broswer opens");
	
		WebElement title = driver.findElement(By.xpath("//*[@id=\"navigation\"]/div/ul[1]/a"));
		try {
			assertTrue(title.isDisplayed());
			test.log(LogStatus.PASS, "'QC Tutorials' is beng displayed");
			}catch(AssertionError ar) {
				test.log(LogStatus.FAIL, "Site name not being recognised");
			}
	}
	
	
	@After
	public void shutDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
