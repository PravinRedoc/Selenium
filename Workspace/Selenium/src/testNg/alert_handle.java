package testNg;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.BeforeTest;

public class alert_handle {
private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
	}
	
	@Test
	public void def() throws InterruptedException{
		WebElement jsAlert =driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[1]/button"));
		WebElement jsConfirm =driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[2]/button"));
		WebElement jsPrompt =driver.findElement(By.xpath("html/body/div[2]/div/div/ul/li[3]/button"));
		
		jsAlert.click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		jsConfirm.click();
		Thread.sleep(3000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		jsPrompt.click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("hello");
		driver.switchTo().alert().accept();

		

		
	}
}
