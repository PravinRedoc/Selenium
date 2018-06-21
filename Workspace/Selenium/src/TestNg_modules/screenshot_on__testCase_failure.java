package TestNg_modules;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class screenshot_on__testCase_failure {

	private WebDriver driver;
	
	
	@AfterMethod
	public void aftmed(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus())
		{
		try 
		{
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("D:/workspace/Selenium/outputs/firstt1.jpeg"));			 
			System.out.println("Screenshot taken");
		}
		catch (Exception e)
		{
		 
		System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
		
	}
}

}
