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

public class C23448_VerifyWireTransferAddNewRecipient extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Wire Transfer Add New Recipient
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
	public void C23448_VerifyWireTransferAddNewRecipient() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "WireTransfer";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String randomNum=getRandom();
					String displayName="Aut"+randomNum;
					String wireName="Wire"+randomNum;
					String email="Email"+randomNum+"@gmail.com";
					String acntNumber=excl.getCellData(sheetName, 1, startIter);
					String rtngNumber=excl.getCellData(sheetName, 2, startIter);
					String bankName=excl.getCellData(sheetName, 3, startIter)+randomNum;
					String address1=excl.getCellData(sheetName, 4, startIter)+randomNum;
					String city=excl.getCellData(sheetName, 5, startIter);
					String state=excl.getCellData(sheetName, 6, startIter);
					String zip=excl.getCellData(sheetName, 7, startIter);
					
					
					
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
					
					getElement(ObjectRepository.wiretrnsfr_dsplynm).sendKeys(displayName);
					test.log(Status.INFO, "Recipient Display Name entered");
					
					getElement(ObjectRepository.wiretrnsfr_wrnm).sendKeys(wireName);
					test.log(Status.INFO, "Wire Name entered");
					
					getElement(ObjectRepository.wiretrnsfr_email).sendKeys(email);
					test.log(Status.INFO, "Email entered");
					
					getElement(ObjectRepository.addrcpnt_nxtbtn).click();
					test.log(Status.INFO, "Next button clicked");
					Thread.sleep(3000);
			//		
					getElement(ObjectRepository.wiretrnsfr_acntno).sendKeys(acntNumber);
					test.log(Status.INFO, "Account Number entered");
					
					getElement(ObjectRepository.wiretrnsfr_bnknm).sendKeys(bankName);
					test.log(Status.INFO, "Bank Name entered");
					
					getElement(ObjectRepository.wiretrnsfr_rtngnmbr).sendKeys(rtngNumber);
					test.log(Status.INFO, "Routing number entered");
					
					getElement(ObjectRepository.wiretrnsfr_addrs1).sendKeys(address1);
					test.log(Status.INFO, "Address1 entered");
					
					getElement(ObjectRepository.wiretrnsfr_city).sendKeys(city);
					test.log(Status.INFO, "City entered");
					
					getElement(ObjectRepository.wiretrnsfr_zip).sendKeys(zip);
					test.log(Status.INFO, "Zip code entered");
					
					selectDropdownOptContain(ObjectRepository.wiretrnsfr_state, state);
					test.log(Status.INFO, "State selected");
					
					getElement(ObjectRepository.wiretrnsfr_svrcp).click();
					test.log(Status.INFO, "Save Recipient button clicked");
					Thread.sleep(4000);
					
					getElement(ObjectRepository.gridvw_btn).click();
					test.log(Status.INFO, "Grid View button clicked");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.locsrch_txt).sendKeys(displayName);
					test.log(Status.INFO, "Recipient entered for searching");
					
					Thread.sleep(6000);
					
					verifyElementPresent("//div[text()='"+displayName+"']");
					test.log(Status.INFO, "Searched Recipient appearing correctly");
					Thread.sleep(2000);

					excl.setCellData(sheetName,"DisplayName",3,displayName);
					excl.setCellData(sheetName,"DisplayName",4,displayName);
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
			test.log(Status.PASS, "Verify Wire Transfer Add New Recipient scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
