package com.coverFox_Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.coverFox_Utility.Utility;

public class Base {
	
	protected static WebDriver driver;
	
	public void openBrowser() throws IOException 
	{
		driver = new ChromeDriver();
		driver.get(Utility.readDataFromPropertiesFile("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		Reporter.log("launching browser",true);
	}
	
	
	public void closeBrowserWindow() 
	{
		Reporter.log("closing Browser",true);
		driver.quit();
	}

}
