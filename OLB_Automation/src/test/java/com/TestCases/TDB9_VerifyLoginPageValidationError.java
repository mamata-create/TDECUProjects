package com.TestCases;

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

public class TDB9_VerifyLoginPageValidationError extends GenericKeywords{
	ExtentReports extent;
	ExtentTest test;
	/*
	 * TDB9 - VerifyLoginPageValidationError 
	 */
	@BeforeTest
	public void setUp(){
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated" );
		
	}
	
	@Test
	public void TDB9_VerifyLoginPageValidationError() throws InterruptedException
	{
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Username and Password entered" );
		getElement(ObjectRepository.login_btn).click();
		Assert.assertTrue(getElement(ObjectRepository.loginerror).isDisplayed());
		String error=getElement(ObjectRepository.loginerror).getText();
		if(error.contains("Authentication has failed. Please try again with the proper credentials or if you're a new user, please enroll")){
			Assert.assertTrue(true);
			test.log(Status.INFO, "Correct error message displayed on login with invalid username & password" );
		}else{
			Assert.assertTrue(false);
			test.log(Status.INFO, "InCorrect error message displayed on login with invalid username & password" );
		}
		
		
		
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed-"+result.getThrowable());
			takescreenshot(this.getClass().getSimpleName(),test);
		}else
		{
			test.log(Status.PASS, "Login with invalid username & password scenario working fine");
		}
	}

		@AfterTest
		public void tearDown()
		{
			extent.flush();
			driver.quit();
		}
		
		
	}	
		
	

