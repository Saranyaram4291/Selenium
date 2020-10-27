package Activity_1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Actiivty2 {
	
	WebDriver driver;
	  @Test
	  public void validateHeader() {
		  
		  driver.get("https://alchemy.hguy.co/lms");
		  
		  //Get the heading of the webpage.
		  String header=driver.findElement(By.xpath("*//h1[@class='uagb-ifb-title']")).getText();
		 
		  //Make sure it matches “Learn from Industry Experts” exactly.
		 Assert.assertEquals("Learn from Industry Experts",header);
		 
			
		 
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
