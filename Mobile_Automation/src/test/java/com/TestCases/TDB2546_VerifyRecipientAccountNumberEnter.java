package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2546_VerifyRecipientAccountNumberEnter extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2546 - Verify Recipient Account Number Enter
	 */
	@Test
	public void TDB2546_VerifyRecipientAccountNumberEnter() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				{
					//read data from excel	
					String frmAccnt=excl.getCellData(sheetName, 1,startIter);
					String toAccnt=excl.getCellData(sheetName, 2,startIter);
					String amnt=excl.getCellData(sheetName, 3,startIter);
					String desc=excl.getCellData(sheetName, 4,startIter);
					
							
					//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu Item Link clicked");
				//click transfer link	
					getElement(ObjectRepository.transfer_lnk).click();
					test.log(Status.INFO, "Transfer link clicked");
				//Click make transfer link
					getElement(ObjectRepository.maketransfer_lnk).click();
					test.log(Status.INFO, "Make transfer option selected");
					
					verifyElementPresent(ObjectRepository.transfertype_ttl);
					
					getElement(ObjectRepository.othertdecu_lnk).click();
					test.log(Status.INFO, "Other TDECU accounts transfer option selected");
				
				//Select from account
					verifyElementPresent(ObjectRepository.frmaccount_ttl);
					getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]").click();
					test.log(Status.INFO, "From Account selected");
				//Select To Account	
					verifyElementPresent(ObjectRepository.toaccount_ttl);
					test.log(Status.INFO, "To Account page appears");
					
					getElement(ObjectRepository.addacnt_btn).click();
					test.log(Status.INFO, "Add beneficiary Account button clicked on To Account page");
					
					verifyElementPresent(ObjectRepository.rcpnt_ttl);
					test.log(Status.INFO, "Add Beneficiary account number page opened");
					
					Assert.assertFalse(getElement(ObjectRepository.continue_btn).isEnabled());
					test.log(Status.INFO, "Continue button disable when account number not entered");
					
					
					enterDate("1");
					test.log(Status.INFO, "One digit of Beneficiary account number entered");

					Assert.assertTrue(getElement(ObjectRepository.continue_btn).isEnabled());
					test.log(Status.INFO, "Continue button enabled when one digit beneficiary account number entered");
					
					getElement(ObjectRepository.rcpntnmbr_txt).clear();
					test.log(Status.INFO, "Beneficiary account number cleared");
					
					enterDate("123456789");
					test.log(Status.INFO, "Non TDECU Beneficiary account number entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
					verifyElementPresent(ObjectRepository.rcpnt_err);
					test.log(Status.INFO, "Error appears for Adding non TDECU beneficiary account number");
					
				}
			 }
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify recipient account number enter scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
