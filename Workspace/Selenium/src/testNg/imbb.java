package testNg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class imbb {

	public WebDriver driver;
	@BeforeMethod
	public void ffdriver(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.ibm.com/");
	}
	
	@Test
	public void ibmtest() throws InterruptedException{
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/input[1]")).click();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/input[1]")).sendKeys("Websphere");
		//WebElement webelement=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/button"));
		//webelement.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/input[1]")).submit();
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/div[1]/div[4]/main/div/div/div/div/div[6]/div[2]/div[3]/h3/a")).click();
		Thread.sleep(10000);
		String a=driver.findElement(By.xpath("html/body/div[1]/div[4]/main/div/div/div/div/div[2]/div[1]/h1")).getText();
		Thread.sleep(10000);
		System.out.println(a);
		Thread.sleep(10000);
		String b=driver.getTitle();
		Thread.sleep(10000);
		System.out.println(b);
		Thread.sleep(10000);
		String c="8.5.5.12: WebSphere Application Server V8.5.5 Fix Pack 12";
		Thread.sleep(10000);
		Assert.assertEquals(a,c);
		Thread.sleep(10000);
	}
}




