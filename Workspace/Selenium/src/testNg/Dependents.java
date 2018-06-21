package testNg;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
//import org.testng.annotations.BeforeTest;


public class Dependents {
private WebDriver driver;
	
	@BeforeClass
	public void abc(){
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https:\\www.google.co.in");
	}

	@Test (dependsOnMethods="openBrowser")
	public void signIn()
	{
		System.out.println("SignIn");
	}
	@Test
	public void openBrowser()
	{
		System.out.println("openBrow");
		
	}
	@Test(dependsOnMethods="signIn")
	public void logout(){
		System.out.println("Logout");
	}
}
