package com.TestCases;

import java.io.IOException;
import java.util.Set;

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

import io.appium.java_client.TouchAction;

public class C23682_VerifyHelpMenuOption extends GenericKeywords {

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
//		
		
	}
	

	@Test
	public void C23682_VerifyHelpMenuOption() throws InterruptedException
	{
		Thread.sleep(8000);	
		
		verifyElementPresent(ObjectRepository.home_ttl);
		test.log(Status.INFO, "Home link appearing");
	//Verify menu item option
		verifyElementPresent(ObjectRepository.menu_btn);
		test.log(Status.INFO, "Menu link appearing");
	
		getElement(ObjectRepository.menu_btn).click();
		test.log(Status.INFO, "Menu link clicked");
		Thread.sleep(4000);	
	
//		TouchAction actn=new TouchAction(driver);
//		actn.tap(100,850).perform();
		getElement(ObjectRepository.help_menu).click();
		test.log(Status.INFO, "Help Menu link clicked");
		
		Thread.sleep(3000);	
		getElement(ObjectRepository.hlpguide_menu).click();
		test.log(Status.INFO, "Help Guide Menu link clicked");
		Thread.sleep(3000);
		
		verifyElementPresent(ObjectRepository.tdecuguide_ttl);
		test.log(Status.INFO, "TDECU Eguide opened up");
		
		getElement(ObjectRepository.tdecuguide_cls).click();
		test.log(Status.INFO, "TDECU Eguide close button clicked");
		Thread.sleep(3000);	
	
		
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(Status.FAIL, "Test Failed - "+result.getThrowable());	
			GenericKeywords.takescreenshot(myTestCaseName,test);
		}else
		{
			test.log(Status.PASS, "Verify Help menu Option scenario working fine");
		}
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
		stopAppium();
		extent.flush();
		
	}
}
