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

public class TDB1953_VerifyEnablingEDocuments extends GenericKeywords {
	
	ExtentReports extent;
	ExtentTest test;


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
	public void TDB1953_VerifyEnablingEDocuments() throws InterruptedException{
		Thread.sleep(4000);
		getElement(ObjectRepository.settingsimg).click();
		test.log(Status.INFO, "Settings link clicked" );
		getElement(ObjectRepository.accntsettinglnk).click();
		test.log(Status.INFO, "Account Settings link clicked" );
		
		getElement(ObjectRepository.edoclnk).click();
		test.log(Status.INFO, "e-Documents link clicked" );
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.edocpagettl);
		test.log(Status.INFO, "E-Documents page gets opened" );
		Thread.sleep(2000);
		getElement(ObjectRepository.enablebtn).click();
		test.log(Status.INFO, "Enable button clicked for e-documents" );
		Thread.sleep(2000);
		scrollToElement(ObjectRepository.edocTnc);
		Thread.sleep(2000);
		getElement(ObjectRepository.edocTnc).click();
		test.log(Status.INFO, "Term & Conditions for e-documents checked" );
		
		getElement(ObjectRepository.savebtnEDoc).click();
		Thread.sleep(2000);
		test.log(Status.INFO, "Save button clicked for e-Document Term & Conditions" );
		verifyElementPresent(ObjectRepository.enablesuccess);
		verifyElementPresent(ObjectRepository.viewdocbtn);
		test.log(Status.INFO, "Enabling e-documents success message appearing" );
		
	
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed"+result.getThrowable());	
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Enabling e-Documents working fine");
		}
	}
	
	@AfterTest
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
	
}
