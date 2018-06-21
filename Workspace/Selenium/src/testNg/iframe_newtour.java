package testNg;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframe_newtour {
	
	
	private WebDriver driver;
	/*private By frameLocator= By.className("mouseOut"); 
	private By textTAG=By.id("tags");*/
	
	@BeforeMethod
	public void abc()
	{
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com/");		
	}
	
	@Test
	public void def() throws InterruptedException{
		Thread.sleep(5000);

	driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	//selectOptionWithindex(3);
	
	Thread.sleep(5000);
	/*Select dropdown = new Select(driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select")));
	dropdown.selectByVisibleText("INDIA");
	*///dropbox
	
	//selectOptionWithindex(10);
	selectOptionWithText("INDIA");
	
	}
	
	public void selectOptionWithindex(int i) {
		try{
 			WebElement autoOptions = driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]"));
 			Thread.sleep(2000);
 			
 			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("option"));
 				if(i<=optionsToSelect.size()) {
 					System.out.println("Trying to Select: "+i);
 					optionsToSelect.get(i).click();
 				}
 			}
 		catch (NoSuchElementException e){
 			System.out.println(e.getStackTrace());
 		}
 		catch (Exception e){
 			System.out.println(e.getStackTrace());
		// TODO Auto-generated method stub
		
	}
	}
	public void selectOptionWithText(String textToSelect) {
		// TODO Auto-generated method stub
    	 try{
 			WebElement autoOptions = driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]"));
 			Thread.sleep(2000);                                   
 			
 			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("option"));
 			for(WebElement option : optionsToSelect){
 				if(option.getText().equals(textToSelect)) {
 					System.out.println("Trying to Select: "+textToSelect);
 					option.click();
 					break;
 				}
 			}

 		}catch (NoSuchElementException e){
 			System.out.println(e.getStackTrace());
 		}
 		catch (Exception e){
 			System.out.println(e.getStackTrace());
 	}
}
}

