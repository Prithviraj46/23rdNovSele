package com.coverFox_POM;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxMemberDetailsPage {
	
	//1.variables
	@FindBy(name = "You") private WebElement ageDropDown;
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	
	//2.constructors
	public CoverFoxMemberDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3.methods
	public void handleAgeDropDown(String age) 
	{
		Select selectAge = new Select(ageDropDown);
		selectAge.selectByValue(age+"y");
	}
	
	public void clickOnNextButtonOfMemberDetails() 
	{
		Reporter.log("clicking on NextButton of MemberDetailsPage", true);
		nextButton.click();
	}

}
