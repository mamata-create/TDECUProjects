package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class C23447_VerifyWireTransferFunctionality extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Wire Transfer Functionality
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		//enter loginId
				getElement(ObjectRepository.loginid_txt).sendKeys(username);
				test.log(Status.INFO, "Login ID entered");
				
				//enter password
				getElement(ObjectRepository.password_txt).sendKeys(password);
				test.log(Status.INFO, "Password entered");
				
				//click login button
				getElement(ObjectRepository.login_btn).click();
				test.log(Status.INFO, "Login button clicked");
				
				//click login button
				getElement(ObjectRepository.otpemail_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(15000);
				
				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
				test.log(Status.INFO, "Login ID entered");
				
				
				getElement(ObjectRepository.submit_btn).click();
				test.log(Status.INFO, "Send OTP to email button clicked");
				Thread.sleep(7000);
				
				try{
					if(getElement(ObjectRepository.register_btn).isDisplayed()){
						getElement(ObjectRepository.register_btn).click();
						test.log(Status.INFO, "Register device button clicked");
						Thread.sleep(7000);
					}
					}catch(Exception e){
						test.log(Status.INFO, "Register device button not available to be clicked");
					}
				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23447_VerifyWireTransferFunctionality() throws InterruptedException, MessagingException, IOException
	{
		//Click Services option
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Service menu clicked");
		
		getElement(ObjectRepository.wiretrnsfr_menu).click();
		test.log(Status.INFO, "Wire Transfer menu clicked");
		Thread.sleep(3000);
	//Verify Wire Transfer page title
		verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
		test.log(Status.INFO, "Wire Transfer page opened and title available");
		
		getElement(ObjectRepository.addrcpnt_btn).click();
		test.log(Status.INFO, "Add Recipient button clicked");
		Thread.sleep(3000);
		
		//Verify Add Recipient page title
		verifyElementPresent(ObjectRepository.addrcpnt_ttl);
		test.log(Status.INFO, "Add Recipient page opened and title available");
		
		getElement(ObjectRepository.addrcpnt_cnclbtn).click();
		test.log(Status.INFO, "Add Recipient cancel button clicked");
		Thread.sleep(3000);
	//Verify Wire Transfer page title
		verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
		test.log(Status.INFO, "Wire Transfer page opened and title available");
		
		getElement(ObjectRepository.addrcpnt_btn).click();
		test.log(Status.INFO, "Add Recipient button clicked");
		Thread.sleep(3000);
		
		String nxtbutton=getElement(ObjectRepository.addrcpnt_nxtbtn).getAttribute("class");
		Assert.assertTrue(nxtbutton.contains("disabled"));
		test.log(Status.INFO, "Next button disabled by default on add receipient page");	
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Login Page Location option scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
