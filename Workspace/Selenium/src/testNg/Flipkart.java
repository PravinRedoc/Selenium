package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchElementException;

public class Flipkart {
	private WebDriver driver;
	
	@BeforeMethod
	public void axe(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.flipkart.com");
	}

	@Test
	public void effect() throws InterruptedException{
		Thread.sleep(9000);
	  driver.findElement(By.xpath("html/body/div[1]/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[1]/div/input")).sendKeys("nokia");
		Thread.sleep(2000);

	  driver.findElement(By.xpath("html/body/div[1]/div/header/div[1]/div[2]/div/div/div[2]/form/div/div[2]/button")).click();
		Thread.sleep(2000); 

	  driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[2]/section/ul/li[4]")).click();
	  Thread.sleep(4000);
	  String count=driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/div[2]/h1/span")).getText();
	  count=count.substring(count.indexOf("Showing")+12, count.indexOf("of")-1);
	  System.out.println(count);
	  
	  int co=Integer.parseInt(count);
	  System.out.println(co);
	  String m="Price: Not Available";
	  
	 java.util.List<WebElement> list=driver.findElements(By.className("Zhf2z-"));
	 int loadcount=list.size();
	 String a;
	 String b;
	 double a1,b1;
	  //while(co>)
	double aa=Double.MAX_VALUE;
	 if(loadcount==co) 
	  {
		 for(int i=1;i<10;i++)
		 {
			 
			 for(int j=1;j<4;j++)
			 {
				 if(isElementPresent(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div["+i+"]/div["+j+"]/div/a[3]/div/div")))
				 {
						 a=driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div["+i+"]/div["+j+"]/div/a[3]/div/div")).getText();
						 //b=driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div["+i+"]/div["+(j+1)+"]/div/a[3]/div/div")).getText();
						 //System.out.println(a);
						 if (!m.equals(a)){
						 a1=Double.parseDouble((a.substring(1)).replace(",",""));
						 
						 //b1=Intege.parseInt((a.substring(1)).replace(",", ""));
						 if(aa>a1)
						 {
							 System.out.println(j+"value"+(j+1)+"value are in order");
						 }
						 else
							 {System.out.println(j+"value"+(j+1)+"value are in order");}
						 aa=a1;
						 }
						 
						 
				 }
			 }
		 }
	  }
	  
	  

	}
	
	@AfterMethod
	public void rah(){
		driver.quit();

	}
	
	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	
}
