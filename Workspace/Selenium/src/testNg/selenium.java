package testNg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class selenium{
private WebDriver driver;
 
@BeforeMethod
  public void Method(){

			System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://www.google.com/");
  }

  @AfterMethod
  public void afterMethod() {
			driver.quit();
  }

  @Test
  public void abc1(){
	  driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
  }
}



