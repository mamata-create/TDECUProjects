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

public class C23600_VerifyLinkInValidAccountValidation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Link InValid Account Validation
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
	public void C23600_VerifyLinkInValidAccountValidation() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
			sheetName = "MemberToMember";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String toacnt=excl.getCellData(sheetName, 1, startIter);
					String acnttyp=excl.getCellData(sheetName, 2, startIter);
					String lastname3char=excl.getCellData(sheetName, 3, startIter);
					
		getElement(ObjectRepository.trnsctn_menu).click();
		test.log(Status.INFO, "transaction menu clicked");
		
		getElement(ObjectRepository.mtmtrnsfr_menu).click();
		test.log(Status.INFO, "Member to Member transfer menu clicked");
		
		Thread.sleep(3000);
		verifyElementPresent(ObjectRepository.sngltrnsfr_btn);
		test.log(Status.INFO, "Single transfer option available");
		
		verifyElementPresent(ObjectRepository.lnkacnt_btn);
		test.log(Status.INFO, "Link Account option available");
		
		getElement(ObjectRepository.lnkacnt_btn).click();
		test.log(Status.INFO, "Link Account option clicked");
		
		verifyElementPresent(ObjectRepository.mtm_lnkacnt_ttl);
		test.log(Status.INFO, "Link an Account page opened");
		
		getElement(ObjectRepository.mtm_toacntnmbr_txt).sendKeys(toacnt);
		test.log(Status.INFO, "To Account Number entered");
		
		selectDropdownOptContain(ObjectRepository.mtm_acnttyp_dropdown, acnttyp);
		test.log(Status.INFO, "Account type selected");
		
		getElement(ObjectRepository.mtm_lstname_txt).sendKeys(lastname3char);
		test.log(Status.INFO, "Last Name first 3 characters entered");
		
		scrollToElement(ObjectRepository.mtm_back_btn);
		getElement(ObjectRepository.mtm_back_btn).click();
		test.log(Status.INFO, "Back button clicked");
		
		getElement(ObjectRepository.lnkacnt_btn).click();
		test.log(Status.INFO, "Link Account option clicked");
		
		getElement(ObjectRepository.mtm_toacntnmbr_txt).sendKeys(toacnt);
		test.log(Status.INFO, "To Account Number entered");
		
		selectDropdownOptContain(ObjectRepository.mtm_acnttyp_dropdown, acnttyp);
		test.log(Status.INFO, "Account type selected");
		
		getElement(ObjectRepository.mtm_lstname_txt).sendKeys(lastname3char);
		test.log(Status.INFO, "Last Name first 3 characters entered");
		
		scrollToElement(ObjectRepository.mtm_sbmt_btn);
		getElement(ObjectRepository.mtm_sbmt_btn).click();
		test.log(Status.INFO, "Submit button clicked");
		
		verifyElementPresent(ObjectRepository.lnkacnt_errmsg);
		test.log(Status.INFO, "Validation appearing on linking InValid account ");
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
			test.log(Status.PASS, "Verify Link InValid Account Validation scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
