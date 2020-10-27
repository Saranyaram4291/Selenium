package TestNG_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity3 {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  //Find the login input fields - username and password
	  
	  driver.findElement(By.cssSelector("#username")).sendKeys("admin");
	  
	  driver.findElement(By.cssSelector("#password")).clear();
	  
	  driver.findElement(By.cssSelector("#password")).sendKeys("password");
	  
	  driver.findElement(By.xpath("//button[@class='ui button']")).click();
	  
	  
	  String validateMsg=driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText();
	  
	  Assert.assertEquals("Welcome Back, admin",validateMsg);
	  
  }
  @BeforeClass
  public void beforeClass() {
	  

		System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.close();
  }

}
