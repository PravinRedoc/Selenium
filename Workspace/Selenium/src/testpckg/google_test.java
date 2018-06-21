package testpckg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pompckg.google_pfc;


public class google_test {
	
private WebDriver driver;


@Test
public void test1(){
	System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();
    driver.get("https://www.google.co.in");

     google_pfc page=PageFactory.initElements(driver, google_pfc.class);
     System.out.println(page.googleLogo.getAttribute("height"));
      page.googleSearchField.sendKeys("selenium");
      driver.quit();
}
}
