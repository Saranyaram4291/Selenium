package TestNG_Activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Activity2 {
	
	WebDriver driver;
  @Test
  public void getTitle() {
	  
	  String pageTitle=driver.getTitle();
	  
	  Assert.assertEquals(pageTitle,"Training Support - Selenium");
	  
  }
  
  @Test
  public void checkElement()
  {
	 boolean checkElementPresent= driver.findElement(By.xpath("//button[@class='ui black button']")).isDisplayed();
	 
	 Assert.assertTrue(checkElementPresent);
  }
  
  @Test(enabled=false)
  public void skipCheck()
  {
	  System.out.println("Test Skipped");
  }
  
  @Test
  public void skipExceptionMethod()
  {
	 throw new SkipException("Test skipped due to exception");
  }
  
  
  @BeforeMethod
  public void beforeClass() {
	  
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	  
  }

  @AfterMethod
  public void afterClass() {
	  
	  driver.close();
  }

}
