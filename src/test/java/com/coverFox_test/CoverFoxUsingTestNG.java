package com.coverFox_test;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.coverFox_Base.Base;
import com.coverFox_POM.CoverFoxAddressDetailsPage;
import com.coverFox_POM.CoverFoxHealthPage;
import com.coverFox_POM.CoverFoxHomePage;
import com.coverFox_POM.CoverFoxMemberDetailsPage;
import com.coverFox_POM.CoverFoxResultPage;
import com.coverFox_Utility.Utility;


public class CoverFoxUsingTestNG extends Base { 
	
	public static Logger logger;
	CoverFoxHomePage coverFoxHomePage;
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage;
	CoverFoxAddressDetailsPage coverFoxAddressDetailsPage;
	CoverFoxHealthPage coverFoxHealthPlanPage;
	CoverFoxResultPage coverFoxResultPage;

	@BeforeClass
	public void launchBrowser() throws EncryptedDocumentException, IOException {
		  logger= Logger.getLogger("23rdNov24_CoverFox");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Welcome to CoverFox Testing");
		  
		  
		  
		openBrowser();
		logger.warn("Launching browser");
		coverFoxHomePage = new CoverFoxHomePage(driver);
		coverFoxAddressDetailsPage = new CoverFoxAddressDetailsPage(driver);
		coverFoxMemberDetailsPage = new CoverFoxMemberDetailsPage(driver);
		coverFoxHealthPlanPage = new CoverFoxHealthPage(driver);
		coverFoxResultPage = new CoverFoxResultPage(driver);

	}

	@BeforeMethod
	public void coverFoxPreconditions() throws InterruptedException, EncryptedDocumentException, IOException {
		coverFoxHomePage.clickOnGender();
		logger.info("Clicking on gender");
		coverFoxHealthPlanPage.clickOnNextButtonHealthPlanPage();
		logger.info("clickOnNextButtonHealthPlanPage");
		coverFoxMemberDetailsPage.handleAgeDropDown(Utility.readDataFromExcel("Sheet1", 1, 0));
		logger.info("handleAgeDropDown");
		coverFoxMemberDetailsPage.clickOnNextButtonOfMemberDetails();
		logger.info("clickOnNextButtonOfMemberDetails");
        coverFoxAddressDetailsPage.enterPinCode(Utility.readDataFromExcel("Sheet1", 1, 1));
        logger.info("enterPinCode");
		coverFoxAddressDetailsPage.enterMobileNumber(Utility.readDataFromExcel("Sheet1", 1, 2));
		logger.info("enterMobileNumber");
		coverFoxAddressDetailsPage.clickOnContinueButton();
		logger.info("clickOnContinueButton");
		Thread.sleep(4000);
	}

	@Test
	public void validateCoverFoxPlans() throws IOException {

        //Assert.fail();
		int planNumberFromText = coverFoxResultPage.getPlanNumberFromText();
		int planNumberFromCards = coverFoxResultPage.getPlanNumberFromPlanCards();
        logger.info("validating CoverFoxPlans");
		Assert.assertEquals(planNumberFromText, planNumberFromCards, "Test case failed, number are not matching");
		Reporter.log("Plan number are matching TC is passed", true);
		Reporter.log("My First change", true);
		Reporter.log("My Second change", true);
		Reporter.log("My Third change", true);
		//Utility.takeScreenshot(driver, "validateCoverFoxPlans");

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("closing browser");
		closeBrowserWindow();
	}

}
