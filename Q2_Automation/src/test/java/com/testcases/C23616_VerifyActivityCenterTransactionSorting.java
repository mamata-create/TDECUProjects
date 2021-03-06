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

public class C23616_VerifyActivityCenterTransactionSorting extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Activity Center Transaction Sorting
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
	public void C23616_VerifyActivityCenterTransactionSorting() throws InterruptedException, MessagingException, IOException
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
									
					getElement(ObjectRepository.crtd_col_srt).click();
					test.log(Status.INFO, "Created Column sorting applied");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stts_col_srt).click();
					test.log(Status.INFO, "Status Column sorting applied");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.trnsctntyp_col_srt).click();
					test.log(Status.INFO, "Transaction Type Column sorting applied");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.acnt_col_srt).click();
					test.log(Status.INFO, "Account Column sorting applied");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.amnt_col_srt).click();
					test.log(Status.INFO, "Amount Column sorting applied");
					Thread.sleep(3000);

					getElement(ObjectRepository.rcrngtrnsctn_tab).click();
					test.log(Status.INFO, "Recurring transaction tab selected");
					Thread.sleep(5000);
					
				
					
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Activity Center Transaction Sorting scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
