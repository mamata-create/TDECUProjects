package com.testcases;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

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

public class C23518_VerifyLoginPagePrivacyNoticeOption extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Location option on Login Page
	 */

	@BeforeTest
	public void setUp() {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}

	@Test
	public void C23518_VerifyLoginPagePrivacyNoticeOption() throws InterruptedException, MessagingException, IOException
	{
		//Click Location option
		getElement(ObjectRepository.prvcyntc_lnk).click();
		test.log(Status.INFO, "Privacy Notice link clicked");
		
		Thread.sleep(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    test.log(Status.INFO, "Switched to newly opened Privacy Notice tab");
		
		//Verify location page
		verifyElementPresent(ObjectRepository.prvcyntc_ttl);
		test.log(Status.INFO, "Privacy Notice new tab opened and title available");
		
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Login Page Privacy Notice option scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
