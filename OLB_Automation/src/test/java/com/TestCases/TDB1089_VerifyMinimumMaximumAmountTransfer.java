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

public class TDB1089_VerifyMinimumMaximumAmountTransfer extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDb1089 - Verify Minimum & Maximum Transfer
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
	public void TDB1089_VerifyMinimumMaximumAmountTransfer() throws InterruptedException
	{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmAcnt=excl.getCellData("Data", 1, startIter);
					String toAcnt=excl.getCellData("Data", 2, startIter);
					String amnt=excl.getCellData("Data", 3, startIter);
					String desc=excl.getCellData("Data", 4, startIter);
					
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
					getElement(ObjectRepository.continuebtn_MyTDECU).click();
					test.log(Status.INFO, "Continue button for MY TDECU account clicked" );
				//Select From Account	
					verifyElementPresent(ObjectRepository.fromacntdroparw);
					getElement(ObjectRepository.fromacntdroparw).click();
					
					getElement("//div[contains(text(),'"+frmAcnt+"')]").click();
					test.log(Status.INFO, "From Account selected" );
				//Select To Account	
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,500)");
					Thread.sleep(3000);
					getElement(ObjectRepository.toacntdroparw).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[@kcontainerid='segRecipientName' and contains(text(),'"+toAcnt+"')]")).click();
					test.log(Status.INFO, "To Account selected" );
					
				//Enter Amount
		WebElement amounttxt=getElement(ObjectRepository.amount_txt);
		test.log(Status.INFO, "Amount" );
		amounttxt.clear();
		test.log(Status.INFO, "Amount field made empty" );
	//Verify amount field when minimum entered	
		amounttxt.sendKeys(Keys.TAB);
		WebElement confirmbtn=getElement(ObjectRepository.maketransfer_btn);
		Thread.sleep(5000);
		String elementdisabled=confirmbtn.getAttribute("kdisabled");
		Assert.assertEquals(elementdisabled, "true");
		test.log(Status.INFO, "Make Transfer button is disabled when amount not entered");
	//Verify amount field when greater than minimum amount entered	
		amounttxt.sendKeys("1.9");
		test.log(Status.INFO, "Amount entered greater than minimum amount" );
		amounttxt.sendKeys(Keys.TAB);
		String eledisable=confirmbtn.getAttribute("kdisabled");
		Assert.assertEquals(eledisable, "false");
		test.log(Status.INFO, "Make Transfer button is enabled when more than minimum amount entered");
		Thread.sleep(2000);
		amounttxt.clear();
	//Verify amount field when more than maximum allowed limit entered
		amounttxt.sendKeys("11000");
		test.log(Status.INFO, "Amount entered greater than maximum amount" );
		amounttxt.sendKeys(Keys.TAB);
		getElement(ObjectRepository.maketransfer_btn).click();
		Thread.sleep(2000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(3000);
		String warningMsg=getElement(ObjectRepository.frmaccntwarning).getText();
		if(warningMsg.contains("You have entered a transfer amount that exceeds the maximum amount allowed for the selected from account")){
			Assert.assertTrue(true);
			test.log(Status.PASS, "Correct warning message appears when amount more than maximum entered");
		}else{
			Assert.assertTrue(false);
			test.log(Status.FAIL, "InCorrect warning message appears when amount more than maximum entered");
		}
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
			test.log(Status.PASS, "Monthly TDECU account transfer scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
		
	}
}
