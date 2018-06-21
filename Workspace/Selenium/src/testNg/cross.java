package testNg;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TimeoutException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class cross {
private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "../src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.crossword.in/");
	}
	
	@Test
	public void cde() throws InterruptedException{
		driver.findElement(By.id("search-input")).sendKeys("books");
		driver.findElement(By.xpath("//span[3]/input")).click();
		driver.findElement(By.xpath("//div[3]/span[2]/a[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div/div/div/div[2]/ul/li")).click();
		String count= driver.findElement(By.xpath("//div[2]/ul/li/a/i")).getText();

		String a= driver.findElement(By.xpath("//span[3]/span[3]/span")).getText();
		
		String b= driver.findElement(By.xpath("//li[2]/div/div[2]/span[3]/span[3]/span")).getText();
		String c= driver.findElement(By.xpath("//li[3]/div/div[2]/span[3]/span[3]/span")).getText();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(count);
		String x=a.substring(3);
		a=x.replace(", ","");
		int X1=Integer.parseInt(a);
		System.out.println(X1);
		
	    x=b.substring(3);
	    b=x.replace(",","");
		int B=Integer.parseInt(b);
		System.out.println(B);
		
		x=c.substring(3);
		c=x.replace(",","");
		int C=Integer.parseInt(c);
		System.out.println(C);
		String d="//li[Z]/div/div[2]/span[3]/span[3]/span";
		String q="";
		String m="";
		String X2="";
		int temp;
		
		int co=Integer.parseInt(count);
		int w=(co/20);
		
		Thread.sleep(1500);
		int k=1;
		
		//for (int j=1;j<w;j++){
		//JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBy(0,20000)");
		//Thread.sleep(1000);
	

		for (int i=2;i<co;i++)
		{JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,20000)");
		Thread.sleep(1000);
	
			k=k+1;
			Integer INT=k;
			m=INT.toString();
			q=d.replace("Z",m);
			 X2 =driver.findElement(By.xpath(q)).getText();
			 X2=X2.substring(3);
			    X2=X2.replace(",","");
				temp =Integer.parseInt(X2);
			q="";
			m="";
			
			if (temp>=X1){
				System.out.println("true");}
			else{
				System.out.println("false");
			}
			X1=temp;
		//}
		
	}
	}

	//@AfterClass
	//public void def(){
	 //driver.quit();
	//}
	

}
