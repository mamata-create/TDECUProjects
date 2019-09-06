package com.TestCases;

import java.awt.Point;
import java.net.MalformedURLException;
import java.util.Date;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class TDB2281_VerifyOnetimeMyTdecuAccountTransfer extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2281,TDB-2282,TDB-2290	
	 */
	@Test
	public void TDB2281_VerifyOnetimeMyTdecuAccountTransfer() throws InterruptedException{
	//to check if test case to be executed or not	
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
			//if test data for test case available in data sheet	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter))){
					//read data from excel	data sheet
					String frmAccnt=excl.getCellData(sheetName, 1,startIter);
					String toAccnt=excl.getCellData(sheetName, 2,startIter);
					String amnt=excl.getCellData(sheetName, 3,startIter);
					String desc=excl.getCellData(sheetName, 4,startIter);
					Thread.sleep(10000);
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
	//Select MyTDECU transfer type option
		getElement(ObjectRepository.mytdecu_lnk).click();
		test.log(Status.INFO, "My TDECU accounts transfer option selected");
	
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
		Thread.sleep(2000);
	//Select frequency as One time	
		getElement(ObjectRepository.onetime_opt).click();
		test.log(Status.INFO, "Continue button clicked from amount page");
		
		Thread.sleep(3000);
	//Click Continue button from start date page	
		getElement(ObjectRepository.continue_btn).click();
		test.log(Status.INFO, "Continue button clicked from start date page");
		Thread.sleep(2000);
	//Verify Confirm page , enter description and click Confirm	
		verifyElementPresent(ObjectRepository.confirmtrnsfr_ttl);
		getElement(ObjectRepository.desc_txt).sendKeys(desc);
		getElement(ObjectRepository.confirm_btn).click();
		test.log(Status.INFO, "Confirm button clicked from confirm transfer page after entering description");
		Thread.sleep(2000);
	//Verify Success message	
		//verifyElementPresent(ObjectRepository.success_msg);
		verifyElementPresent(ObjectRepository.maketransfer_lnk);
		
		//System.out.println(getElement(ObjectRepository.success_msg).getText());
		test.log(Status.INFO, "Transfer Success message appeared");
		
		getElement(ObjectRepository.menuitem_lnk).click();
		getElement(ObjectRepository.accounts_lnk).click();
		getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]").click();
		getElement("//android.widget.TextView[contains(@text,'"+desc+"') and @index='0']").click();		
//		verifyElementPresent(ObjectRepository.transactiondtls_ttl);
//		verifyElementPresent("//android.widget.TextView[contains(@text,'"+amnt+"')]");
//		//verifyElementPresent("//android.widget.TextView[contains(@text,'157610-70')]");
//		verifyElementPresent("//android.widget.TextView[contains(@text,'"+desc+"')]");
//		//verifyElementPresent("//android.widget.TextView[contains(@text,'01/31/2019')]");
//		verifyElementPresent(ObjectRepository.rpttrnsctn_btn);
//		verifyElementPresent(ObjectRepository.dspttrnsctn_btn);
				 }
			 }
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Onetime MYTDECU account transfer scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
