package testNg;

import java.awt.RenderingHints.Key;
import java.io.File;

import org.openqa.selenium.WebDriverException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class barnesandnoble {
private WebDriver driver;
private java.lang.String baseUrl;


@BeforeMethod
public void abc(){
	
	System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
	driver=new FirefoxDriver();
	driver.get("https://www.barnesandnoble.com/");
}



@DataProvider(name = "DP1")
   public Object[][] createData1() {
       Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/book_data1.xls", "DataPool", "bookTestData1");
       return(retObjArr);
   }

public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
    String[][] tabArray=null;
    try{
        Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        
        int startRow,startCol, endRow, endCol,ci,cj;
        
        Cell tableStart=sheet.findCell(tableName);
        startRow=tableStart.getRow();
        startCol=tableStart.getColumn();

        Cell tableEnd= sheet.findCell(tableName, startCol+1,startRow+1, 100, 64000,  false);                

        endRow=tableEnd.getRow();
        endCol=tableEnd.getColumn();
        
        System.out.println("startRow="+startRow+", endRow="+endRow+", " +
                "startCol="+startCol+", endCol="+endCol);
        tabArray=new String[endRow-startRow-1][endCol-startCol-1];
        ci=0;

        for (int i=startRow+1;i<endRow;i++,ci++){
            cj=0;
            for (int j=startCol+1;j<endCol;j++,cj++){
                tabArray[ci][cj]=sheet.getCell(j,i).getContents();
            }
        }
    }
    catch (Exception e)    {
        System.out.println("error in getTableArray()");
        
    }

    return(tabArray);
}


@Test(dataProvider="DP1")
public void def( String bookTitle ,String authorName, String bookSummary ,String number) throws InterruptedException
{
//driver.findElement(By.xpath("html/body/header/div[2]/div[1]/form/input[7]")).sendKeys(bookTitle);
	Thread.sleep(5000);
if(isElementPresent(By.xpath("html/body/div[22]/div/div/div[2]/h2/h1")))
{driver.findElement(By.xpath("html/body/div[22]/div/div/div[1]/a")).click();
}
Thread.sleep(5000);
driver.findElement(By.xpath("html/body/header/div[2]/div[1]/form/input[7]")).sendKeys(bookTitle);
driver.findElement(By.xpath("html/body/header/div[2]/div[1]/form/input[7]")).sendKeys(Keys.ENTER);
Thread.sleep(10000);
//String a=driver.findElement(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[1]/div/div/div[1]/h1")).getText();
//String b=a.substring(a.indexOf("1")+12, a.indexOf("of")-1);

int i=0;
String link;
for( i=1;i<21;i++)
{
		System.out.println("dfad");
	if(isElementPresent(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[1]/div/div/a/img")))
	{
		String c=driver.findElement(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[2]/div[2]/a")).getText();
		String book=driver.findElement(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[2]/div[1]/a")).getText();
		//System.out.println(c);
		
		System.out.println(authorName+" "+c);
		Thread.sleep(1000);
		if(c.equalsIgnoreCase(authorName)){
			Thread.sleep(5000);
			System.out.println("adfadf");
			Thread.sleep(5000);
			if(isElementPresent(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[2]/div[1]/a")))
			{   			System.out.println("fasdfdsjfads;kjfladflkafdsfjklajdf");
			
			 baseUrl=driver.findElement(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[2]/div[1]/a")).getAttribute("href");
System.out.println(baseUrl);
			}
			//driver.findElement(By.xpath("html/body/main/div[2]/div[1]/div/div[2]/div/div/section[2]/div/div["+i+"]/div[1]/div/div/a")).click();
			Thread.sleep(8000);
			
			//JavascriptExecutor jse = (JavascriptExecutor)driver;
			//jse.executeScript("window.scrollBy(0,20000)");
			System.out.println("fasdfdsjfads;kjfladflkafdsfjklajdf");
			driver.quit();
			System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();			
			driver.get(baseUrl);
			Thread.sleep(10000);
			//driver.findElement(By.tagName())).click();
			//driver.findElement(By.xpath("html/body/main/div[2]/section[4]/div/div[1]/ul/li[2]/a")).click();
			Thread.sleep(8000);
			String isbn=driver.findElement(By.xpath("html/body/main/div[2]/section[4]/div/div[2]/div/div[2]/div/table/tbody[1]/tr[1]/td")).getText();
			Thread.sleep(3000);
			System.out.println(isbn);
			System.out.println("sucess");
		//String summary=driver.findElement(By.xpath(""));
		
		}
	}
	System.out.println(i);
		
	
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
@AfterMethod
public void after()
{
	driver.quit();
}

}
