package TestNG_Activity;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Activity5 {
	
	WebDriver driver;
	
 @Test(groups= {"Header Tests"})
  public void validateTitle() {
	  
	  //Checking the page title
	  String pageTitle=driver.getTitle();
	  Assert.assertEquals("Target Practice",pageTitle);
	  
  }
  
  @Test(dependsOnMethods="validateTitle",groups= {"Header Tests"})
  public void validateHeaderPresence()
  {
	 String thirdHeader=driver.findElement(By.cssSelector("#third-header")).getText() ;
	 
	 Assert.assertEquals("Third header",thirdHeader);
	 
 }
  
  @Test(dependsOnMethods="validateTitle",groups= {"Header Tests"})
  public void validateHeaderColor()
  {
	 String color=driver.findElement(By.cssSelector("h5.ui.green.header")).getCssValue("color");
	 
	 Assert.assertEquals("rgba(33, 186, 69, 1)",color);
	 
  }
  
  
  
  @Test(dependsOnMethods="validateTitle",groups= {"Button Tests"})
  public void validateButtonPresence()
  {
	 Assert.assertTrue(driver.findElement(By.xpath("//button[contains(text(),'Olive')]")).isDisplayed());
	  
	
  }
  
  @Test(dependsOnMethods="validateTitle",groups= {"Button Tests"})
  public void validateButtonColor()
  {
	  	String color=driver.findElement(By.cssSelector("button.ui.yellow.button")).getCssValue("color");
		 
		 System.out.println("color"+color);
		 
		 Assert.assertEquals("rgba(255, 255, 255, 1)",color);
  }
  
  
  @BeforeClass(alwaysRun=true)
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  
	  driver.close();
  }

}
