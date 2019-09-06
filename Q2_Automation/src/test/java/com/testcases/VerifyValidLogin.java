package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

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

public class VerifyValidLogin extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Login with valid username and valid password
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
	public void VerifyValidLogin() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "Login";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String username=excl.getCellData(sheetName, 1, startIter);
					String password=excl.getCellData(sheetName, 2, startIter);
				
					
		//enter loginId
		getElement(ObjectRepository.loginid_txt).sendKeys(username);
		test.log(Status.INFO, "Login ID entered");
		
		//enter password
		getElement(ObjectRepository.password_txt).sendKeys(password);
		test.log(Status.INFO, "Password entered");
		
		//click login button
		getElement(ObjectRepository.login_btn).click();
		test.log(Status.INFO, "Login button clicked");
		
	try{
		//click login button
		getElement(ObjectRepository.otpemail_btn).click();
		test.log(Status.INFO, "Send OTP to email button clicked");
		Thread.sleep(15000);
		
		getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTPSravya());
		test.log(Status.INFO, "Login ID entered");
		
		
		getElement(ObjectRepository.submit_btn).click();
		test.log(Status.INFO, "Send OTP to email button clicked");
		Thread.sleep(7000);
		
		
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
		
		getElement(ObjectRepository.logoff_lnk).click();
		test.log(Status.INFO, "Log off link clicked");
		Thread.sleep(7000);
		
		driver.get(url);
		Thread.sleep(2000);
				 }
			 }
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Valid Login scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
