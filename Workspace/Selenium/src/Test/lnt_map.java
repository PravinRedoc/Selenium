package Test;
import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class lnt_map {
	
	
private WebDriver driver;
	
	@Before
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.co.in/maps?source=tldso");
	}
	
	@Test
	public void cde() throws InterruptedException{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("D:/workspace/Selenium/outputs/first.jpeg"));
			}
		catch (IOException e){
		 System.out.println(e.getMessage());
		}
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.xpath("//input")).sendKeys("LTI");
		driver.findElement(By.id("searchbox-searchbutton")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//h3/span")).click();
		Thread.sleep(5000);
		String rating_number= driver.findElement(By.xpath("//span/span/span")).getText();
		//String stars= driver.findElement(By.xpath("//ol")).getAttribute(arg0);
		String phone_number= driver.findElement(By.xpath("//div[@id='pane']/div/div[2]/div/div/div[6]/div/div/span[3]/span/span")).getText();
		//String phone_number= driver.findElement(By.xpath("//div[6]/div/div/span[3]/span/span")).getText();
		System.out.println(rating_number);
		//System.out.println(stars);
		System.out.println(phone_number);
		
		File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src1, new File("D:/workspace/Selenium/outputs/second.jpeg"));
			}
		catch (IOException e){
		 System.out.println(e.getMessage());
		}

}
}

