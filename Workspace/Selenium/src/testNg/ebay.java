package testNg;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ebay {

	private WebDriver driver;
	
	
	@BeforeTest
	public void order(){
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void def(){
		driver.get("https://www.ebay.in");

	}
	
	
	 @DataProvider(name = "DP1")
	    public Object[][] createData1() {
	        Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/mobile.xls", "eb", "name");
	        return(retObjArr);
	    }
	 
	 @Test(dataProvider = "DP1")
		public void movie(String mobileName) throws InterruptedException{
		 driver.findElement(By.xpath("html/body/div[3]/div/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[1]/div[1]/div/input")).sendKeys(mobileName);
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath("html/body/div[3]/div/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[3]/input")).click();
		 Thread.sleep(2000);

		 String a=driver.findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div/div[1]/div/div[2]/div/div/span[1]")).getText();
		 System.out.println(a);

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


	    

