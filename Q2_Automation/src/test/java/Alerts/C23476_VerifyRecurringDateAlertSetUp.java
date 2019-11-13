package Alerts;

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

public class C23476_VerifyRecurringDateAlertSetUp extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify date alert SetUp
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
			/*	getElement(ObjectRepository.otpemail_btn).click();
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
	public void C23476_VerifyRecurringDateAlertSetUp() throws InterruptedException, MessagingException, IOException
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
					String alrt_typ=excl.getCellData(sheetName, 2, startIter);
					String msg=excl.getCellData(sheetName, 3, startIter);					
				
				//Click Settings Menu
					getElement(ObjectRepository.stng_menu).click();
					test.log(Status.INFO, "Settings menu clicked");
					
					getElement(ObjectRepository.alrt_menu).click();
					test.log(Status.INFO, "Alerts menu clicked");
				//Verify Alerts page title
					verifyElementPresent(ObjectRepository.alrt_ttl);
					test.log(Status.INFO, "Alerts page opened and title available");
					
					scrollToElement(ObjectRepository.alrtopts_drop);
					
					selectValue(ObjectRepository.alrtopts_drop,ObjectRepository.alrtTypes, alrtopts);
					test.log(Status.INFO, "Alerts type selected");
					
					selectValue(ObjectRepository.alrtsel_typ,ObjectRepository.alrtEvents, alrt_typ);
					test.log(Status.INFO, "Event selected");
					
					selectTodayShadowRootCal(-1);
					test.log(Status.INFO, "Date selected");
					
					enterText(ObjectRepository.alrt_msg,msg);
					test.log(Status.INFO, "Alerts message entered");
					
					getElement(ObjectRepository.alrtsel_dlvrymsg).click();
					test.log(Status.INFO, "Alerts delivery method selected");				

					getElement(ObjectRepository.alrt_svbtn).click();
					test.log(Status.INFO, "Alert save button clicked");
					
					verifyElementPresent(ObjectRepository.alrt_svsccs);
					test.log(Status.INFO, "Alert save success available");
					
					getElement(ObjectRepository.alrt_clsbtn).click();
					test.log(Status.INFO, "Alert close button clicked");
					
					getElement(ObjectRepository.msg_menu).click();
					test.log(Status.INFO, "Secure Messages menu clicked");
					
					verifyElementPresent("//div[contains(@aria-label,'"+alrt_typ+"')]");
					test.log(Status.INFO, "Message subject verified");
					verifyElementPresent("//div[@test-id='lblSelectedMessageBody' and contains(text(),'"+msg+"')]");
					test.log(Status.INFO, "Message text verified");
			
					String reply = getElement(ObjectRepository.replyBtn).getAttribute("disabled");
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
			test.log(Status.PASS, "Verify secure message reminder scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
