package TestNG_Activity;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity7 {
	
	WebDriver driver;
	
	@DataProvider(name="loginCredentials")
	public static Object[][] credentials()
	{
		return new Object[] []{{"admin","password"}};
	}

	@Test(dataProvider="loginCredentials")
	public void f(String username,String pwd) {
	
		System.out.println("username is"+username+"pwd is"+pwd);
		
	  driver.findElement(By.cssSelector("#username")).sendKeys(username);
	  
	  driver.findElement(By.cssSelector("#password")).clear();
	  
	  driver.findElement(By.cssSelector("#password")).sendKeys(pwd);
	  
	  driver.findElement(By.cssSelector("button.ui.button")).click();
	  
      //Assert Message
		
      String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	
      Assert.assertEquals(loginMessage, "Welcome Back, admin");
	  
	  
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
