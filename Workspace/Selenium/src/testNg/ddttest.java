package testNg;
import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ddttest {

	private WebDriver driver;
	
	@BeforeTest
	public void axe(){
		
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	@DataProvider(name = "creds")
	public Object[][] DemoDDT(){
		Object[][] credentials =new  Object[5][2];
		
		
		credentials[0][0] = "Axe";
		credentials[0][1] = "Effect";
		credentials[1][0] = "Rahul";
		credentials[1][1] = "Baahubali";
		credentials[2][0] = "disha";
		credentials[2][1] = "patani";
		credentials[3][0] = "kajol";
		credentials[3][1] = "aggarwal";
		credentials[4][0] = "jichang";
		credentials[4][1] = "wook";

		return credentials;
	}
	@Test(dataProvider="creds")
	public void DDTTest(String username, String password) {
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
	}
	
	@AfterTest
	public void sss(){
		driver.quit();
	}
	
}
