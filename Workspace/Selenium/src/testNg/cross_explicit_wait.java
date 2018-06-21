package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class cross_explicit_wait {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeMethod
	public void abc() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
		//driver = new Googl
		driver = new ChromeDriver();
		driver.get("http://www.crossword.in/");
	    wait = new WebDriverWait(driver,5);
	    //Thread.sleep(5000);
	    //driver.manage().window().maximize();
	}                                
	@Test
	public void test22()
	{
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/form/input")).sendKeys("Cricket");
		driver.findElement(By.xpath("html/body/div[1]/div[1]/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/form/input")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/span[2]/a[3]")));
		driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/span[2]/a[3]")).click();
		
		
		wait.until(ExpectedConditions.attributeContains(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[3]/span[2]/a[3]"), "class", "selected"));
		String value=driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[2]/div/div/div/ul/li[1]/div/div[2]/span[3]/span[3]/span")).getText();
		
		
		System.out.println(value);
		
		
	}
@AfterMethod
public void after()
{
	driver.quit();
}
}
