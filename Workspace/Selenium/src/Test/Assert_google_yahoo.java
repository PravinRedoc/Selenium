package Test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

public class Assert_google_yahoo {
	
	private WebDriver driver;
	
	@Before
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.yahoo.com/");
	}
	
	@Test
	public void cde() throws InterruptedException{
		Thread.sleep(10);
		driver.findElement(By.id("uh-search-box")).sendKeys("selenium");
		driver.findElement(By.id("uh-search-button")).click();
		driver.findElement(By.xpath("//h3/a")).click();
	}

	//@After
	//public void def(){
		//driver.quit();
	//}
	
}
