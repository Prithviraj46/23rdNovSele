package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHealthPage {
	
	//1.variables
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	
	//2.constructors
	public CoverFoxHealthPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3.methods
	public void clickOnNextButtonHealthPlanPage() 
	{
		Reporter.log("clicking on next button of health plan page",true);
		nextButton.click();
	}

}
