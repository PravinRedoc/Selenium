package testNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sun.jna.Platform;

public class grid {

	WebDriver driver;
	
	@Parameters({"nodeURL","browser"})
	@BeforeTest
	public void setUp(String Nurl,String brow) throws MalformedURLException{
		String nodeURL=" http://192.168.100.22:5555/wd/hub";
		//String nodeURL1=" http://192.168.100.108:5555/wd/hub";
		DesiredCapabilities capab =null;
		if(brow.equals("chrome")){
			capab = DesiredCapabilities.chrome();
			capab.setBrowserName("chrome");
			
		}else if(brow.equals("firefox")){
			capab = DesiredCapabilities.chrome();
			capab.setBrowserName("chrome");
		}
				
				
		capab.setPlatform(org.openqa.selenium.Platform.WIN10);
		driver=new RemoteWebDriver(new URL(nodeURL), capab);
		
		//DesiredCapabilities capab1 = DesiredCapabilities.chrome();
		//capab1.setBrowserName("chrome");
		//capab1.setPlatform(org.openqa.selenium.Platform.WIN10);
		//driver=new RemoteWebDriver(new URL(nodeURL1), capab1);
		
	}
	
	@Test
	public void t1() throws InterruptedException{
		driver.get("https://www.google.com/");
		Thread.sleep(2000);
		driver.findElement(By.id("lst-ib")).sendKeys("Axe Effect");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		driver.quit();

	}
}
