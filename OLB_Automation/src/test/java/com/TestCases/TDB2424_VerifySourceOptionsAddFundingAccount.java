package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TDB2424_VerifySourceOptionsAddFundingAccount  extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB2424 - Verify Source Options Add Funding Account
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
	public void TDB2424_VerifySourceOptionsAddFundingAccount() throws InterruptedException
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
				//Click Add Funding Account link	
					getElement(ObjectRepository.addfndngacnt).click();
					test.log(Status.INFO, "Add Funding Account link clicked" );
					Thread.sleep(5000);
					verifyElementPresent(ObjectRepository.fndngacnttitle);
					test.log(Status.INFO, "Add Funding Account screen title is verified" );
					
					verifyElementPresent(ObjectRepository.bnkacntopt);
					test.log(Status.INFO, "Bank account option is verified" );
					verifyElementPresent(ObjectRepository.debitcardopt);
					test.log(Status.INFO, "debit card option is verified" );
					String bankaccountopt=getElement(ObjectRepository.bnkacntradiobtn).getAttribute("src");
					System.out.println("Bank Account class is -"+bankaccountopt);
					if(bankaccountopt.contains("radiobtnon")){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Bank Account option verified as selected" );
					}else{
						Assert.assertTrue(false);
					}
				
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Verify Source Options Add Funding Account scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
