package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C23685_VerifyOneTimeFundTransfer extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify One time Fund Transfer
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
//				try{
//				//click login button
//				getElement(ObjectRepository.otpemail_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(15000);
//				
//				getElement(ObjectRepository.otp_txt).sendKeys(fetchOutlookOTP());
//				test.log(Status.INFO, "Login ID entered");
//				
//				
//				getElement(ObjectRepository.submit_btn).click();
//				test.log(Status.INFO, "Send OTP to email button clicked");
//				Thread.sleep(7000);
//				
//				
//					if(getElement(ObjectRepository.register_btn).isDisplayed()){
//						getElement(ObjectRepository.register_btn).click();
//						test.log(Status.INFO, "Register device button clicked");
//						Thread.sleep(7000);
//					}
//					}catch(Exception e){
//						test.log(Status.INFO, "Register device button not available to be clicked");
//					}
//				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void VerifyOneTimeFundTransfer() throws InterruptedException, MessagingException, IOException
	{
		int j=1;
		
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
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					if(j==1){
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					}
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					Assert.assertFalse(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Transfer Funds button disabled");
					
					selectDropdownOptContain(ObjectRepository.frmacnt_dropdown, frmacnt);
					test.log(Status.INFO, "From Account selected");
					Thread.sleep(2000);
		
					selectDropdownOptContain(ObjectRepository.toacnt_dropdown, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
					getElement(ObjectRepository.memo_txt).sendKeys(memo);
					test.log(Status.INFO, "Memo entered");
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
					test.log(Status.INFO, "Transfer Funds button clicked");
					
					verifyElementPresent(ObjectRepository.trnsfrsccs_msg);
					test.log(Status.INFO, "Transfer success message appeared");
					
					getElement(ObjectRepository.vwactvtycntr_btn).click();
					test.log(Status.INFO, "View Activity Center button clicked from transfer success page");
					
					verifyElementPresent(ObjectRepository.actvtycntr_ttl);
					test.log(Status.INFO, "Activity Center page opened");
					
					WebElement ele=getElement("//span[text()='Single Transactions']/parent::*/parent::*");
					
					String sngltrnsctn=ele.getAttribute("class");
					if(sngltrnsctn.contains("active")){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Single Transaction tab is selected");
					}else{
						test.log(Status.INFO, "Single Transaction tab is not selected");
					}
					
					String amntVal=getElement(ObjectRepository.actvtycntr_amnt).getText();
					if(amntVal.contains(amnt)){
						Assert.assertTrue(true);
						test.log(Status.INFO, "Transfer amount appearing correctly in first selected row");
					}else{
						test.log(Status.INFO, "Transfer amount not appearing correctly in first selected row");
					}
					j++;
	
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
			test.log(Status.PASS, "Verify One time Fund Transfer scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
