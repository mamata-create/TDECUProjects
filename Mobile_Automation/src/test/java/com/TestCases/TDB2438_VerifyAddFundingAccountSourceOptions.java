package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2438_VerifyAddFundingAccountSourceOptions extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2438
	 */
	@Test
	public void TDB2438_VerifyAddFundingAccountSourceOptions() throws InterruptedException{
		if(continuetestcase==true)
		{
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu item clicked");
				//click Make a loan payment link	
					getElement(ObjectRepository.makeloanpaymnt_lnk).click();
					test.log(Status.INFO, "Make a loan payment clicked");
					
				//Click Add/Edit Accounts link
					getElement(ObjectRepository.addedtacnt_lnk).click();
					test.log(Status.INFO, "Add/Edit Accounts link clicked");

					//Click Add Funding Account link
						getElement(ObjectRepository.addfndgacnt_btn).click();
						test.log(Status.INFO, "Add Funding Account button clicked");
						
					verifyElementPresent(ObjectRepository.addfndgacnt_ttl);
					test.log(Status.INFO, "Add Funding Account page opened");
					
					verifyElementPresent(ObjectRepository.bnkacnt_opt);
					test.log(Status.INFO, "Add Funding Account- bank account option appearing");
				
					verifyElementPresent(ObjectRepository.dbtcrd_opt);
					test.log(Status.INFO, "Add Funding Account- Debit Card option appearing");
					Thread.sleep(2000);
		}
			
	}


	

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());		
		}else
		{
			test.log(Status.PASS, "Verify Add Funding Account Source Options scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
