package WireTransfer;

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

public class C23455_VerifyWireTransferSortRecipients extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Wire Transfer Sort Recipients
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
	public void C23455_VerifyWireTransferSortRecipients() throws InterruptedException, MessagingException, IOException
	{
		//Click Services option
		getElement(ObjectRepository.service_menu).click();
		test.log(Status.INFO, "Service menu clicked");
		
		getElement(ObjectRepository.wiretrnsfr_menu).click();
		test.log(Status.INFO, "Wire Transfer menu clicked");
		Thread.sleep(3000);
	//Verify Wire Transfer page title
		verifyElementPresent(ObjectRepository.wiretrnsfr_ttl);
		test.log(Status.INFO, "Wire Transfer page opened and title available");
		
		getElement(ObjectRepository.listvw_btn).click();
		test.log(Status.INFO, "List View button clicked");
		Thread.sleep(2000);
		
		verifyElementPresent(ObjectRepository.gridacnt_col);
		test.log(Status.INFO, "List view appearing");
		
		getElement(ObjectRepository.gridvw_btn).click();
		test.log(Status.INFO, "Grid View button clicked");
		Thread.sleep(2000);
		
		verifyElementNotPresent(ObjectRepository.gridacnt_col);
		test.log(Status.INFO, "Grid view appearing");
		
		getElement(ObjectRepository.sort_dropdown).click();
		test.log(Status.INFO, "Sorting dropdown clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.sortAtoZ_opt).click();
		test.log(Status.INFO, "Sort A-Z option clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.sort_dropdown).click();
		test.log(Status.INFO, "Sorting dropdown clicked");
		Thread.sleep(2000);
		
		getElement(ObjectRepository.sortZtoA_opt).click();
		test.log(Status.INFO, "Sort Z-A option clicked");
		Thread.sleep(2000);
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Wire Transfer Sort Recipient scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
