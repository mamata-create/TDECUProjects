package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

import junit.framework.Assert;

public class C23646_VerifyActivityCenterInquiryTransaction   extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Inquiry Transaction
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
	public void C23646_VerifyActivityCenterInquiryTransaction() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "transaction menu clicked");
					
					getElement(ObjectRepository.actvtycntr_menu).click();
					test.log(Status.INFO, "Activity Center menu clicked");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.actvtycntr_ttl);
					test.log(Status.INFO, "Activity Center page opened");
					
					verifyElementPresent(ObjectRepository.sngltrnsctn_tab);
					test.log(Status.INFO, "Single Transaction tab available on Activity Center page");
					
					verifyElementPresent(ObjectRepository.rcrngtrnsctn_tab);
					test.log(Status.INFO, "Recurring Transaction tab available on Activity Center page");
					
					verifyElementPresent(ObjectRepository.srchtrnsctn_txt);
					test.log(Status.INFO, "Search transaction field available on Activity Center page");
				
					getElement(ObjectRepository.srchtrnsctn_txt).sendKeys("Authorized");
					getElement(ObjectRepository.srchtrnsctn_txt).sendKeys(Keys.ENTER);
					test.log(Status.INFO, "Criteria in Search transaction field entered");
					Thread.sleep(4000);
					
					getElement(ObjectRepository.actns_lnk).click();
					test.log(Status.INFO, "Actions link clicked against transaction");
					Thread.sleep(3000);
					getElement(ObjectRepository.actn_inqr).click();
					test.log(Status.INFO, "Inquire option clicked against transaction");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.inqr_ttl);
					test.log(Status.INFO, "Inquiry transaction page opened");
					
					Assert.assertFalse(getElement(ObjectRepository.login_btn).isEnabled());
					test.log(Status.INFO, "Send button disabled by default");
					
					getElement(ObjectRepository.inqr_msg).sendKeys("Inquiry Message");
					test.log(Status.INFO, "Inquiry message entered");
					Thread.sleep(3000);
					
					Assert.assertTrue(getElement(ObjectRepository.login_btn).isEnabled());
					test.log(Status.INFO, "Send button enabled");
					
					getElement(ObjectRepository.login_btn).click();
					test.log(Status.INFO, "Send button clicked for inquiring transaction");
					Thread.sleep(3000);
					
					verifyElementPresent(ObjectRepository.inqr_sccs);
					test.log(Status.INFO, "Transaction inquired success message appearing");
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Close button clicked");
					Thread.sleep(3000);
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Activity Center Inquire Transaction scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
