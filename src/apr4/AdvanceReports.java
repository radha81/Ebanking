package apr4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class AdvanceReports {
WebDriver driver;
ExtentReports reports;
ExtentTest logger;
@BeforeTest
public void generateReports()
{
	//define path of html reports
	reports = new ExtentReports("./ExtentReports/Demo.html");
}
@BeforeMethod
public void setUp()
{
	driver = new  FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("https://google.com");
}
@Test
public void passTest()
{
	//start your test
	logger = reports.startTest("My Pass Test");
	logger.assignAuthor("Ranga");
	String Expected ="google";
	String Actual = driver.getTitle();
	if(Expected.equalsIgnoreCase(Actual))
	{
	logger.log(LogStatus.PASS, "Title is Matching::"+Expected+"======="+Actual);	
	}
	else
	{
		logger.log(LogStatus.FAIL, "Title is Not Matching::"+Expected+"======="+Actual);	
	}
}
@Test
public void failTest()
{
	//statr test 
	logger = reports.startTest("My Fail Test");
	logger.assignAuthor("Ranga");
	String Expected ="Gmail";
	String Actual = driver.getTitle();
	if(Expected.equalsIgnoreCase(Actual))
	{
		logger.log(LogStatus.PASS, "Title is Matching::"+Expected+"======="+Actual);
	}
	else
	{
		logger.log(LogStatus.FAIL, "Title is Not Matching::"+Expected+"======="+Actual);	
	}
}
@AfterMethod
public void tearDown()
{
	reports.endTest(logger);
	reports.flush();
	driver.quit();
}
}










