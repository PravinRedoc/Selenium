package testNg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.*; 

public class importxl {

	private WebDriver driver;
	
	@BeforeTest
	public void imdb(){
		System.setProperty("webdriver.chrome.driver", "src/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		
	}
	
    @DataProvider(name = "DP1")
    public Object[][] createData1() {
        Object[][] retObjArr=getTableArray("D:/CP-SAT Lab Requirements/DDT/movie_data.xls", "DataPool", "imdbTestData1");
        return(retObjArr);
    }
    
  
	

	@Test(dataProvider = "DP1")
	public void movie(String movieTitle, 
            String directorName, String moviePlot, String actorName) throws InterruptedException
	{
		driver.get("http://www.imdb.com/");
		
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/div/input[2]")).sendKeys(movieTitle);
		driver.findElement(By.xpath("html/body/div[1]/div/div[1]/div[2]/form/div/button")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[3]/div[1]/div/div[2]/table/tbody/tr[1]/td[2]/a")).click();
		Thread.sleep(10000);
		//String title=driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[5]/div[1]/div[2]/div/div[2]/div[2]/div/div[2]/div[2]/h1")).getText();
		String title=driver.findElement(By.xpath("//div[2]/h1")).getText();
		
		//String brief=driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[5]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[1]")).getText();
		//String direct=driver.findElement(By.xpath("html/body/div[1]/div/div[4]/div[5]/div[1]/div[2]/div/div[3]/div[2]/div[1]/div[2]/span/a/span")).getText();
		String brief=driver.findElement(By.xpath("//div[3]/div[2]/div/div")).getText();
		String direct=driver.findElement(By.xpath("//div[2]/span/a/span")).getText();
	for(int i=1;i<4;i++){
		String actor=driver.findElement(By.xpath("//div[4]/span["+i+"]/a/span")).getText();
		if(actorName.equalsIgnoreCase(actor))
		{
			assertEquals(actor, actorName);
			//System.out.println(actor+actorName);
			System.out.println("Actor present");
		}
		else
		{
			System.out.println(actor+actorName);
			System.out.println("Actor name not present");
		}
		
		
	}
		
		
		
	

		
		
		
	}
	
	@AfterTest
	public void little(){
		driver.quit();
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
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }
	
}
