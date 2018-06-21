package testNg;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class jqueryiframe {
	private By frameLocator= By.className("demo-frame"); 
	private By textTAG=By.id("tags");
	private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		//System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		//driver = new FirefoxDriver();
		
		
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/autocomplete/");
		
		//driver.manage().window().maximize();
		//wait = new WebDriverWait(driver, 5);
		
	}
	
	@Test
	public void rightClickTest() throws InterruptedException  {
		
		WebElement frameElement=driver.findElement(frameLocator);
		
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(tagText));
		driver.switchTo().frame(frameElement);
		WebElement textBoxElement=driver.findElement(textTAG);
		textBoxElement.sendKeys("java");
		//textBoxElement.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
	    driver.switchTo().defaultContent();
	    String ab=driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[1]/h1")).getText();
				System.out.println(ab);
		

		
		
		

		
	}

	}


