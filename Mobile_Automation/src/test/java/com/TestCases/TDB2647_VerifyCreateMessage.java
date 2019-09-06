package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2647_VerifyCreateMessage extends GenericKeywords {

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
		Thread.sleep(20000);
	}
	
	/*
	 * Test Cases covered -- TDB-2647 - Verify create message
	 */
	@Test
	public void TDB2647_VerifyCreateMessage() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Messages";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Messages", 0, startIter)))
				{
					//read data from excel	
					String msgctgry=excl.getCellData(sheetName, 1,startIter);
					String msgsbjct=excl.getCellData(sheetName, 2,startIter);
					String msgdesc=excl.getCellData(sheetName, 3,startIter);
					msgsbjct=msgsbjct+randomNumber();
					
							
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu Item Link clicked");
				
					getElement(ObjectRepository.msg_lnk).click();
					test.log(Status.INFO, "Message Link clicked");
					
					getElement(ObjectRepository.addmsg_icn).click();
					test.log(Status.INFO, "Add Message icon clicked");
					
					verifyElementPresent(ObjectRepository.ctgry_ttl);
					test.log(Status.INFO, "Message category title verified");
					
					getElement("//android.widget.TextView[@text='"+msgctgry+"']").click();
					test.log(Status.INFO, "Message category selected");
					
					getElement(ObjectRepository.msgsbjct_txt).sendKeys(msgsbjct);
					test.log(Status.INFO, "Message subject entered");
					
					getElement(ObjectRepository.msgdesc_txt).sendKeys(msgdesc);
					test.log(Status.INFO, "Message description entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
					verifyElementPresent(ObjectRepository.msginbx_ttl);
					
					verifyElementPresent("//android.widget.TextView[@text='"+msgsbjct+"']");
					test.log(Status.INFO, "Message created successfully");
					Thread.sleep(2000);
					excl.setCellData(sheetName, "Subject", startIter+1, msgsbjct);
					Thread.sleep(2000);
					excl.setCellData(sheetName, "Subject", startIter+2, msgsbjct);
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
			test.log(Status.PASS, "Verify Create Message scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
