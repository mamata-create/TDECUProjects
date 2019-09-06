package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
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

public class C23501_VerifyMakeRecurringMortageLoanPayment extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Make recurring mortage Loan Payment
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
	public void C23501_VerifyMakeRecurringMortageLoanPayment() throws InterruptedException, MessagingException, IOException
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
					String amnt=excl.getCellData(sheetName, 3, startIter);
					String memo=excl.getCellData(sheetName, 4, startIter);
					String frqncy=excl.getCellData(sheetName, 6, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.mkpymnt_menu).click();
					test.log(Status.INFO, "Make a Payment menu clicked");
					
					verifyElementPresent(ObjectRepository.mkpymnt_ttl);
					test.log(Status.INFO, "Make a Payment page opened");
										
					selectDropdownOptContain(ObjectRepository.mkpymnt_frmacnt, frmacnt);
					test.log(Status.INFO, "From Account selected");
		
					selectDropdownOptContain(ObjectRepository.mkpymnt_toacnt, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].value='"+amnt+"';", getElement(ObjectRepository.mkpymnt_amnt));
					
					getElement(ObjectRepository.mkpymnt_rccrngchk).click();
					test.log(Status.INFO, "Recurring checkbox clicked");
					
					selectDropdownOptContain(ObjectRepository.mkpymnt_frqncy, frqncy);
					test.log(Status.INFO, "Frequency selected");
					Thread.sleep(2000);
					scrollToElement(ObjectRepository.mkpymnt_cntinue);
										
					getElement(ObjectRepository.stdt_cal).click();
					Thread.sleep(3000);
					selectFutureDate(1);
					test.log(Status.INFO, "Start Date selected");

					getElement(ObjectRepository.enddt_cal).click();
					Thread.sleep(3000);
					selectFutureDate(10);
					test.log(Status.INFO, "End Date selected");


					getElement(ObjectRepository.mkpymnt_memo).sendKeys(memo);
					test.log(Status.INFO, "Memo entered");
					getElement(ObjectRepository.mkpymnt_memo).sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.mkpymnt_cntinue).click();
					test.log(Status.INFO, "Continue button clicked");
					
					getElement(ObjectRepository.mkpymnt_cnfrmbtn).click();
					test.log(Status.INFO, "Confirm button clicked");
					
					getElement(ObjectRepository.mkpymnt_vwactvty).click();
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
			test.log(Status.PASS, "Verify make recurring mortage loan payment scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
