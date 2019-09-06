package com.TestCases;

import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

public class TDB2460_VerifySourceAccountSelectionMyTdecuTransfer extends GenericKeywords{
	
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
	}
	
	/*
	 * Test Cases covered -- TDB-2640
	 */
	@Test
	public void TDB2460_VerifySourceAccountSelectionMyTdecuTransfer() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				{
					//read data from excel	
					String frmAccnt=excl.getCellData(sheetName, 1,startIter);
					String toAccnt=excl.getCellData(sheetName, 2,startIter);
					String amnt=excl.getCellData(sheetName, 3,startIter);
					String desc=excl.getCellData(sheetName, 4,startIter);
					String noofoccurences=excl.getCellData(sheetName, 5,startIter);
		
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
					test.log(Status.INFO, "Continue button clicked from amount page");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.onetime_opt).click();
		test.log(Status.INFO, "Transfer frequency as Onetime selected");
		Thread.sleep(3000);
		
		verifyElementPresent(ObjectRepository.snddtttl);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date());
	    //cal.add(Calendar.DATE, 46);
	    String newDate = dateFormat.format(cal.getTime());
 		
		String actdt=getElement(ObjectRepository.dt1).getText()+getElement(ObjectRepository.dt2).getText();
		String actmnth=getElement(ObjectRepository.mnth1).getText()+getElement(ObjectRepository.mnth2).getText();
		String actyr=getElement(ObjectRepository.yr1).getText()+getElement(ObjectRepository.yr2).getText()+getElement(ObjectRepository.yr3).getText()+getElement(ObjectRepository.yr4).getText();
			
		String actdate=actmnth+"/"+actdt+"/"+actyr;
		System.out.println("Actual Date ->"+actdate);
		System.out.println("Current Date ->"+newDate);
		Assert.assertTrue(newDate.equals(actdate));
		
		getElement(ObjectRepository.backarrw).click();
		
		getElement(ObjectRepository.weekly_opt).click();
		test.log(Status.INFO, "Transfer frequency as weekly selected");
		Thread.sleep(3000);
		getElement(ObjectRepository.UntilYouCancel_opt).click();
		
///verifyElementPresent(ObjectRepository.snddtttl);
		
		DateFormat dateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
	    Calendar cal1 = Calendar.getInstance();
	    cal.setTime(new Date());
	    //cal.add(Calendar.DATE, 46);
	    String newDate1 = dateFormat1.format(cal.getTime());
 		
		String actdt1=getElement(ObjectRepository.dt1).getText()+getElement(ObjectRepository.dt2).getText();
		String actmnth1=getElement(ObjectRepository.mnth1).getText()+getElement(ObjectRepository.mnth2).getText();
		String actyr1=getElement(ObjectRepository.yr1).getText()+getElement(ObjectRepository.yr2).getText()+getElement(ObjectRepository.yr3).getText()+getElement(ObjectRepository.yr4).getText();
			
		Thread.sleep(3000);
		
		String actdate1=actmnth1+"/"+actdt1+"/"+actyr1;
		System.out.println("Actual Date ->"+actdate1);
		System.out.println("Current Date ->"+newDate1);
		Assert.assertTrue(newDate1.equals(actdate1));
		
	}
 }
}
	}
	
	
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Send date selection in MYTDECU account transfer scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}

}
