package Test;

import net.sourceforge.htmlunit.corejs.javascript.regexp.SubString;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class combo_fixtures {
private WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void cde() throws InterruptedException{
		driver.get("https://www.google.co.in/maps?source=tldso");
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

}
	@Test
	public void code() throws InterruptedException{
		driver.get("http://www.crossword.in/");
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
	@Test
	public void codee() throws InterruptedException{
		driver.get("http://www.google.co.in/");
		
		
	}
	@After
	public void tearDown(){
	driver.quit();
	}
	

}
