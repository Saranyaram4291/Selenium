package Activity_1;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity8 {
	
	WebDriver driver;
  @Test(dataProvider="contactDetails")
  public void contactAdmin(String name,String email,String subject,String comment) throws InterruptedException {
	  
	  driver=new ChromeDriver();
	  
	  WebDriverWait wait = new WebDriverWait(driver,30);
	  
	  driver.get("https://alchemy.hguy.co/lms");
	  
	  //clicking on contact
	  driver.findElement(By.xpath("//ul[@id='primary-menu']/li[4]/a")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='wpforms-8-field_0']")));
	  
	  driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys(name);
	  
	  driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys(email);
	  
	  driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys(subject);

	  
	  driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys(comment);

	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  
	  Thread.sleep(2000);
	  
	  Assert.assertTrue(driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']/p")).isDisplayed());
	  
	  System.out.println("Post contact submission "+driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']/p")).getText());
	  
  }
  
  @DataProvider(name="contactDetails")
  public static Object[][] details(){
	  return new Object[][]{ {"saranya","sr644a@gmail.com","testing","part 1"},{"Ram","rherer@gmail.com","Testing 2","part2"}};
  }
  
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\SaranyaRamamoorthy\\Downloads\\chromedriver_win32(1)\\chromedriver.exe");
	 
	  
  }

  @AfterClass
  public void afterClass() {
	  
	  driver.quit();
  }

}
