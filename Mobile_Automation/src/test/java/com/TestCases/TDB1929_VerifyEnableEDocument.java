package com.TestCases;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.MobileBy;

public class TDB1929_VerifyEnableEDocument extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws MalformedURLException, InterruptedException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, "Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from device registration page");
	}
	
	/*
	 * Test Cases covered -- TDB-1929
	 */
	@Test
	public void TDB1929_VerifyEnableEDocument() throws InterruptedException{
		if(continuetestcase==true)
		{
		
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");	
					
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu Item link clicked");
					Thread.sleep(3000);
					//scroll to Settings link
					WebElement ele=driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                            + "new UiSelector().text(\"Settings\"));"));
					Thread.sleep(3000);
					test.log(Status.INFO, "Scrolled to settings link");
					
					ele.click();
					test.log(Status.INFO, "Settings link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.edoc_lnk).click();
					test.log(Status.INFO, "E-Documents link clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.enble_btn);
					getElement(ObjectRepository.enble_btn).click();
					test.log(Status.INFO, "Enable E-Documents button clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.tnc_ttl);
					verifyElementPresent(ObjectRepository.accpt_btn);
					getElement(ObjectRepository.accpt_btn).click();
					test.log(Status.INFO, "Accept button clicked for confirming Enable E-Documents");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.sttmnts_lnk);
					test.log(Status.INFO, "Statements option appears after enabling e-documents");
		}
	}


	

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());		
		}else
		{
			test.log(Status.PASS, "Verify Enable E-Documents scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}

