package homework1;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class AddAccount_Junit {
	WebDriver driver;

	@Before
	public void initBrowser() {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\natal\\Selenium\\homework1\\driver\\chromedriver.exe");
	driver = new ChromeDriver();

	//Open Browser and go to site 
	driver.get("http://www.techfios.com/billing/?ng=admin/");
	//Enter username
	driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
	//Enter password
	driver.findElement(By.id("password")).sendKeys("abc123");
	// Click login button
	driver.findElement(By.name("login")).click();
	}
	
	@Test
	public void createAccount() {
	// Click on Bank & Cash button
	driver.findElement(By.xpath("//span[text()='Bank & Cash']")).click();
	
	// Click on New Account button 
	driver.findElement(By.xpath("//a[text()='New Account']")).click();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	// Fill out the Add New Account form
	driver.findElement(By.id("account")).sendKeys("Alina's account1");
	driver.findElement(By.id("description")).sendKeys("savings account 1234");
	driver.findElement(By.id("balance")).sendKeys("20000");
	driver.findElement(By.id("account_number")).sendKeys("33412900123499");
	driver.findElement(By.id("contact_person")).sendKeys("Alina P");
	driver.findElement(By.id("contact_phone")).sendKeys("408-321-9045");
	
	// Click on submit button
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	
	}
	
	@Test
	public void visualCheck() {
		
	// Visually check if the account has been created
		
	//driver.findElement(By.xpath("//a[contains(text(),'List Accounts')]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	Assert.assertEquals("Account not found", "Alina's account1", "Alina's account1");
	
	}
	
	@After
	public void tearDown() {
	//close browser
			//driver.close();
		
	}
}
