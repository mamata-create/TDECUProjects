package com.testcases;

import java.io.IOException;

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

public class C23519_VerifyInvalidLoginIDValidation  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Login with Invalid Login ID
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
	public void C23519_VerifyInvalidLoginIDValidation() throws InterruptedException, MessagingException, IOException
	{
		//enter loginId
		getElement(ObjectRepository.loginid_txt).sendKeys(username);
		test.log(Status.INFO, "Login ID entered");
		
		//enter password
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Password entered");
		
		//click login button
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked");
		
		//Verify error message after invalid Login ID passed
		verifyElementPresent(ObjectRepository.loginerr_msg);
		test.log(Status.INFO, "Validation message on trying to login with Invalid Login ID");
		
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Invalid Login ID Validation scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
