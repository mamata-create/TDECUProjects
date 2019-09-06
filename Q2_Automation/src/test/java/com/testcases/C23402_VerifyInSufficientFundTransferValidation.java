package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C23402_VerifyInSufficientFundTransferValidation extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify InSufficient Fund Transfer Validation
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
	public void C23402_VerifyInSufficientFundTransferValidation() throws InterruptedException, MessagingException, IOException
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
					String memo=excl.getCellData(sheetName, 4, startIter);
					
					getElement(ObjectRepository.trnsctn_menu).click();
					test.log(Status.INFO, "Transaction menu clicked");
					
					getElement(ObjectRepository.fndtrnsfr_menu).click();
					test.log(Status.INFO, "Fund Transfer menu clicked");
					
					verifyElementPresent(ObjectRepository.fndtrnsfr_ttl);
					test.log(Status.INFO, "Fund Transfer page opened");
					
					Assert.assertFalse(getElement(ObjectRepository.trnsfrfnds_btn).isEnabled());
					test.log(Status.INFO, "Transfer Funds button disabled");
					
					selectDropdownOptContain(ObjectRepository.frmacnt_dropdown, frmacnt);
					test.log(Status.INFO, "From Account selected");
					Thread.sleep(2000);
					
					WebElement frm=getElement(ObjectRepository.frmacnt_dropdown);					
					Select slct=new Select(frm);
					WebElement a=slct.getFirstSelectedOption();
					System.out.println("FRMFIRS "+a.getText());
					
					String frmacnttxt=a.getText();
					System.out.println("FRM ACCNT - "+frmacnttxt);
					if(!frmacnttxt.contains("$")){
						amnt="100";
					}else{
					String actfrmamnttxt=frmacnttxt.substring(frmacnttxt.lastIndexOf("$")+1, frmacnttxt.length()-1);
					System.out.println("ACT AMNT- "+actfrmamnttxt);
					Double d=Double.parseDouble(actfrmamnttxt);
					d=d+100;
					amnt=Double.toString(d);
					}
		
					selectDropdownOptContain(ObjectRepository.toacnt_dropdown, toacnt);
					test.log(Status.INFO, "To Account selected");
					
					getElement(ObjectRepository.amnt_txt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
					getElement(ObjectRepository.memo_txt).sendKeys(memo);
					test.log(Status.INFO, "Memo entered");
					getElement(ObjectRepository.memo_txt).sendKeys(Keys.TAB);
					
					getElement(ObjectRepository.trnsfrfnds_btn).click();
					test.log(Status.INFO, "Transfer Funds button clicked");
					Thread.sleep(4000);
					
					verifyElementPresent(ObjectRepository.fndtrnsfrerr);
					test.log(Status.INFO, "Fund Transfer error page opened");
					
					verifyElementPresent(ObjectRepository.fndtrnsfrerr_msg);
					test.log(Status.INFO, "Fund transfer failure message appeared");					
					
					
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
			test.log(Status.PASS, "Verify InSufficient Fund TRansfer Validation scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
