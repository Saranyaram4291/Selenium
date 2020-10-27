package Activity_1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity6 {
	
	WebDriver driver;

  @Test(dataProvider="Authentication")
  public void siteLogging(String username,String pwd) throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  driver.get("https://alchemy.hguy.co/lms");
	  
	  // Select the menu item that says “My Account” and click it. 
	  driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a")).click();
	  
	  Thread.sleep(3000);
	  String pageTitle=driver.getTitle();
	  
	 
	  
	  // Read the page title and verify that you are on the correct page. 
	  AssertJUnit.assertEquals("My Account – Alchemy LMS",pageTitle);
	  
	  
	  // Find the “Login” button on the page and click it. 
	  driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
	  
	  //Find the username field of the login form and enter the username into that field. 
	  driver.findElement(ByXPath.id("user_login")).sendKeys(username);
	  
	  // Find the password field of the login form and enter the password into that field. 
	  driver.findElement(ByXPath.id("user_pass")).sendKeys(pwd);
	  
	  
	  driver.findElement(ByXPath.id("wp-submit")).click();
	  
	  
	  AssertJUnit.assertTrue(driver.findElement(ByXPath.xpath("//div[@class='ld-profile-card']")).isDisplayed());

 
	  
  }
  
  @DataProvider(name = "Authentication")
	  public static Object[][] credentials() {
	      return new Object[][] { { "root", "pa$$w0rd"}, { "testuser_2", "Test@456" }};
	  }  
  
  
  
  
  
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		
}

  @AfterClass
  public void afterClass() {
	 
	  driver.close();
		
}

}
