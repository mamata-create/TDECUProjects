package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class C24215_HighYieldChecking extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify instant open user registration through existing member option
	 */

	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}	
	
	@Test
	public void C24119_RegisterThroughMembersOption() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					String mmbrnumber=excl.getCellData(sheetName, 20, startIter);
					String ssn=excl.getCellData(sheetName, 7, startIter);
					String dob=excl.getCellData(sheetName, 8, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Member Start here button clicked");
					Thread.sleep(3000);
				//Lets Get Started page	
					scrollToElement(ObjectRepository.chkingmoneymrkt_exp);
					getElement(ObjectRepository.chkingmoneymrkt_exp).click();
					test.log(Status.INFO, "Checking Money Market options expanded");
					
					getElement(ObjectRepository.Highyieldchking_opt).click();
					test.log(Status.INFO, "Classic checking option selected");
					
					getElement(ObjectRepository.debitCardUnderHyield).click();
					test.log(Status.INFO, "Debit Card option unselected");
					
					getElement(ObjectRepository.overDraftUnderHyield).click();
					test.log(Status.INFO, "Overdraft protection plan option unselected");
					
					scrollToElement(ObjectRepository.svngacnt_exp);
					getElement(ObjectRepository.svngacnt_exp).click();
					test.log(Status.INFO, "Saving Account options expanded");
					
//					scrollToElement(ObjectRepository.club_opt);
//					getElement(ObjectRepository.club_opt).click();
//					test.log(Status.INFO, "Club option selected");
					
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
			// Member Verification page
					verifyElementPresent(ObjectRepository.mmbrvrfctn_ttl);
					test.log(Status.INFO, "Member Verification page opened");
					
					getElement(ObjectRepository.mmbrnmbr_txt).sendKeys(mmbrnumber);
					test.log(Status.INFO, "Member number entered");
					
					getElement(ObjectRepository.ssnnmbr_txt).sendKeys(ssn);
					test.log(Status.INFO, "SSN entered");
					
					getElement(ObjectRepository.dateofbirth_txt).sendKeys(dob);
					test.log(Status.INFO, "DOB entered");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
			//Applicant Information page
					verifyElementPresent(ObjectRepository.aplcntinfo_ttl);
					test.log(Status.INFO, "Applicant Information page opened");
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
			//Confirm Account selections
					verifyElementPresent(ObjectRepository.cnfrmacnt_ttl);
					test.log(Status.INFO, "Confirm Account selections page opened");
					
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
			// Terms and conditions page	
					scrollToElement(ObjectRepository.tnc_chkbx);
					
					getElement(ObjectRepository.tnc_chkbx).click();
					test.log(Status.INFO, "Term and Conditions check box clicked");
					Thread.sleep(3000);
					getElement(ObjectRepository.agreementAndSignature).click();
					test.log(Status.INFO, "Agreement andSignature check box clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
			//Identity verification page
					verifyElementPresent(ObjectRepository.idnty_ttl);
					test.log(Status.INFO, "Identity verification page opened");
					
					getElement(ObjectRepository.Corporation_Verification).click();
					test.log(Status.INFO, "corporation verification question answered");
					Thread.sleep(1000);
					
					getElement(ObjectRepository.address_Verification).click();
					test.log(Status.INFO, "Address verification question answered");
					Thread.sleep(1000);
					
					scrollToElement(ObjectRepository.background_Verification);

					getElement(ObjectRepository.background_Verification).click();
					test.log(Status.INFO, "Background verification question answered");
					Thread.sleep(1000);
					
					scrollToElement(ObjectRepository.Counties_Verification);

					getElement(ObjectRepository.Counties_Verification).click();
					test.log(Status.INFO, "Counties verification question answered");
					Thread.sleep(1000);
					

					getElement(ObjectRepository.cnfrm_btn).click();
					test.log(Status.INFO, "Confirm button clicked");
					Thread.sleep(3000);
					
			// Account Fundings
					getElement(ObjectRepository.shareamnt_txt).sendKeys("5");
					test.log(Status.INFO, "Classic checking Amount entered");
					
//					WebElement el=getElement(ObjectRepository.clubamntprnt_txt);
//					el.findElement(By.xpath(ObjectRepository.shareamnt_txt)).sendKeys("5");
//					test.log(Status.INFO, "Club Amount entered");
					
					getElement(ObjectRepository.elctrnc_opt).click();
					test.log(Status.INFO, "Electronic option selected");
					
					getElement(ObjectRepository.rtngnmbr_txt).sendKeys("234567876");
					test.log(Status.INFO, "Routing number entered");
					
					getElement(ObjectRepository.acntnmbr_txt).sendKeys("2345678987");
					test.log(Status.INFO, "Account number entered");
					
					getElement(ObjectRepository.vrfyacnt_btn).click();
					test.log(Status.INFO, "verify account button clicked");		
					
					verifyElementPresent(ObjectRepository.thnku_ttl);
					test.log(Status.INFO, "Thanku page opened");
					
					Thread.sleep(8000);
					
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
			test.log(Status.PASS, "Verify instant open user registration through existing member option scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
