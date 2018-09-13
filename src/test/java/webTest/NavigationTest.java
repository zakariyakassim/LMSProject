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

import junit.framework.TestResult;

public class NavigationTest {
	
	static ExtentTest test;
	static ExtentReports report;
	static WebDriver driver;
	static String webAddress;
	
	@BeforeClass
	public static void init(TestResult result) {
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
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\Documentation\\report.html",true);
		test = report.startTest("Navigation Test");
		test.log(LogStatus.PASS, "broswer opens");
		driver.get("http://localhost:3000/home");
		test.log(LogStatus.PASS, "the test was a Success");
		try {
		WebElement courseBtn =(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"navigation\"]/div/ul/li[2]/a")));
		           courseBtn.click();
		assertTrue(courseBtn.isDisplayed());
		test.log(LogStatus.PASS, "Test was a Success");
		
		}catch(AssertionError ar) {
			test.log(LogStatus.FAIL, "Button is not ");
		}
		WebElement checkItem = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.className("Courses-body")));
		assertTrue(checkItem.isDisplayed());
		
				
	}
	
	@After
	public void shutDown() {
		driver.quit();
		report.flush();
	}

}
