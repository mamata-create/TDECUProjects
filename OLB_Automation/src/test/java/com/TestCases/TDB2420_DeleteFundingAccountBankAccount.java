package com.TestCases;

import org.openqa.selenium.By;
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

public class TDB2420_DeleteFundingAccountBankAccount extends GenericKeywords {
	
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
	public void DeleteFundingAccountBankAccount() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "AddFundingAccount";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("AddFundingAccount", 0, startIter)))
				 {
					String dbtcardnmbr=excl.getCellData("AddFundingAccount", 8, startIter);
					
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
					getElement(ObjectRepository.mngfndacnt).click();
					test.log(Status.INFO, "Manage Funding Account link clicked" );
					Thread.sleep(5000);
//					verifyElementPresent(ObjectRepository.fndngacnttitle);
//					test.log(Status.INFO, "Funding Account screen title is verified" );
					
					WebElement parentEle=getElement("//div[@id='flxfundingAccountRowTemp_lblAccountNoVal' and contains(text(),'"+dbtcardnmbr+"')]/parent::*/parent::*");
					parentEle.findElement(By.xpath("//div[@id='flxfundingAccountRowTemp_lblActionVal']")).click();
					getElement(ObjectRepository.loanYes).click();
					test.log(Status.INFO, "Yes button clicked" );
					
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
			test.log(Status.PASS, "Verify Delete Funding Account(Bank Account) scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
