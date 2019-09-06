package com.test.DNA;

import java.awt.AWTException;
import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
/*import org.sikuli.script.FindFailed;*/
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

public class C24213_VerifySingleCheckStopPayment extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Single Check Stop Payment
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
	public void C24213_VerifySingleCheckStopPayment_DNA_Upgrade() throws InterruptedException, MessagingException, IOException, AWTException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "DNA_Upgrade";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData(sheetName, 0, startIter)))
				 {
					String chknumber=excl.getCellData(sheetName, 5, startIter);				
					String amount =excl.getCellData(sheetName, 3, startIter);
					String payeeName = excl.getCellData(sheetName, 7, startIter);
					String note = excl.getCellData(sheetName, 4, startIter);
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
					
					getElement(ObjectRepository.stppaymnt_snglchk).click();
					test.log(Status.INFO, "Single Check link clicked");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.stppaymnt_acnt).click();
					test.log(Status.INFO, "Account clicked");
					Thread.sleep(3000);
					
					for(int i=0;i<chknumber.length();i++){
						char chr=chknumber.charAt(i);
						getElement("//span[@class='integerInputButtonText' and text()='"+chr+"']").click();
					}
					
					Thread.sleep(3000);
									
					WebElement ele=getElement(ObjectRepository.stppaymnt_svbtn);
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", ele);
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					
					getElement(ObjectRepository.payeeName).sendKeys(payeeName);
					Thread.sleep(2000);
					getElement(ObjectRepository.setBtn).click();
					
					
					String singleDigit = amount.split(",")[0].trim();
					String noOfZero = amount.split(",")[1].trim();
					getElement("//span[@class='integerInputButtonText' and text()='"+singleDigit+"']").click();
					for(int count=0;count<=Integer.parseInt(noOfZero);count++){
						//char eachamount = amount.charAt(count);
						getElement("//span[@class='integerInputButtonText' and text()='0']").click();
					}
					
					Thread.sleep(3000);
					
					jsclick(getElement(ObjectRepository.stppaymnt_svbtn));
					test.log(Status.INFO, "Save button clicked");
					Thread.sleep(3000);
					
					Thread.sleep(3000);
					selectFutureDate(2);
					test.log(Status.INFO, "Future date selected");
					Thread.sleep(3000);
					
					getElement(ObjectRepository.note).sendKeys(note);
					Thread.sleep(2000);
					getElement(ObjectRepository.setBtn).click();
					
					getElement(ObjectRepository.stppaymnt_sndrqst_btn).click();
					test.log(Status.INFO, "Send Request button clicked");
					Thread.sleep(10000);
					validateStopPayment();
					
					
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
			test.log(Status.PASS, "Verify Single Check Stop Payment scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
