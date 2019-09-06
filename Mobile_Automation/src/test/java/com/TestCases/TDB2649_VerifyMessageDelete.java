package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2649_VerifyMessageDelete extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2649 - Verify Message Delete
	 */
	@Test
	public void TDB2649_VerifyMessageDelete() throws InterruptedException{
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
					
							
				//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
					test.log(Status.INFO, "Menu Item Link clicked");
				
					getElement(ObjectRepository.msg_lnk).click();
					
					verifyElementPresent(ObjectRepository.msginbx_ttl);
					
					getElement(ObjectRepository.msgsrch_txt).sendKeys(msgsbjct);
					
					getElement("//android.widget.TextView[@text='"+msgsbjct+"']").click();
					
					verifyElementPresent("//android.widget.TextView[@text='"+msgsbjct+"']");
					
					getElement(ObjectRepository.msgdlt_icn).click();
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.dltmsg_wrng);
					
					getElement(ObjectRepository.yes_btn).click();
					Thread.sleep(4000);
					
//					verifyElementPresent(ObjectRepository.msgdlt_tab);
//					
//					getElement(ObjectRepository.msgdlt_tab).click();
//					Thread.sleep(2000);
//					
//					getElement(ObjectRepository.msgsrch_txt).sendKeys(msgsbjct);
//					
//					verifyElementPresent("//android.widget.TextView[@text='"+msgsbjct+"']");
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
			test.log(Status.PASS, "Verify Message Delete scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
