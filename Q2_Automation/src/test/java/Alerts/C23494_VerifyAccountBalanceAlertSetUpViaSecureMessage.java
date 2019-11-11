package Alerts;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class C23494_VerifyAccountBalanceAlertSetUpViaSecureMessage  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Account Balance alert SetUp via Secure Message
	 * 
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
				/*getElement(ObjectRepository.otpemail_btn).click();
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
					}*/
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C23494_VerifyAccountBalanceAlertSetUpViaSecureMessage() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
			sheetName = "Alerts";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String alrtopts=excl.getCellData(sheetName, 1, startIter);
					String acnt=excl.getCellData(sheetName, 8, startIter);
					String field=excl.getCellData(sheetName, 9, startIter);
					String cmpr=excl.getCellData(sheetName, 10, startIter);
					String amnt=excl.getCellData(sheetName, 11, startIter);
				
				//Click Settings Menu
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.alrt_menu).click();
					test.log(Status.INFO, "Alerts menu clicked");
					Thread.sleep(3000);
				//Verify Alerts page title
					verifyElementPresent(ObjectRepository.alrt_ttl);
					test.log(Status.INFO, "Alerts page opened and title available");
					Thread.sleep(3000);
					
					scrollToElement(ObjectRepository.alrtopts_drop);
					
					try{
					selectDropdownOptContain(ObjectRepository.alrtopts_drop, alrtopts);
					test.log(Status.INFO, "Alerts type selected");
					Thread.sleep(2000);
					}catch(Exception e){
						test.log(Status.INFO, "Alerts type selected");
					}
					
					selectDropdownOptContain(ObjectRepository.alrtsel_acnt, acnt);
					test.log(Status.INFO, "Account selected");
					Thread.sleep(2000);
					
					getElement("//div[@test-id='fldHadeRadioTile']//div[contains(text(),'"+field+"')]").click();
					test.log(Status.INFO, "Account balance type selected");
					Thread.sleep(2000);
					
					getElement("//div[@test-id='radioAmount']//div[contains(text(),'"+cmpr+"')]").click();
					test.log(Status.INFO, "Comparison selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.alrtsel_amnt).clear();
					getElement(ObjectRepository.alrtsel_amnt).sendKeys(amnt);
					test.log(Status.INFO, "Amount entered");
					
					getElement(ObjectRepository.alrtsel_dlvrymsg).click();
					test.log(Status.INFO, "Secure Message delivery method selected");
					Thread.sleep(2000);
					
					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Alert save button clicked");
					Thread.sleep(2000);
					
					verifyElementPresent(ObjectRepository.alrt_svsccs);
					test.log(Status.INFO, "Alert save success available");
					
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Alert close button clicked");
					
					getElement(ObjectRepository.msg_menu).click();
					test.log(Status.INFO, "Secure Messages menu clicked");
					
					verifyElementPresent("//div[contains(@aria-label,'"+alrtopts+"')]");
					test.log(Status.INFO, "Message subject verified");
					verifyElementPresent("//div[@test-id='lblSelectedMessageBody' and contains(text(),'"+acnt+"')]");
					test.log(Status.INFO, "Message text verified");
			
					String reply = getElement(ObjectRepository.replyBtn).getAttribute("disabled type");
					if(reply != null){
						Assert.assertTrue(true);
					}else{
						Assert.assertTrue(false);}
					test.log(Status.INFO, "Reply button disabled");
					
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
			test.log(Status.PASS, "Verify Account Balance Alert Setup Via Secure Message scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
