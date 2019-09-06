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

public class TDB2434_2_DeleteFundingAccountBankAccount extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2434_2
	 */
	@Test
	public void TDB2440_AddFundingAccountDebitCard() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				{
					String acntnmbr=excl.getCellData("AddFundingAccount", 3, startIter);
		
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
					Thread.sleep(5000);

				//Click Add Funding Account link
					getElement("//android.widget.TextView[contains(@text,'"+acntnmbr+"')]/parent::*").click();
					test.log(Status.INFO, "Add Funding Account button clicked");
					
					getElement(ObjectRepository.delete_btn).click();
					test.log(Status.INFO, "Delete button clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.yes_btn).click();
					test.log(Status.INFO, "Yes button clicked from delete funding confirmation popup");
					Thread.sleep(3000);
					

					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.addfndgacnt_btn);
					test.log(Status.INFO, "Funding Bank account deleted successfully");
					
					
				}	
				
			 }
		}
	}


	

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());		
		}else
		{
			test.log(Status.PASS, "Verify Delete Funding Account Bank Account scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
