package com.TestCases;

import java.io.IOException;
import java.net.MalformedURLException;

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

public class VerifyLoginValidUsernamePassword  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException{
		extent=ExtentManager.GetExtent();
		test=extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
	    iDriver.myTestCaseName = this.getClass().getSimpleName();
		startAppium();
		executeMobileDriver();
		test.log(Status.INFO, " Q2 Mobile application launched");
		getElement(ObjectRepository.username_txt).sendKeys(username);
		getElement(ObjectRepository.password_txt).sendKeys(password);
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked after entering username and password");
		
//		try{
//			if(getElement(ObjectRepository.emailotp_btn).isDisplayed()){
//				getElement(ObjectRepository.emailotp_btn).click();
//				test.log(Status.INFO, "Send otp to email button clicked");
//				Thread.sleep(17000);
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Secure Access code entered");
//
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Submit button clicked");
//				Thread.sleep(3000);
//				try{
//					if(getElement(ObjectRepository.rgstrdvc_btn).isDisplayed()){
//						getElement(ObjectRepository.rgstrdvc_btn).click();
//						test.log(Status.INFO, "Register device button available to be clicked");
//					}
//				}catch(Exception e1){
//					test.log(Status.INFO, "Register device button not available to be clicked");
//				}
//			}
//			}catch(Exception e){
//				test.log(Status.INFO, "Device already registered");
//			}
		
		
	}
	

	@Test
	public void TDB956_VerifyLoginValidUsernamePassword() throws InterruptedException
	{
		Thread.sleep(8000);	
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify login with valid username and password scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
