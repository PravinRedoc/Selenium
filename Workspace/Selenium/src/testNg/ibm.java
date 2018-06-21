 package testNg;

/*import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriverException;

*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class ibm {
private WebDriver driver;

@BeforeMethod
  public void abccc(){
	System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("https://www.ibm.com/in-en/");
}

@Test
 public void defdd() throws InterruptedException{
	Thread.sleep(9000);
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/input[1]")).sendKeys("WebSphere Liberty");
	Thread.sleep(9000);
	driver.findElement(By.xpath("html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/form[1]/p/input[1]")).submit();
	Thread.sleep(9000);

	driver.findElement(By.linkText("About WebSphere Liberty - WASdev")).click();	
	Thread.sleep(9000);
	String a=driver.findElement(By.xpath("html/body/div[2]/div[4]/div/div/header/h1")).getText();	
	System.out.println(a);
	 //assertEquals(a, "About WebSphere Liberty");
	}

    }
