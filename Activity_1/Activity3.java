package Activity_1;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class Activity3 {
	
	WebDriver driver;
  @Test
  public void validateTitle() {
	  
	 String titleValue=driver.findElement(By.xpath("*//h3[@class='uagb-ifb-title']")).getText();
	 
	Assert.assertEquals("Actionable Training",titleValue);
	 
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