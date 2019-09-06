package Login;

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

public class C23523_VerifyRegisterMyDeviceOption extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify register my device option
	 */

	@BeforeTest
	public void setUp() {
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}

	@Test
	public void C23523_VerifyRegisterMyDeviceOption() throws InterruptedException, MessagingException, IOException
	{
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
		
		getElement(ObjectRepository.donotregister_btn).click();
		test.log(Status.INFO, "Do not register button clicked");
		Thread.sleep(7000);
		
		//Verify log off link available after login
		verifyElementPresent(ObjectRepository.logoff_lnk);
		test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
		getElement(ObjectRepository.logoff_lnk).click();
		test.log(Status.INFO,"Logoff button clicked to logout of the application");
		Thread.sleep(7000);
		driver.get(url);
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

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Register my device option scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
