package Test;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class first_WD {
	
	private WebDriver driver;
	
	@Before
	public void abc(){
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com/");
	}
	
	@Test
	public void cde(){
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Selenium - Web Browser Automation")).click();
	}

	@After
	public void def(){
		driver.quit();
	}
	
}
