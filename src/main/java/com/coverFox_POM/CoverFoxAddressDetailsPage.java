package com.coverFox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAddressDetailsPage {
	
	//1.variables
	@FindBy(className = "mp-input-text") private WebElement pinCodeField;
	@FindBy(id = "want-expert") private WebElement mobileNumberField;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement continueButton;
	
	
	//2.constructors
	public CoverFoxAddressDetailsPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//3.methods
	public void enterPinCode(String pinCode) 
	{
		Reporter.log("Entering pincode", true);
		pinCodeField.sendKeys(pinCode);
	}
	
	public void enterMobileNumber(String mobileNumber) 
	{
		Reporter.log("Entering mobile number", true);
		mobileNumberField.sendKeys(mobileNumber);
	}
	
	public void clickOnContinueButton() 
	{
		Reporter.log("Clicking on Continue Button", true);
		continueButton.click();
	}

}
