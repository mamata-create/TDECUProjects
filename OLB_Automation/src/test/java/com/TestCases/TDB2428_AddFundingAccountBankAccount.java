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

public class TDB2428_AddFundingAccountBankAccount extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB2424 - Verify Add Funding Account(BankAccount)
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
	public void TDB2428_AddFundingAccountBankAccount() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				 {
					String acnttype=excl.getCellData("AddFundingAccount", 1, startIter);
					String routingnmbr=excl.getCellData("AddFundingAccount", 2, startIter);
					String acntnmbr=excl.getCellData("AddFundingAccount", 3, startIter);
					String acntholder=excl.getCellData("AddFundingAccount", 4, startIter);
					String acntnickname=excl.getCellData("AddFundingAccount", 5, startIter);
					String state=excl.getCellData("AddFundingAccount", 6, startIter);
					String zip=excl.getCellData("AddFundingAccount", 7, startIter);
					
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
					
					selectDropdownOpt(ObjectRepository.acnttype, acnttype);
					test.log(Status.INFO, "Account type selected" );
					
					getElement(ObjectRepository.routingnmbr).sendKeys(routingnmbr);
					test.log(Status.INFO, "Routing Number entered" );
					
					getElement(ObjectRepository.acntnmbr).sendKeys(acntnmbr);
					test.log(Status.INFO, "Account Number entered" );
					
					getElement(ObjectRepository.acntholder).sendKeys(acntholder);
					test.log(Status.INFO, "Account Holder Name entered" );
					
					getElement(ObjectRepository.acntnickname).sendKeys(acntnickname);
					test.log(Status.INFO, "Account Nickname entered" );
					
					selectDropdownOpt(ObjectRepository.state, state);
					test.log(Status.INFO, "State selected" );
					
					getElement(ObjectRepository.zipcode).sendKeys(zip);
					test.log(Status.INFO, "Zip code entered" );
					
					getElement(ObjectRepository.loancontinuebtn).click();
					test.log(Status.INFO, "Continue button clicked" );
					
					getElement(ObjectRepository.loanconfirmbtn).click();
					test.log(Status.INFO, "Confirm button clicked" );
					
					verifyElementPresent(ObjectRepository.addfundacntmsg);
					test.log(Status.INFO, "Funding account using bank account option added successfully" );
					
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
			test.log(Status.PASS, "Verify Add Funding Account(Bank Account) scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
