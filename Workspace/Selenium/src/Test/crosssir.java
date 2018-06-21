package Test;
//import static org.testng.Assert.fail;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.apache.xpath.operations.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.openqa.jetty.html.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class crosssir {
	  private WebDriver driver;
	  private java.lang.String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  java.lang.String allBooksCount;

	  
	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
	    driver = new FirefoxDriver();
		  
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
//			System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer64.exe");		
//			driver = new InternetExplorerDriver();

	    baseUrl = "http://www.crossword.in/";
	    //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }
	  @Test
	  public void testTCCrossword() throws Exception {
	    driver.get("http://www.crossword.in/");
	    Thread.sleep(2000);
	    driver.findElement(By.id("search-input")).clear();
	    driver.findElement(By.id("search-input")).sendKeys("Cricket");
	    driver.findElement(By.xpath("//span[3]/input")).click();
//	    driver.findElement(By.linkText("High to Low")).click();
//	    driver.findElement(By.partialLinkText("High to Low")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'High to Low')]")).click();
	    
	    Thread.sleep(5000);
	    allBooksCount = driver.findElement(By.xpath("//div[@id='search-results']/div[2]/div/span")).getText();
	    allBooksCount = allBooksCount.substring(allBooksCount.indexOf("Showing") + 8, allBooksCount.indexOf(" Results"));
	    
	    System.out.println("allBooksCount is:" + allBooksCount);
	    
		Integer readyStateComplete = Integer.parseInt(allBooksCount);
		System.out.println("allBooksCount in int is:" + readyStateComplete);
		
		
		java.util.List<WebElement> allBooks = driver.findElements(By.className("variant-image"));
		Integer allBooksLoadedCount = allBooks.size();
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
		System.out.println("Outside scroll while 02");
	    
	  
	    
		int i;
		int j;
		i = 1;
		j = i+1;

		while (isElementPresent(By.xpath("//li["+j+"]/div/div[2]/span[3]/span[1]/span")))
		{
			System.out.println("&&&&&& i and j : " + i + " and  " + j);
			java.lang.String T1;
			java.lang.String T2;
			java.lang.String T3;


			if (isElementPresent(By.xpath("//li["+i+"]/div/div[2]/span[3]/span[3]/span")))
			{
				T1 = driver.findElement(By.xpath("//li["+i+"]/div/div[2]/span[3]/span[3]/span")).getText();
				System.out.println("\n\n *** T1 is " + T1);
			}
			else
			{
				T1 = driver.findElement(By.xpath("//li["+i+"]/div/div[2]/span[3]/span[1]/span")).getText();
				System.out.println("\n\n *** T1 is " + T1);
			}
		
			if (isElementPresent(By.xpath("//li["+j+"]/div/div[2]/span[3]/span[3]/span")))
			{
				T2 = driver.findElement(By.xpath("//li["+j+"]/div/div[2]/span[3]/span[3]/span")).getText();
				System.out.println("\n\n *** T2 is " + T2);
			}
			else
			{
				T2 = driver.findElement(By.xpath("//li["+j+"]/div/div[2]/span[3]/span[1]/span")).getText();
				System.out.println("\n\n *** T2 is " + T2);
			}

			double A = Double.parseDouble(T1.trim().substring(3).replace(",", ""));
			double B = Double.parseDouble(T2.trim().substring(3).replace(",", ""));
			
//			if (A<=B){
			if (A>=B){
				T3 = A + " and " + B + " >>True";
			}
			else
			{
				T3 = A + " and " + B + " >>False";
//				Assert.assertTrue(A + " and " + B + " >>False", false);  //Let's not assert here and continue the test
				System.out.println("For " + i + " and " + j + " Book!!  Not in Desc order for book with prices: " + T1 + " and " + T2);
		       	 //JOptionPane.showMessageDialog(null, "For " + i + " and " + j + " Book!!  Not in Desc order for book with prices: " + T1 + " and " + T2);
			}

			
					
			System.out.println("\n\n\n *** Are the books sorted in Asc order? >> " + T3);
			i = i + 1;
			j = i + 1;
		}
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    java.lang.String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  
	  private java.lang.String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      java.lang.String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}
