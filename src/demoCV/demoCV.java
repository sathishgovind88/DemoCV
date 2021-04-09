package demoCV;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class demoCV {
	
  @Test
  public void searchCV() throws InterruptedException, IOException {
	  
	  WebDriver driver;
	  
		  List<String> dataline = Files.readAllLines(Paths.get(".//Data.csv"));
		 
		 System.out.println(dataline.size());		 
		 
		 System.setProperty("webdriver.ie.driver", "E:\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
		
		 driver =new InternetExplorerDriver();	  
		 driver.get("https://www.cv-library.co.uk/");
		 Thread.sleep(1000);
		 driver.manage().window().maximize();      
		WebElement keyele= driver.findElement(By.id("keywords"));
		  
		WebDriverWait drvwait = new WebDriverWait(driver, 20);
		WebElement wait = drvwait.until(ExpectedConditions.visibilityOf(keyele));
		
		for (int i =0;i < dataline.size();i++){
			String[] arrval = dataline.get(i).split(",");
		
			keyele = driver.findElement(By.id("keywords"));
			
			keyele.clear();
			keyele.sendKeys(arrval[0]);
			Thread.sleep(500);
			
			keyele = driver.findElement(By.id("location"));
			keyele.clear();
			keyele.sendKeys(arrval[1]);
			Thread.sleep(500);
			
			Select disdrop = new Select(driver.findElement(By.id("distance")));
			
			disdrop.selectByValue(arrval[2]);
			driver.findElement(By.id("hp-search-btn")).click();
			Thread.sleep(5000);
	}
	driver.quit();
    
  }
  
}
