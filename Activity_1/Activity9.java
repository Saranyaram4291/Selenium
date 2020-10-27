package Activity_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity9 {
	
	WebDriver driver;
		@Test(dataProvider="Authentication")
		public void selectCourse(String username,String pwd) throws InterruptedException {
	  
			WebDriverWait wait = new WebDriverWait(driver,30);
			// Select the menu item that says “All courses” and click it. 
		  driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a")).click();
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ld-course-list-items row']/div[1]//a/img")));
		  
		  driver.findElement(By.xpath("//div[@class='ld-course-list-items row']/div[1]//a/img")).click();
		  
		 
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ld-button']")));
		  
		  driver.findElement(By.xpath("//a[@class='ld-button']")).click();
		  
		//Find the username field of the login form and enter the username into that field. 
		  driver.findElement(ByXPath.id("user_login")).sendKeys(username);
		  
		  // Find the password field of the login form and enter the password into that field. 
		  driver.findElement(ByXPath.id("user_pass")).sendKeys(pwd);
		  
		  
		  driver.findElement(ByXPath.id("wp-submit")).click();
		  
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ld-item-list-69']/div[1]/div[@class='ld-item-list-item-preview']/a[1]/div[2]")));
		  
		  driver.findElement(By.xpath("//div[@id='ld-item-list-69']/div[1]/div[@class='ld-item-list-item-preview']/a[1]/div[2]")).click();
		  
		  String validatePage=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/h1")).getText();
		  
		  Assert.assertEquals("Developing Strategy",validatePage);
  }
  
  @DataProvider(name = "Authentication")
  public static Object[][] credentials() {
      return new Object[][] { { "root", "pa$$w0rd"}};
  } 
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://alchemy.hguy.co/lms");
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }
}

