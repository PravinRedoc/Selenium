package testNg;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class annauniv {
	public WebDriver driver;
	// private Actions action;
	 
	 
	@BeforeMethod
	public void ffdriver(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.annauniv.edu/");
}
	
	@Test
	public void antest() throws InterruptedException{
		
		Actions action = new Actions(driver);
		
		//WebElement we =  driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[4]"));
		WebElement we =  driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[1]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td[4]/div/a"));
		Thread.sleep(1000);
		//action.moveToElement(we).moveToElement(driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[1]/span/div[2]/div/div/div[6]/div[2]"))).click().build().perform();
		Thread.sleep(1000);
		Action act1=action.moveToElement(we).build();
	    act1.perform();
	    WebElement path=driver.findElement(By.xpath("html/body/table/tbody/tr[1]/td[1]/span/div[2]/div/div/div[6]/div[2]"));
	    Action act2=action.moveToElement(path).build();
	    act2.perform();
	   path.click();
		
		Thread.sleep(1000);
	     
	    int flag=0;
		String a="html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr[5]/td[2]/div/strong";
		String text;
		Thread.sleep(5000);
		String com="Dr.S.Jayaraj i/c";
		int k=0,j=1;
		String phone;
		
		for(int i=3;i<=30;i++)
		{k=k+1;
			text=driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr["+i+"]/td[2]/div/strong")).getText();
			System.out.println(text);
			
			if(text.equals(com))
				{flag=i;break;
				//j=k;
				}
		}
			
		if(flag==0)
		{
			System.out.println("notsucess");
			System.out.println(flag);
		}
		else
		{
			System.out.println("success");
			System.out.println(flag);
			phone=driver.findElement(By.xpath("html/body/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr["+flag+"]/td[3]/div")).getText();
			System.out.println("location"+j);
			System.out.println("phone No"+phone);
		}
		//else
		//{
		//	System.out.println("succesddddds");
		//}
		
	}
	@AfterMethod
	public void after() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
