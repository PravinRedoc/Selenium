package pompckg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class demo_pom {
	private WebElement element = null;
	public WebElement userName(WebDriver driver){
		element=driver.findElement(By.name("userName"));
		return element;
	}

	
	public WebElement password(WebDriver driver){
		element=driver.findElement(By.name("password"));
		return element;
	}
	
	public WebElement signIn(WebDriver driver){
		element=driver.findElement(By.name("login"));
		return element;
	}
}
