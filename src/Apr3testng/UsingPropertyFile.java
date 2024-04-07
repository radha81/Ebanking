package Apr3testng;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingPropertyFile {

	WebDriver driver;
	Properties conpro;
	@BeforeTest
	public void setUp()throws Throwable
	{
		conpro = new Properties();
		//load property file
		conpro.load(new FileInputStream("OR.properties"));
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(conpro.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath(conpro.getProperty("Objuser"))).sendKeys(conpro.getProperty("Enteruser"));
		driver.findElement(By.xpath(conpro.getProperty("Objpass"))).sendKeys(conpro.getProperty("Enterpass"));
		driver.findElement(By.xpath(conpro.getProperty("Objlogin"))).click();
	}
	@Test
	public void branch() throws Throwable
	{
		driver.findElement(By.xpath(conpro.getProperty("ObjBranches"))).click();
		driver.findElement(By.xpath(conpro.getProperty("ObjNewBranch"))).click();
		driver.findElement(By.xpath(conpro.getProperty("Objbranchname"))).sendKeys(conpro.getProperty("EnterBranchname"));
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress1"))).sendKeys(conpro.getProperty("EnterAddress1"));
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress2"))).sendKeys(conpro.getProperty("EnterAddress2"));
		driver.findElement(By.xpath(conpro.getProperty("ObjAddress3"))).sendKeys(conpro.getProperty("EnterAddress3"));
		driver.findElement(By.xpath(conpro.getProperty("ObjArea"))).sendKeys(conpro.getProperty("EnterArea"));
		driver.findElement(By.xpath(conpro.getProperty("ObjZip"))).sendKeys(conpro.getProperty("Enterzip"));
		new Select(driver.findElement(By.xpath(conpro.getProperty("Objcountry")))).selectByVisibleText(conpro.getProperty("SelectCountry"));
		new Select(driver.findElement(By.xpath(conpro.getProperty("Objstate")))).selectByVisibleText(conpro.getProperty("SelectState"));
		new Select(driver.findElement(By.xpath(conpro.getProperty("Objcity")))).selectByVisibleText(conpro.getProperty("SelectCity"));
		driver.findElement(By.xpath(conpro.getProperty("Objsubmit"))).click();
		Thread.sleep(3000);
		String alert_text = driver.switchTo().alert().getText();
		Reporter.log(alert_text,true);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	}

