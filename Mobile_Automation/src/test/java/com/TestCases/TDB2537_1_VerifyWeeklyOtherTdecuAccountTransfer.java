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

public class TDB2537_1_VerifyWeeklyOtherTdecuAccountTransfer extends GenericKeywords {

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
		Thread.sleep(10000);
	}
	
	
	/*
	 * Test Cases covered -- TDB-2537_1 Verify Weekly other TDECU Account Transfer	
	 */
	@Test
	public void TDB2537_1_VerifyWeeklyOtherTdecuAccountTransfer() throws InterruptedException{
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
					String noofoccurences=excl.getCellData(sheetName, 5,startIter);
		
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
				
				//Select from account
					verifyElementPresent(ObjectRepository.frmaccount_ttl);
					getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]").click();
					test.log(Status.INFO, "From Account selected");
				//Select To Account	
					verifyElementPresent(ObjectRepository.toaccount_ttl);
					getElement("//android.widget.TextView[contains(@text,'"+toAccnt+"')]").click();
					test.log(Status.INFO, "To Account selected");
					
					verifyElementPresent(ObjectRepository.trnsframnt_ttl);
			//amount entering and click Continue button 	
					Thread.sleep(2000);	
					enterAmount(amnt);
					test.log(Status.INFO, "Amount entered");
					Thread.sleep(2000);

					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked from amount page");
					Thread.sleep(2000);
					
		getElement(ObjectRepository.weekly_opt).click();
		
	test.log(Status.INFO, "Transfer frequency as weekly selected");
		Thread.sleep(3000);
		
		getElement(ObjectRepository.noOfRecurrences_opt).click();
		test.log(Status.INFO, "No of occurences option selected");
		Thread.sleep(3000);
		enterAmount(noofoccurences);
		test.log(Status.INFO, "No of occurences entered");
		Thread.sleep(4000);
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from no of occurences page");
		Thread.sleep(4000);
		//Click Continue button from Start date page	
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from start date page");
		Thread.sleep(2000);
	//Verify Confirm page , enter description and click Confirm		
		verifyElementPresent(ObjectRepository.confirmtrnsfr_ttl);
		getElement(ObjectRepository.desc_txt).sendKeys(desc);
		getElement(ObjectRepository.confirm_btn).click();
		test.log(Status.INFO, "Confirm button clicked from confirm transfer page after entering description");
		Thread.sleep(2000);
		verifyElementPresent(ObjectRepository.maketransfer_lnk);
		test.log(Status.INFO, "Make Transfer link page appears after successful transfer");
		
		
		getElement(ObjectRepository.menuitem_lnk).click();
		Thread.sleep(2000);
		getElement(ObjectRepository.accounts_lnk).click();
		Thread.sleep(2000);
		getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]").click();
		Thread.sleep(2000);
		getElement("//android.widget.TextView[contains(@text,'"+desc+"') and @index='0']").click();	
		Thread.sleep(2000);
		verifyElementPresent(ObjectRepository.transactiondtls_ttl);
		verifyElementPresent("//android.widget.TextView[contains(@text,'"+amnt+"')]");
		verifyElementPresent("//android.widget.TextView[contains(@text,'"+desc+"')]");
		//verifyElementPresent("//android.widget.TextView[contains(@text,'01/31/2019')]");
		//verifyElementPresent(ObjectRepository.rpttrnsctn_btn);
		verifyElementPresent(ObjectRepository.dspttrnsctn_btn);
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
			test.log(Status.PASS, "Weekly Other TDECU account transfer scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
