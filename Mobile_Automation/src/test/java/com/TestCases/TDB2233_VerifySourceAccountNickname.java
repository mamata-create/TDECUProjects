package com.TestCases;

import java.net.MalformedURLException;

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

public class TDB2233_VerifySourceAccountNickname extends GenericKeywords {

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
	 * Test Cases covered -- TDB-2233
	 */
	@Test
	public void TDB2233_VerifySourceAccountNickname() throws InterruptedException{
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				{
					//read data from excel	
					String frmAccnt=excl.getCellData(sheetName, 1,startIter);
					String nickname=excl.getCellData(sheetName, 6, startIter);
					
							
					//Verify My Account dashboard 				
					verifyElementPresent(ObjectRepository.myaccount_ttl);
					test.log(Status.INFO, "Accounts dashboard opened");
				//Click menu item option
					getElement(ObjectRepository.menuitem_lnk).click();
				//click transfer link	
					getElement(ObjectRepository.transfer_lnk).click();
				//Click make transfer link
					Thread.sleep(4000);
					getElement(ObjectRepository.maketransfer_lnk).click();
					test.log(Status.INFO, "Make transfer option selected");
					
					verifyElementPresent(ObjectRepository.transfertype_ttl);
				//Select MyTDECU transfer type option
					getElement(ObjectRepository.mytdecu_lnk).click();
					test.log(Status.INFO, "My TDECU accounts transfer option selected");
				
				//Select from account
					verifyElementPresent(ObjectRepository.frmaccount_ttl);
					
				
					WebElement parentElement=getElement("//android.widget.TextView[contains(@text,'"+frmAccnt+"')]");
					String actnickname=parentElement.getText();
				    System.out.println("Actual Nickname is-"+actnickname);
				
					Assert.assertTrue(actnickname.contains(nickname));
					test.log(Status.INFO, "Source Account Contains Account Nickname");
					
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
			test.log(Status.PASS, "Verify Source Account Nickname scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
