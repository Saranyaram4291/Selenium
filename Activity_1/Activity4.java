package Activity_1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class Activity4 {
	WebDriver driver;
	@Test
	public void validateSecondTitle() {
	
		String secondTitle=driver.findElement(By.xpath("*//h3[@class='entry-title']")).getText();
		
		Assert.assertEquals(secondTitle,"Email Marketing Strategies");
		
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
  }



	@AfterClass
	public void afterClass()
	{
		driver.close();
	}

}