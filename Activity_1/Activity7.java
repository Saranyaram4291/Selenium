package Activity_1;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Activity7 {
	
	WebDriver driver;
  @Test
  public void countCourseList() throws InterruptedException {

	  WebDriverWait wait = new WebDriverWait(driver,30);
	  
	  // Select the menu item that says “All courses” and click it. 
	  driver.findElement(By.xpath("//ul[@id='primary-menu']/li[2]/a")).click();
	  
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ld-course-list-items row']/div")));
	  
	  List<WebElement> sel=driver.findElements(By.xpath("//div[@class='ld-course-list-items row']/div"));
	  System.out.println("No of Courses :"+sel.size());
	  
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
