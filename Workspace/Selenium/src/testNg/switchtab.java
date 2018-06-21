package testNg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.lang.IndexOutOfBoundsException;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;


public class switchtab {
private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://in.yahoo.com");
	}

@Test
public void bbb() throws InterruptedException{
	driver.get("https://in.yahoo.com/");
	Thread.sleep(3000);

	driver.findElement(By.id("uh-search-box")).clear();
	Thread.sleep(3000);

	
	driver.findElement(By.id("uh-search-box")).sendKeys("google");
	Thread.sleep(3000);

	driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div/div[1]/div/div/div/ol[1]/li[2]/div/div/div[1]/h3/a")).click();
		Thread.sleep(3000);

	ArrayList<String> popups=new ArrayList<String>(driver.getWindowHandles());
	Thread.sleep(2000);
	driver.switchTo().window(popups.get(1));
	Thread.sleep(2000);

	System.out.println(driver.findElement(By.id("lst-ib")).getAttribute("title"));
	
	}

@AfterTest
public void little(){
	driver.quit();
}

}
