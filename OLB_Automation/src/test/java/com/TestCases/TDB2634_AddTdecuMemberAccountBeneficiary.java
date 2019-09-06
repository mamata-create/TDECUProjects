package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TDB2634_AddTdecuMemberAccountBeneficiary extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	
	/*
	 * TDB2634 - Verify add Tdecu member account beneficiary
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
	public void TDB2634_AddTdecuMemberAccountBeneficiary()throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Beneficiary";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Beneficiary", 0, startIter)))
				 {
					String acntNumber=excl.getCellData("Beneficiary", 1, startIter);
					String frstThreeChar=excl.getCellData("Beneficiary", 2, startIter);
					String nickname=excl.getCellData("Beneficiary", 3, startIter);
					//Click Transfer Pay 	
					getElement(ObjectRepository.transferPay).click();
					test.log(Status.INFO, "Transfer tab clicked" );
				//Select Transfer Money 	
					getElement(ObjectRepository.transferMoney).click();
					test.log(Status.INFO, "Transfer money link clicked" );
					Thread.sleep(5000);
					verifyElementPresent(ObjectRepository.transferscreentitle);
					test.log(Status.INFO, "Transfer screen title is verified" );
				//Click Continue button for MYTDECU Accounts	
					getElement(ObjectRepository.continuebtn_OtherTDECU).click();
					test.log(Status.INFO, "Continue button for Other TDECU account clicked" );
				//click add beneficiary link
					Thread.sleep(5000);
					getElement(ObjectRepository.addBenfLink).click();
					test.log(Status.INFO, "Add beneficiary link clicked" );
				//Enter account number
					getElement(ObjectRepository.benfAcntNumber).sendKeys(acntNumber);
					test.log(Status.INFO, "Beneficiary account number entered" );	
				//Enter again account number
					getElement(ObjectRepository.benfAcntNumberAgain).sendKeys(acntNumber);
					test.log(Status.INFO, "Beneficiary account number again entered" );	
					//Enter first three characters
					getElement(ObjectRepository.frstthreeChar).sendKeys(frstThreeChar);
					test.log(Status.INFO, "First Three Characters entered" );	
					
					//Enter nickname
					getElement(ObjectRepository.benfnickname).sendKeys(nickname);
					test.log(Status.INFO, "Nickname entered" );	
					
					//Click continue button
					getElement(ObjectRepository.continuebtn).click();
					test.log(Status.INFO, "Continue button clicked" );
					getElement(ObjectRepository.nextbtn).click();
					test.log(Status.INFO, "Next button clicked" );
					verifyElementPresent(ObjectRepository.benfsuccess);
					test.log(Status.INFO, "Add beneficiary success message appearing" );
				 }
			 }
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Verify add TDECU member account beneficiary scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
}

