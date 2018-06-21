package testNg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.TestNGException;

import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class google_write {
	
	private WebDriverWait wait;
	private WebDriver driver;
	
	@BeforeMethod
	public void before() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);

		}
	
	@DataProvider(name = "DP1")
    public Object[][] createData1() {
        Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/SearchKeywords_JXL.xls", "DataPool", "testData1");
        return(retObjArr);
    }
 
 public void write(String xlFilePath, String sheetName, String searchKeyword,String resultCount) throws RowsExceededException, WriteException, JXLException{
        try{
        	 Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
           WritableWorkbook writeableWB =Workbook.createWorkbook(new File("D:/CP-SAT Lab Requirements/DDT/SearchKeywords_JXL1.xls"),workbook);
           
           WritableSheet sheet=writeableWB.getSheet(sheetName);
           Cell keyCell=sheet.findCell(searchKeyword);
           
           int keyRow=keyCell.getRow();
           int keyCol=keyCell.getColumn();


           Label label=new Label((keyCol+1),keyRow,resultCount);
           sheet.addCell(label);
           writeableWB.write();
           writeableWB.close();
           
           
           
        }
        catch (FileNotFoundException e)    {
            e.printStackTrace();
        }catch(IOException e)
        {
        	e.printStackTrace();
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
	

	
	@Test(dataProvider="DP1")
	public void test111(String searchkeyword) throws InterruptedException, RowsExceededException, WriteException, JXLException
	{Thread.sleep(5000);
	System.out.println(searchkeyword);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[3]")).sendKeys(searchkeyword);
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[1]/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/div/input[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		String a=driver.findElement(By.xpath("html/body/div[6]/div[3]/div[7]/div[1]/div[1]/div/div/div")).getText();
		System.out.println(a);
		int i=a.indexOf("results");
		String b=a.substring(6,i-1);
		System.out.println(b);
		write("D:/CP-SAT Lab Requirements/DDT/SearchKeywords_JXL.xls","DataPool",searchkeyword,b);
		


	}
	
	@AfterMethod
	public void after() throws InterruptedException
	{ Thread.sleep(2000);
		driver.quit();
	}
}
