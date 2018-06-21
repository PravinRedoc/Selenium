package testNg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class fannito {
private WebDriver driver;
private WebDriverWait wait;

@BeforeMethod
public void abc() throws InterruptedException{
	System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
	driver = new FirefoxDriver();
	Thread.sleep(2000);

	driver.get("http://fannitopizza.com/");
	
	wait = new WebDriverWait(driver,10);
	
	
}

@Test
public void def() throws InterruptedException{
	
	Thread.sleep(2000);
	//wait.until(ExpectedConditions.(By.xpath("html/body/header/div[1]/div/nav/ul[2]/li[3]/a")));
	driver.findElement(By.xpath("html/body/header/div[1]/div/nav/ul[2]/li[3]/a")).click();
	Thread.sleep(1000);
	//JavascriptExecutor jse = (JavascriptExecutor)driver;
	//jse.executeScript("window.scrollBy(0,20000)");
	String a=driver.findElement(By.xpath("html/body/footer/section/section/div[2]/ul/li[1]/a")).getAttribute("href");
	System.out.println(a);
	Thread.sleep(2000);
File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		Thread.sleep(2000);
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src1, new File("D:/workspace/Selenium/outputs/second.jpeg"));
		}
	catch (IOException e){
	 System.out.println(e.getMessage());
	}
	
}

	
	


@AfterMethod
public void after()
{
	//driver.quit();
}

}
