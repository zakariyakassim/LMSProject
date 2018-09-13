package webTest;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
		String extentImage = "C:\\Users\\Admin\\Documents\\Documentation\\report.png";
		
		test.log(LogStatus.PASS, "broswer opens");
		driver.get("http://localhost:3000/home");
		test.log(LogStatus.PASS, "the test was a Success");
		
		WebElement courseBtn =(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
		           courseBtn.click();
		WebElement checkItem = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.className("Courses-body")));

	try {
		assertTrue(checkItem.isDisplayed());
		test.log(LogStatus.PASS, "Went to Home page to Course page");
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Did not go to");
		}
		
	}
	
	@After
	public void shutDown() {
		report.endTest(test);
		report.flush();
		driver.quit();
	}

}
