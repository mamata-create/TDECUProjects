package com.test.DNA;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
//import org.sikuli.script.FindFailed;
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

public class C24214_VerifyMultiCheckStopPayment_DNA extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Multi Check Stop Payment
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
	public void C24214_VerifyMultiCheckStopPayment() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "DNA_Upgrade";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String strtchknumber=excl.getCellData(sheetName, 5, startIter);
					String endchknumber=excl.getCellData(sheetName, 6, startIter);
					String note=excl.getCellData(sheetName, 4, startIter);
					
					//Click Services option
					getElement(ObjectRepository.service_menu).click();
					test.log(Status.INFO, "Service menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_menu).click();
					test.log(Status.INFO, "Stop Payment menu clicked");
					Thread.sleep(3000);
				//Verify Stop Payment page title
					verifyElementPresent(ObjectRepository.stppaymnt_ttl);
					test.log(Status.INFO, "Stop Payment page opened and title available");
					
					String sendbtn_class=getElement(ObjectRepository.stppaymnt_sndrqst_btn).getAttribute("class");
					Assert.assertTrue(sendbtn_class.contains("disabled"));
					
					getElement(ObjectRepository.stppaymnt_mltchk).click();
					test.log(Status.INFO, "Multi Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_acnt).click();
					test.log(Status.INFO, "Account clicked");
					Thread.sleep(3000);
					
									
					for(int i=0;i<strtchknumber.length();i++){
						char chr=strtchknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					test.log(Status.INFO, "Starting check number entered");
					Thread.sleep(3000);
									
					getElement(ObjectRepository.stppaymnt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					for(int i=0;i<endchknumber.length();i++){
						char chr=endchknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					test.log(Status.INFO, "Ending check number entered");
					Thread.sleep(3000);
									
					getElement(ObjectRepository.stppaymnt_svbtn).click();
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					selectFutureDate(1);
					test.log(Status.INFO, "Start Date entered");
					Thread.sleep(2000);
					
					selectFutureDate(3);
					test.log(Status.INFO, "End Date entered");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.stppaymnt_notetxt).sendKeys(note);
					test.log(Status.INFO, "Description entered");
					
					getElement(ObjectRepository.stppaymnt_setbtn).click();
					test.log(Status.INFO, "Set button clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_sndrqst_btn).click();
					test.log(Status.INFO, "Send Request button clicked");
					Thread.sleep(10000);
					
					validateStopPayment();
					
					//View Activity Center steps

				
				verifyElementPresent(ObjectRepository.activityCenterHeader);
				jsclick(getElement(ObjectRepository.recordOfTable));
				Thread.sleep(3000);
					verifyElementPresent(ObjectRepository.transactionDetails);
					
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
			test.log(Status.PASS, "Verify Multi Check Stop Payment scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
