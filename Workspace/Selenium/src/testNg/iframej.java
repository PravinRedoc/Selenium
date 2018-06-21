package testNg;


import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class iframej {
	
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
		textBoxElement.sendKeys("j");
		selectOptionWithText("Java");
		
		

		
	}

	private void selectOptionWithText(String textToSelect) throws InterruptedException {
		// TODO Auto-generated method stub
   	 try{
			WebElement autoOptions = driver.findElement(By.xpath("html/body/ul"));
			Thread.sleep(2000);
			
			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
				if(option.getText().equals(textToSelect)) {
					System.out.println("Trying to Select: "+textToSelect);
					option.click();
					break;
				}
			}

		}catch (NoSuchElementException e){
			System.out.println(e.getStackTrace());
		
	}
}}
