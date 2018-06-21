package testNg;
import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class autotests {
private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.google.co.in/");
	}
	@Test
	public void autocom() throws InterruptedException{
		Thread.sleep(10000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[3]")).sendKeys("seleni");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[3]")).sendKeys(Keys.ENTER);
		//Thread.sleep(2000);
	    selectOptionWithindex(3);
	    Thread.sleep(2000);
		//driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[3]")).sendKeys(Keys.ENTER);
		driver.findElement(By.partialLinkText("Selenium (software)")).click();
	
	}
	public void selectOptionWithindex(int i) {
		try{
 			WebElement autoOptions = driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/ul"));
 			Thread.sleep(2000);
 			
 			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
 				if(i<=optionsToSelect.size()) {
 					System.out.println("Trying to Select: "+i);
 					optionsToSelect.get(i).click();
 				}
 			}
 		catch (NoSuchElementException e){
 			System.out.println(e.getStackTrace());
 		}
 		catch (Exception e){
 			System.out.println(e.getStackTrace());
		// TODO Auto-generated method stub
		
	}
}}
