package testNg;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class JohnGrisham {
	  private WebDriver driver;
	  private java.lang.String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  java.lang.String allBooksCount;

	 @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
	    driver = new FirefoxDriver();
		  
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer64.exe");		
//			driver = new InternetExplorerDriver();

	    baseUrl = "https://www.google.co.in/";
	    //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }
@Test
public void test1()
{
	driver.findElement(By.xpath("html/body/div[6]/div[3]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div/div[3]/div/div/h3/a")).clear();
	By boxLocator=By.xpath("html/body/div[3]/div[3]/div[4]/div/div[4]");
	WebElement abc  =driver.findElement(boxLocator);
	java.util.List<WebElement> list1=abc.findElements(By.tagName("a"));
}
	 
	 
	 

}
