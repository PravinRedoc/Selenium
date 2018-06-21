package testNg;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class manipal {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeMethod
	public void abc() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
		//driver = new Googl
		driver = new ChromeDriver();
		driver.get("https://manipal.edu/mu.html");
	    wait = new WebDriverWait(driver,5);
	    //Thread.sleep(5000);
	    //driver.manage().window().maximize();
	}
	
	@Test
	public void def() throws InterruptedException{
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/ul/li[2]/a")));
		// Thread.sleep(5000);
		Actions cat=new Actions(driver);
		 //Thread.sleep(5000);
		WebElement a=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/ul/li[2]/a"));
		Action act1=cat.moveToElement(a).build();
		act1.perform();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/ul[1]/li[5]/a[1]/span")));

		// Thread.sleep(5000);
		WebElement b=driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/ul[1]/li[5]/a[1]/span"));
		Action act2=cat.moveToElement(b).build();
		act2.perform();
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[2]/div/div/ul[2]/li[1]/ul/li/a/span")).click();
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/ul/li[2]/div/div/div/h1")));

		String text=driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/ul/li[2]/div/div/div/h1")).getText();
		String exp="B.Tech";
		assertEquals(text,exp);
	
	}
	@AfterMethod
	public void after()
	{
		driver.quit();
	}
	
	
}
