package testNg;

import java.io.File;

import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class writeToexcel {
private WebDriver driver;
private WebDriverWait wait; 
Workbook workbook;
WritableSheet sheet;
WritableWorkbook workbookcopy;
	
	@BeforeTest
	public void order(){
		//System.setProperty("webdriver.gecko.driver", "src/resources/drivers/geckodriver.exe");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		
		
	}
	
	@BeforeMethod
	public void def() throws InterruptedException{
		driver.get("https://www.tatacliq.com/");
		Thread.sleep(3000);

	}
	
	
	 @DataProvider(name = "DP1")
	    public Object[][] createData1() {
	        Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/mobile.xls", "eb", "name");
	        return(retObjArr);
	    }
	 
	 public String[][] getTableArray(String xlFilePath, String sheetName, String tableName){
	        String[][] tabArray=null;
	        try{
	        	 workbook = Workbook.getWorkbook(new File(xlFilePath));
	           workbookcopy =Workbook.createWorkbook(new File("D:/CP-SAT Lab Requirements/DDT/mobile1copy.xls"),workbook);
	            		
	            
	            WritableSheet sheet=workbookcopy.getSheet(0);
	            
	        	//Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
	            //Sheet sheet = workbook.getSheet(sheetName);
	            
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
	 int j=1;
	 public void write(String str,int a,int b)
	 {
		 WritableSheet wshtemp=workbookcopy.getSheet(0);
		 Label col=new Label(a, b, str);
		 try {
	            wshtemp.addCell(col);
	             } 
	            catch (Exception e) 
	            {
	                e.printStackTrace();
	            }
	    }
	    
	    public void closeFile()
	    {
	        try {
	            // Closing the writable work book
	        	workbookcopy.write();
	        	workbookcopy.close();

	            // Closing the original work book
	        	workbookcopy.close();
	        } catch (Exception e)

	        {
	            e.printStackTrace();
	        }
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
		
		
		String a;
		
		@Test(dataProvider="DP1")
		public void test11(String brand) throws InterruptedException
		{j=j+1;
			driver.findElement(By.xpath("html/body/main/header/div[2]/div[4]/div/div[3]/div/form/input[1]")).sendKeys(brand);
			driver.findElement(By.xpath("html/body/main/header/div[2]/div[4]/div/div[3]/div/form/input[1]")).sendKeys(Keys.ENTER);
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/main/div[11]/div/div/div[1]/div/div[3]/ul/li[1]/div/div[2]/div[3]/p[2]/span/span")));
			Thread.sleep(3000);
			
			System.out.println("Search results"+brand);
			for(int i=1;i<=4;i++)
			{
				a=driver.findElement(By.xpath("html/body/main/div[11]/div/div/div[1]/div/div[3]/ul/li["+(i+1)+"]/div/div[2]/div[3]/p[2]/span/span")).getText();
				System.out.println(a);
				write(a,j,(i+1));
				closeFile();
			
				
			}
			

		}
	 
}
