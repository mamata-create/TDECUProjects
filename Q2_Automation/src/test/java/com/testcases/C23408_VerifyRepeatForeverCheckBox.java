package com.testcases;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

public class C23408_VerifyRepeatForeverCheckBox extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Repeat Forever checkbox
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
	public void C23408_VerifyRepeatForeverCheckBox() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String frmacnt=excl.getCellData(sheetName, 1, startIter);
					String toacnt=excl.getCellData(sheetName, 2, startIter);
					String amnt=randomAmount();
					String frqncy=excl.getCellData(sheetName, 6, startIter);
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					selectDropdownOptContain(ObjectRepository.frmacnt_dropdown, frmacnt);
					test.log(Status.INFO, "From Account selected");
		
					selectDropdownOptContain(ObjectRepository.toacnt_dropdown, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
				//Select recurring check box to verify respective fields appears	
					getElement(ObjectRepository.rccrng_chkbx).click();
					test.log(Status.INFO, "Recurring checkbox clicked");
					verifyElementPresent(ObjectRepository.frqncy_dropdown);
					test.log(Status.INFO, "Frequency dropdown appeared");
					verifyElementPresent(ObjectRepository.stdt_cal);
					test.log(Status.INFO, "Start Date field appeared");
					verifyElementPresent(ObjectRepository.enddt_cal);
					test.log(Status.INFO, "End Date field appeared");
					selectDropdownOptContain(ObjectRepository.frqncy_dropdown, frqncy);
					test.log(Status.INFO, "Frequency selected");
					Thread.sleep(2000);
					scrollToElement(ObjectRepository.clr_btn);
					verifyElementPresent(ObjectRepository.rptfrever_chk);
					test.log(Status.INFO, "Repeat Forever check box appeared");
					
					getElement(ObjectRepository.stdt_cal).click();
					Thread.sleep(3000);
					selectFutureDate(1);
					test.log(Status.INFO, "Start Date selected");
					

					getElement(ObjectRepository.enddt_cal).click();
					Thread.sleep(3000);
					selectFutureDate(2);
					test.log(Status.INFO, "End Date selected");
					
					getElement(ObjectRepository.rptfrever_chk).click();
					test.log(Status.INFO, "Repeat forever check box clicked");
					
					verifyElementNotPresent(ObjectRepository.enddt_cal);
					verifyElementPresent(ObjectRepository.noenddt);
					
					test.log(Status.INFO, "End date calender removed & message appear as no end date");
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
			test.log(Status.PASS, "Verify Repeat Forever checkbox scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
