package demoCV;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class demoCV {
	
  @Test
  public void searchCV() throws InterruptedException {
	
	  WebDriver driver;
	  
	  System.setProperty("webdriver.ie.driver", "E:\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
	  driver =new InternetExplorerDriver();  
	  
	  driver.get("https://www.cv-library.co.uk/");
	  Thread.sleep(1000);
	        
	 WebElement keyele= driver.findElement(By.id("keywords"));
	  
	WebDriverWait drvwait = new WebDriverWait(driver, 20);
	WebElement wait = drvwait.until(ExpectedConditions.visibilityOf(keyele));
	  
	driver.findElement(By.id("keywords")).sendKeys("Automation Tester");
	Thread.sleep(500);
	
	driver.findElement(By.id("location")).sendKeys("London");
	Thread.sleep(500);
	
	Select disdrop = new Select(driver.findElement(By.id("distance")));
	
	disdrop.selectByValue("up to 15 miles");
	driver.findElement(By.id("hp-search-btn")).click();
	Thread.sleep(1000);

	driver.quit();
    
  }
  
}
