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

public class TDB2024_VerifyQuarterlyMyTdecuTransfer extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	/*
	 * TDB2024 - Verify Quarterly My TDECU Transfer
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
	public void TDB2024_VerifyQuarterlyMyTdecuTransfer()throws InterruptedException{
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
					String noOfRecurrences=excl.getCellData("Data", 5, startIter);
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
		getElement(ObjectRepository.amount_txt).clear();
		test.log(Status.INFO, "Amount" );
		getElement(ObjectRepository.amount_txt).sendKeys(amnt);
		test.log(Status.INFO, "Amount entered greater than minimum amount" );
		Thread.sleep(2000);
		
	//select frequency as Quarterly and No of Recurrences	
		selectDropdownOpt(ObjectRepository.frequencydrop,"Quarterly");
		verifyDropdownSelection(ObjectRepository.frequencydrop,"Quarterly");
		test.log(Status.INFO, "Frequency selected as Quarterly and verified" );
		Thread.sleep(2000);
		selectDropdownOpt(ObjectRepository.howlongdrop,"Number of Recurrences");
		verifyDropdownSelection(ObjectRepository.howlongdrop,"Number of Recurrences");
		test.log(Status.INFO, "How Long selected as Number of Recurrences and verified" );
		
		verifyElementPresent(ObjectRepository.sendOnCal);
		getElement(ObjectRepository.noOfRecurrences).sendKeys(noOfRecurrences);
		test.log(Status.INFO, "Number of recurrences entered" );
		Thread.sleep(2000);
		
		getElement("//div[@kwidgetid='frmTransfers_transfermain_maketransfer_calSendOn']/img[@id='calSendOn_img']").click();
		selectFutureDate();
		Thread.sleep(2000);
		
		scrollToElement(ObjectRepository.maketransfer_btn);
		Thread.sleep(3000);
		
		verifyElementPresent(ObjectRepository.sendOnCal);
		test.log(Status.INFO, "Send On Date present with default dates" );
		
		getElement("//div[@kwidgetid='frmTransfers_transfermain_maketransfer_calSendOn']/img[@id='calSendOn_img']").click();
		selectFutureDate();
		
		
		getElement(ObjectRepository.notes_txt).sendKeys(desc);
		test.log(Status.INFO, "Notes entered" );
		
		getElement(ObjectRepository.maketransfer_btn).click();
		test.log(Status.INFO, "Make Transfer button clicked" );
		
		//Verify Confirm details 	
				verifyElementPresent(ObjectRepository.confirm_header);
				verifyText(ObjectRepository.confirm_frmAcnt,frmAcnt);
				verifyText(ObjectRepository.confirm_toAcnt,toAcnt);
				verifyText(ObjectRepository.confirm_amnt,amnt);
				
				getElement(ObjectRepository.confirm_btn).click();
				test.log(Status.INFO, "Confirm button clicked" );
			//Verify success message	
				verifyElementPresent(ObjectRepository.schdl_sccessmsg);
				test.log(Status.INFO, "Success Transfer screen verified");
			//Verify Posted tab on clicking transfer activity	
				getElement(ObjectRepository.trnsfrActvty).click();
				verifyElementPresent(ObjectRepository.schdltb_selcted);
				test.log(Status.INFO, "Scheduled tab should be selected by default");
				Thread.sleep(4000);
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
			test.log(Status.PASS, "Quarterly My TDECU account transfer scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
}
