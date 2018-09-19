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
	public void homeToCoursePage() {
		test = report.startTest("Navigation Test");
		
		driver.get("http://localhost:3000/");
        test.log(LogStatus.PASS, "The Browser opens");
		
		WebElement courseBtn = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
		           courseBtn.click();
		WebElement checkItem = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/section/div/p")));

	try {
		assertTrue(checkItem.isDisplayed());
		test.log(LogStatus.PASS, "Can click on the navigation courses button and move to the courses page");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Did not go to course page");
		}
	    WebElement addCourseBtn =(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul[3]/li[3]/ul/li/a")));
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
		test.log(LogStatus.PASS, "Selenium test was able to get back to the home page and verify its in the home Page Component");
	}catch(AssertionError ar) {
		test.log(LogStatus.FAIL, "Was unable to locate the Home component to verify that we got back to the home Page");
	}
	}
	
	@After
	public void shutDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
