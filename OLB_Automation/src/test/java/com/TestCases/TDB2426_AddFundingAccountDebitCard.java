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

public class TDB2426_AddFundingAccountDebitCard extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB2426 - Add Funding Account(Debit card)
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
	public void TDB2426_AddFundingAccountDebitCard() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				 {
					String acntnickname=excl.getCellData("AddFundingAccount", 5, startIter);
					String state=excl.getCellData("AddFundingAccount", 6, startIter);
					String zip=excl.getCellData("AddFundingAccount", 7, startIter);
					String dbtcardnmbr=excl.getCellData("AddFundingAccount", 8, startIter);
					String nameoncard=excl.getCellData("AddFundingAccount", 9, startIter);
					String expmnth=excl.getCellData("AddFundingAccount", 10, startIter);
					String expyr=excl.getCellData("AddFundingAccount", 11, startIter);
					String cvv=excl.getCellData("AddFundingAccount", 12, startIter);
		
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
					
					
					verifyElementPresent(ObjectRepository.debitcardopt);
					test.log(Status.INFO, "debit card option is verified" );
					
					getElement(ObjectRepository.debitcardradiobtn).click();
					test.log(Status.INFO, "Debit card radio button clicked" );
					
					getElement(ObjectRepository.debitcardnmbr).sendKeys(dbtcardnmbr);
					test.log(Status.INFO, "Debit card number entered" );
					
					getElement(ObjectRepository.nameoncard).sendKeys(nameoncard);
					test.log(Status.INFO, "Name on card entered" );
					
					selectDropdownOpt(ObjectRepository.month, expmnth);
					test.log(Status.INFO, "Expiry month selected" );
					
					selectDropdownOpt(ObjectRepository.year, expyr);
					test.log(Status.INFO, "Expiry year selected" );
					
					getElement(ObjectRepository.cvv).sendKeys(cvv);
					test.log(Status.INFO, "CVV entered" );
					
					scrollToElement(ObjectRepository.loancontinuebtn);
					
					selectDropdownOpt(ObjectRepository.debitcardstate, state);
					test.log(Status.INFO, "State selected" );
					
					getElement(ObjectRepository.debitcardzip).sendKeys(zip);
					test.log(Status.INFO, "ZIP code entered" );
					
					getElement(ObjectRepository.debitacntnickname).sendKeys(acntnickname);
					test.log(Status.INFO, "Account nickname entered" );
					
					getElement(ObjectRepository.loancontinuebtn).click();
					test.log(Status.INFO, "Continue button clicked" );
					
					getElement(ObjectRepository.loanconfirmbtn).click();
					test.log(Status.INFO, "Confirm button clicked" );
					
					verifyElementPresent(ObjectRepository.addfundacntmsg);
					test.log(Status.INFO, "Funding account using debit card option added successfully" );
					
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
			test.log(Status.PASS, "Verify Add Funding Account(Debit card) scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
