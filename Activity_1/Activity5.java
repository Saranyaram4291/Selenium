package Activity_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	
  @Test
  public void pageNavigation() {
	  
	  driver.findElement(By.xpath("//ul[@id='primary-menu']/li[5]/a")).click();
	  
	 String navigated_pageTitle= driver.getTitle();
	 
	 System.out.println("Navigated pagetitle"+navigated_pageTitle);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://alchemy.hguy.co/lms");
		
  }
}
