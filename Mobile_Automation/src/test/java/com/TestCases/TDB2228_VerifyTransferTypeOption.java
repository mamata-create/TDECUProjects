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

public class TDB2228_VerifyTransferTypeOption extends GenericKeywords {

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
		Thread.sleep(20000);
	}
	
	/*
	 * Test Cases covered -- TDB-2228 - Verify Transfer Type option
	 */
	@Test
	public void TDB2228_VerifyTransferTypeOption() throws InterruptedException{
		if(continuetestcase==true)
		{	
							
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu Item Link clicked");
					Thread.sleep(2000);
				//Click transfer option
					getElement(ObjectRepository.transfer_lnk).click();
					test.log(Status.INFO, "Transfer Link clicked");
					Thread.sleep(2000);
				//Click Make transfer option
					getElement(ObjectRepository.maketransfer_lnk).click();
					test.log(Status.INFO, "Make Transfer Link clicked on transfer landing screen");
					Thread.sleep(2000);
				//Verify My TDECU Transfer type option
					verifyElementPresent(ObjectRepository.mytdecu_lnk);
					test.log(Status.INFO, "My TDECU transfer type option is available");
					
				//click back arrow and Verify make transfer option
					getElement(ObjectRepository.back_arrw).click();
					test.log(Status.INFO, "Back arrow clicked");
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.maketransfer_lnk);
					test.log(Status.INFO, "Make Transfer Link option available on transfer landing screen");
					
		}		
			
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Transfer type option scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
