package Activity_1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class Activity1 {
  
	WebDriver driver;
	
	@Test
	public void validateTitle() {
		
		driver.get("https://alchemy.hguy.co/lms");
		
		//Read the title of the website
		String page_Title=driver.getTitle();
		
		// verify the text
		Assert.assertEquals("Alchemy LMS – An LMS Application",page_Title);
				
		Reporter.log("Validated page title successfully");
		
	}
	
		@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		
	  }

	  @AfterTest
	  public void afterTest() {
		  
		  driver.close();
	  }

}
