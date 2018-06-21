package TestNg_modules;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scroll_till_all_loads {
	
	
	private WebDriver driver;
	java.lang.String allBooksCount;
	
	public void full_scroll()
	 {
		 
	allBooksCount = driver.findElement(By.xpath("//div[@id='search-results']/div[2]/div/span")).getText();
	 allBooksCount = allBooksCount.substring(allBooksCount.indexOf("Showing") + 8, allBooksCount.indexOf(" Results"));
	 //To get total count
	 
	 
	 
	    
	    System.out.println("allBooksCount is:" + allBooksCount);
	   //prints total count in string
	    
	    
		Integer readyStateComplete = Integer.parseInt(allBooksCount);
		System.out.println("allBooksCount in int is:" + readyStateComplete);
		//prints total count in integer
		
		
		
		java.util.List<WebElement> allBooks = driver.findElements(By.className("variant-image"));
		//identify a unique element locator
		
		Integer allBooksLoadedCount = allBooks.size();
	   //counts number of elements in current page
		
		
		
		System.out.println("allBooksLoadedCount in int is:" + allBooksLoadedCount);
		
		
		
		
		while ((readyStateComplete) > allBooksLoadedCount) {
			System.out.println("Inside scroll while 01");
			JavascriptExecutor je = (JavascriptExecutor) driver;    
		    je.executeScript("window.scrollTo(0, document.body.offsetHeight)");
		    System.out.println("Inside scroll while 02");
		    java.util.List<WebElement> allBooks2 = driver.findElements(By.className("variant-image"));
		    System.out.println("Inside scroll while allBooks count: " + allBooks2.size());
		    allBooksLoadedCount = allBooks2.size();

		}
	
	 }
}
