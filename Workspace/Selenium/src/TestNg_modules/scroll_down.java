package TestNg_modules;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class scroll_down {
	public WebDriver driver;
	
	
public void single_scroll()
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,20000)");
}

}
