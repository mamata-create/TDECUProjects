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

public class TDB3538_DeleteTdecuMemberAccountBeneficiary extends GenericKeywords {
	
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
	public void DeleteTdecuMemberAccountBeneficiary()throws InterruptedException{
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
				
					getElement(ObjectRepository.acntlnk).click();
					test.log(Status.INFO, "Account link clicked" );
					
					scrollToElement("//div[contains(text(),'"+nickname+"')]");
					test.log(Status.INFO, "Scrolled to account" );
					
					WebElement parentEle=getElement("//div[contains(text(),'"+nickname+"')]/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*/parent::*");
					System.out.println("Parent Element id is - "+parentEle.getAttribute("index"));
					String ind=parentEle.getAttribute("index");
					driver.findElement(By.xpath("//li[@index='"+ind+"']//div[@id='flxExternalAccountsTransfersM2MUnselected_flxDropdown']")).click();
					test.log(Status.INFO, "Click arrow against the beneficiary row to expand" );
					Thread.sleep(6000);
					getElement(ObjectRepository.rcpntdel_btn).click();
					test.log(Status.INFO, "Delete link clicked for beneficiary" );
					
					getElement(ObjectRepository.popUpYes).click();
					test.log(Status.INFO, "Yes button clicked from the delete beneficiary confirmation popup" );
					Thread.sleep(6000);
					
					
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
			test.log(Status.PASS, "Verify Delete TDECU member account beneficiary scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
}

