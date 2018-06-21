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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class amazon {
 private WebDriver driver;
 @BeforeClass
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.amazon.in/");
 }
 @Test
	public void code() throws InterruptedException{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("books");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input")).click();
		Thread.sleep(7000);
		
		Select dropdown = new Select(driver.findElement(By.id("sort")));
		dropdown.selectByVisibleText("Price: Low to High");
		
		
		String d="html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[Z]/div/div/div/div[2]/div[2]/div[1]/div[2]/a/span/span[2]/span[2]";
		String q="";
		String m="";
		String X2="";
		Thread.sleep(10000);
		String a= driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[3]/div/div/div/div[2]/div[2]/div[1]/div[2]/a/span/span[2]/span[2]")).getText();
		//String x=a.substring(3);
		a=a.replace(",",""); 	
	     float X1=Float.parseFloat(a);
		System.out.println(X1);
		float temp;
		
		String count1=driver.findElement(By.xpath("//h1")).getText();
		count1=count1.substring(2,4);
		System.out.println(count1);
		
		int Co=Integer.parseInt(count1);
		Co=Co-5;
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,20000)");
		
		for (int i=3;i<Co;i++)
		{
			Integer INT=i;
			m=INT.toString();
			q=d.replace("Z",m);
			 X2 =driver.findElement(By.xpath(q)).getText();
			// X2=X2.substring(3);
			    X2=X2.replace(",","");
				temp =Float.parseFloat(X2);
			q="";
			m="";
			
			if (temp<=X1){
				System.out.println("true");}
			else{
				System.out.println("false");
			}
			X1=temp;
		}
 
}
}