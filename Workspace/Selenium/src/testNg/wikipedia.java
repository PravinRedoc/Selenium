package testNg;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import org.testng.TestNGException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class wikipedia {
private WebDriver driver;

@BeforeTest
public void abc(){
	System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
	driver= new ChromeDriver();
	
}
@BeforeMethod
public void dec(){
	driver.get("https://www.wikipedia.org/");
	
}
@DataProvider(name="DP1")
public Object[][] data()
{
	Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/wikiSearch.xls", "Wiki", "Start");
    return(retObjArr);
	
}
@Test(dataProvider ="DP1")
public void dff(String Name) throws InterruptedException
{
	driver.findElement(By.xpath("html/body/div[2]/form/fieldset/div/input")).sendKeys(Name);
	Thread.sleep(1000);
	driver.findElement(By.xpath("html/body/div[2]/form/fieldset/button")).click();
	Thread.sleep(1000);
	if(isElementPresent(By.xpath("html/body/div[3]/div[3]/div[4]/div/p[1]")))
			{
	String Text=driver.findElement(By.xpath("html/body/div[3]/div[3]/div[4]/div/p[1]")).getText();
	System.out.println(Text);
			}
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

@AfterClass
public void ggg(){
 driver.quit();
}

private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}



