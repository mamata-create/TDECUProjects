package com.TestCases;

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

public class TDB3243_VerifyRecurringPaymentTab extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB3243 - Verify Recurring Payment tab
	 */

	@BeforeTest
	public void setUp(){
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated" );
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Username and Password entered" );
		getElement(ObjectRepository.login_btn).click();
		Assert.assertTrue(getElement(ObjectRepository.logout_lnk).isDisplayed());
		test.log(Status.INFO, "User logged in successfully" );
	}
	
	@Test
	public void TDB3243_VerifyRecurringPaymentTab() throws InterruptedException
	{
		if(continuetestcase==true)
		{
					//Click Transfer Pay 				
					getElement(ObjectRepository.transferPay).click();
					test.log(Status.INFO, "Transfer tab clicked" );
				//Select Make a Loan Payment option 	
					getElement(ObjectRepository.makeloanpayment).click();
					test.log(Status.INFO, "Make a Loan Payment link clicked" );
					Thread.sleep(5000);
					verifyElementPresent(ObjectRepository.loanscreentitle);
					test.log(Status.INFO, "Make a loan payment screen title is verified" );
					
					verifyElementPresent(ObjectRepository.rcrngpymnttab);
					test.log(Status.INFO, "Recurring Payment tab is verified" );
					
					getElement(ObjectRepository.rcrngpymnttab).click();
					test.log(Status.INFO, "Recurring Payment tab clicked" );
					Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.trnsctndtcol);
					test.log(Status.INFO, "Transaction date column available in grid" );
					verifyElementPresent(ObjectRepository.acntnamecol);
					test.log(Status.INFO, "Account name column available in grid" );
					verifyElementPresent(ObjectRepository.amntcol);
					test.log(Status.INFO, "Amount column available in grid" );
					verifyElementPresent(ObjectRepository.sttscol);
					test.log(Status.INFO, "Status column available in grid" );
					
					getElement(ObjectRepository.rwexpand).click();
					test.log(Status.INFO, "First row expand clicked" );
					
					verifyElementPresent(ObjectRepository.frmacntttl);
					test.log(Status.INFO, "From Account available in grid" );
					verifyElementPresent(ObjectRepository.trnsfrfrqncytypttl);
					test.log(Status.INFO, "Transfer Frequency available in grid" );
					verifyElementPresent(ObjectRepository.frqncytypttl);
					test.log(Status.INFO, "Frequency Type available in grid" );
					verifyElementPresent(ObjectRepository.nxtschdlpymntttl);
					test.log(Status.INFO, "Next Scheduled Payment available in grid" );
					verifyElementPresent(ObjectRepository.edtpymnt);
					test.log(Status.INFO, "Edit button available in grid" );
					verifyElementPresent(ObjectRepository.cnclpymnt);
					test.log(Status.INFO, "Cancel button available in grid" );
		}
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Verify recurring payment tab scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
