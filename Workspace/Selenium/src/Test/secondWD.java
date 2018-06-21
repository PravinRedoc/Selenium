package Test;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class secondWD {
	
	private WebDriver driver;
	
	@Before
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://www.crossword.in/");
	}
	
	@Test
	public void cde() throws InterruptedException{
		driver.findElement(By.id("search-input")).sendKeys("books");
		driver.findElement(By.xpath("//span[3]/input")).click();
		driver.findElement(By.xpath("//span[2]/a[3]")).click();
		Thread.sleep(10000);
		String a= driver.findElement(By.xpath("//span[3]/span[3]/span")).getText();
		String b= driver.findElement(By.xpath("//ul[@id='search-result-items']/li[2]/div/div[2]/span[3]/span[3]/span")).getText();
		String c= driver.findElement(By.xpath("//ul[@id='search-result-items']/li[3]/div/div[2]/span[3]/span[3]/span")).getText();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		
		String x=a.substring(3);
		a=x.replace(",","");
		int A=Integer.parseInt(a);
		System.out.println(A);
		
	    x=b.substring(3);
	    b=x.replace(",","");
		int B=Integer.parseInt(b);
		System.out.println(B);
		
		x=c.substring(3);
		c=x.replace(",","");
		int C=Integer.parseInt(c);
		System.out.println(C);
		
		boolean f=false;
		if(A>B && B>C)
			f=true;
		   	
	System.out.println(f);
	}

	//@After
	//public void def(){
		//driver.quit();
	//}
	
}
