package testpckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pompckg.demo_pom;

public class Demo_test {
	private WebDriver driver;
	demo_pom pageobj;
	
	@BeforeMethod
	public void abc(){
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}

	@Test
	public void bbb(){
		driver.get("http://newtours.demoaut.com/");
		pageobj=new demo_pom();
		pageobj.userName(driver).sendKeys("tutoriall");
		pageobj.password(driver).sendKeys("tutoriall");
		pageobj.signIn(driver).click();

	}
	
}
