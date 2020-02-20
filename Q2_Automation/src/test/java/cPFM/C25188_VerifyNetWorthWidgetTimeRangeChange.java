package cPFM;

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

public class C25188_VerifyNetWorthWidgetTimeRangeChange  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Net Worth widget Time Range Change
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
				
				
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}

	@Test
	public void C25188_VerifyNetWorthWidgetTimeRangeChange() throws InterruptedException, MessagingException, IOException
	{
		if(continuetestcase==true)
		{
					
				Thread.sleep(4000);
				verifyElementPresent(ObjectRepository.netwrth_tab);
				test.log(Status.INFO, "Net Worth widget tab appeared");
				
			getElement(ObjectRepository.netwrth_tab).click();
			test.log(Status.INFO, "Net Worth widget tab clicked");
			Thread.sleep(5000);

			driver.switchTo().frame(getElement(ObjectRepository.asst_frame));
			
			verifyElementPresent(ObjectRepository.netwrth_6m);
			test.log(Status.INFO, "Net Worth widget 6 month history button appeared");
			
			verifyElementPresent(ObjectRepository.netwrth_9m);
			test.log(Status.INFO, "Net Worth widget 9 month history button appeared");
			
			verifyElementPresent(ObjectRepository.netwrth_1y);
			test.log(Status.INFO, "Net Worth widget 1 year history button appeared");
			
			getElement(ObjectRepository.netwrth_6m).click();
			test.log(Status.INFO, "Net Worth widget 6m history filtered by clicking 6m button");
			Thread.sleep(5000);
			
			getElement(ObjectRepository.netwrth_9m).click();
			test.log(Status.INFO, "Net Worth widget 9m history filtered by clicking 9m button");
			Thread.sleep(5000);
			
			getElement(ObjectRepository.netwrth_1y).click();
			test.log(Status.INFO, "Net Worth widget 1y history filtered by clicking 1y button");
			Thread.sleep(5000);
					
				}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify Net Worth widget Time Range Change scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
