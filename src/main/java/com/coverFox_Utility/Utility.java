package com.coverFox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	
	//readData from excel
	public static String readDataFromExcel(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException 
	{
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\Demo.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet(sheetName);
		String data = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("reading data from excel",true);
		return data;
		
	}
	
	
	//screenshot
	public static void takeScreenshot(WebDriver driver,String screenShotName) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File(System.getProperty("user.dir")+"\\screenshot"+screenShotName+".png");
		FileHandler.copy(src, des);
		Reporter.log("taking screenshot, saved at "+des, true);

		
	}
	
	
	//scroll into view
	public void  scrollIntoView(WebDriver driver,WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollintoView(true)", element);
		Reporter.log("scrolling into view",true);
	}
	
	
	public static String readDataFromPropertiesFile(String key) throws IOException 
	{
		Properties prop = new Properties();
		FileInputStream myFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\testData\\coverFox.properties");
		prop.load(myFile);
		String value=prop.getProperty(key);
		Reporter.log("Reading "+key+ "from properties file",true);
		return value;
	}

}
