package testNg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class get_link {
	private WebDriver driver;
	  private java.lang.String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  java.lang.String allBooksCount;

	 @BeforeMethod
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://www.imdb.com/");
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer64.exe");		
//			driver = new InternetExplorerDriver();

	   // baseUrl = "http://www.imdb.com/";
	    //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    //driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	    //driver.manage().window().maximize();
	  }
	 String href;
	 String a;
	 @Test
	 public void test1() throws InterruptedException
	 { 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/div/input[2]")).sendKeys("Blade Runner 2049");
		 driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/div/input[2]")).sendKeys(Keys.ENTER);
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[3]/div[1]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		 Thread.sleep(5000);
		 By locator=By.xpath("html/body/div[1]/div/div[4]/div[5]/div[3]/div[5]");
		 WebElement abc = driver.findElement(locator);
		 
		 List<WebElement> name=abc.findElements(By.tagName("a"));
		 String ll="Ryan Gosling";
		 System.out.println(name);
		 
		 for(WebElement x:name)
		 {
			 a=x.getText();
			System.out.println(a);
			 if(a.equalsIgnoreCase(ll)){
				  href=x.getAttribute("href");
				
			 }
		 }
		 System.out.println(href);
		 
		 
	 }
	 
	 @AfterMethod
	 public void after()
	 {
		 driver.quit();
	 }
	 

}
