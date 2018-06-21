package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class kayak {
	private WebDriver driver;


	@BeforeMethod
	public void abc(){
		
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.kayak.co.in/");
	}
	
	@Test
	public void def(){
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/section/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[2]/input[1]")).sendKeys("CCU");
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/section/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[2]/input[1]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[3]/div[1]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[2]/section/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[2]/input[1]")).sendKeys("CCU");

	
	}
}
