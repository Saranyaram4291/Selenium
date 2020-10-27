package TestNG_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Activity1 {
	
	WebDriver driver;
  @Test
  public void getTitle() {
	  
	  String titleName=driver.getTitle();
	  
	  Assert.assertEquals(titleName,"Training Support - Selenium");
	  
	  
	  
  }
  @BeforeMethod
  public void beforeClass() {
	  
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.training-support.net/selenium");
	  
  }

  @AfterMethod
  public void afterClass() {
	  
	  driver.close();
  }

}
