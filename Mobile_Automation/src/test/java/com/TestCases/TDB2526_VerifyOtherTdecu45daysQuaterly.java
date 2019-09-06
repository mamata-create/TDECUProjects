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

public class TDB2526_VerifyOtherTdecu45daysQuaterly extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2256
	 */
	@Test
	public void TDB2526_VerifyOtherTdecu45daysQuaterly() throws InterruptedException{
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
				//click transfer link	
					getElement(ObjectRepository.transfer_lnk).click();
				//Click make transfer link
					getElement(ObjectRepository.maketransfer_lnk).click();
					test.log(Status.INFO, "Make transfer option selected");
					
					verifyElementPresent(ObjectRepository.transfertype_ttl);
					//Select Other TDECU transfer type option
						getElement(ObjectRepository.othertdecu_lnk).click();
						test.log(Status.INFO, "Other TDECU accounts transfer option selected");
					Thread.sleep(2000);
				//Select from account
					verifyElementPresent(ObjectRepository.frmaccount_ttl);
					getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]").click();
					test.log(Status.INFO, "From Account selected");
					Thread.sleep(2000);
				//Select To Account	
					verifyElementPresent(ObjectRepository.toaccount_ttl);
					getElement("//android.widget.TextView[contains(@text,'"+toAccnt+"')]").click();
					test.log(Status.INFO, "To Account selected");
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.trnsframnt_ttl);
			//amount entering and click Continue button 	
					Thread.sleep(2000);	
					enterAmount(amnt);
					test.log(Status.INFO, "Amount entered");
					Thread.sleep(2000);

					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from amount page");
					Thread.sleep(2000);
				//Select frequency as quarterly	
					getElement(ObjectRepository.quarterly_opt).click();
					test.log(Status.INFO, "Quarterly option selected");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.noOfRecurrences_opt).click();
					test.log(Status.INFO, "No of occurences option selected");
					Thread.sleep(3000);
					String noofoccurences = "02";
					enterAmount(noofoccurences);
					test.log(Status.INFO, "No of occurences entered");
					Thread.sleep(3000);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from no of occurences page");
					Thread.sleep(4000);
					
					
					selectFutureDateAfter45Days();
					Thread.sleep(2000);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from start date page");
					Thread.sleep(2000);
					verifyElementPresent(ObjectRepository.dayswarning);
					test.log(Status.INFO, "45days warning appearing");
					getElement(ObjectRepository.CONTINUE_btn).click();
					test.log(Status.INFO, "Continue button clicked from 45days warning");

			
					selectFutureDate45Days();
					test.log(Status.INFO, "Start date till 45 days selected");
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from start date page");
					verifyElementPresent(ObjectRepository.confirmtrnsfr_ttl);
					test.log(Status.INFO, "Confirmation screen appearing");
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
			test.log(Status.PASS, "Verify Quarterly OTHERTDECU account transfer 45days scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
