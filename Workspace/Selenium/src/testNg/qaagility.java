package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class qaagility {
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	@BeforeMethod
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.qaagility.com/");
	    wait = new WebDriverWait(driver,5);
	}

	@Test
	public void cde()
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div/header/nav/ul/li[5]/a")));

		driver.findElement(By.xpath("html/body/div[1]/div/div/header/nav/ul/li[5]/a")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div/div/section/article/div[3]/div[4]/div[1]/div[2]/a")));

		String b=driver.findElement(By.xpath("html/body/div[1]/div/div/section/article/div[3]/div[4]/div[1]/div[2]")).getText();
  		String a=driver.findElement(By.xpath("html/body/div[1]/div/div/section/article/div[3]/div[4]/div[1]/div[2]/a")).getText();
        System.out.println(a);
        System.out.println(b);

	}
	
	@AfterMethod
	public void after()
	{
		driver.quit();
	}
	
}
