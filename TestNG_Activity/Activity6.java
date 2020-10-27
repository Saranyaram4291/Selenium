package TestNG_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Activity6 {
	
	WebDriver driver;
	
	
  @Test
  @Parameters({"username","pwd"})
  public void f(String username,String pwd) {
	
	  driver.findElement(By.cssSelector("#username")).sendKeys(username);
	  
	  driver.findElement(By.cssSelector("#password")).clear();
	  
	  driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
	  
	  driver.findElement(By.cssSelector("button.ui.button")).click();
	  
	  
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
