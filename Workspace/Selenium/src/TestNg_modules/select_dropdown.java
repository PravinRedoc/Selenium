package TestNg_modules;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class select_dropdown {
	public WebDriver driver;

	public void test()
	{
	Select dropdown = new Select(driver.findElement(By.id("sort")));
	dropdown.selectByVisibleText("Price: Low to High");
	}
}
