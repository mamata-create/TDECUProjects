package com.TestCases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class TDB1734_VerifyCancellingMyTdecuTransfer extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;
/*
 * TDB-1734
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
	public void TDB1734_VerifyCancellingMyTdecuTransfer() throws InterruptedException{
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
					String amnt=randomAmount();
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
		Thread.sleep(5000);
		getElement(ObjectRepository.toacntdroparw).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[@kcontainerid='segRecipientName' and contains(text(),'"+toAcnt+"')]")).click();
		test.log(Status.INFO, "To Account selected" );
		
	//Enter Amount
		getElement(ObjectRepository.amount_txt).clear();
		test.log(Status.INFO, "Amount" );
		getElement(ObjectRepository.amount_txt).sendKeys(amnt);
		test.log(Status.INFO, "Amount entered greater than minimum amount" );
	//Select Frequency as Once	
		verifyDropdownSelection(ObjectRepository.frequencydrop,"Once");
		test.log(Status.INFO, "Frequency selected as Once" );
	
		getElement(ObjectRepository.cncltrnsfr).click();
		test.log(Status.INFO, "Cancel button clicked on transfer page" );
		
		verifyElementPresent(ObjectRepository.cnclmsg);
		test.log(Status.INFO, "Cancel transaction popup appears");
		
		getElement(ObjectRepository.cnclNo).click();
		test.log(Status.INFO, "Cancel-No button clicked on Cancel popup" );
		
		verifyElementPresent(ObjectRepository.frequencydrop);
		test.log(Status.INFO, "Cancel popup got closed");
		
		getElement(ObjectRepository.cncltrnsfr).click();
		test.log(Status.INFO, "Cancel button clicked on transfer page" );
		
		verifyElementPresent(ObjectRepository.cnclmsg);
		test.log(Status.INFO, "Cancel transaction popup appears");
		
		getElement(ObjectRepository.cnclYes).click();
		test.log(Status.INFO, "Cancel-Yes button clicked on Cancel popup" );
		
		verifyElementPresent(ObjectRepository.continuebtn_MyTDECU);
		test.log(Status.INFO, "Continue button for MY TDECU account appearing" );
		
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
		test.log(Status.PASS, "Verify cancelling My Tdecu transfer scenario working fine");
	}
}

	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
	
}
