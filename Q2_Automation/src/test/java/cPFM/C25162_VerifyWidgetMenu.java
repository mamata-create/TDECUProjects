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

public class C25162_VerifyWidgetMenu extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify Widget Menu
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
				Thread.sleep(2000);
				test.log(Status.INFO, "Login ID entered");
				
				//enter password
				getElement(ObjectRepository.password_txt).sendKeys(password);
				Thread.sleep(2000);
				test.log(Status.INFO, "Password entered");
				
				//click login button
				getElement(ObjectRepository.login_btn).click();
				Thread.sleep(2000);
				test.log(Status.INFO, "Login button clicked");
				test.log(Status.INFO, "Login xxxxxx");
				
				//click login button
				//Verify log off link available after login
				verifyElementPresent(ObjectRepository.logoff_lnk);
				Thread.sleep(2000);
				test.log(Status.INFO, "User successfully logged in as Logoff link available");
		
	}
	
	@Test
	public void C25162_VerifyWidgetMenu() throws InterruptedException, MessagingException, IOException
	{
		
		verifyElementPresent(ObjectRepository.spndng_tab);
		Thread.sleep(2000);
		test.log(Status.INFO, "User successfully logged in and verified spending tab");
		verifyElementPresent(ObjectRepository.budget_tab );
		Thread.sleep(2000);
		test.log(Status.INFO, "Verified buget tab" );
		Thread.sleep(2000);
		verifyElementPresent(ObjectRepository.trends_tab );
		Thread.sleep(2000);
		test.log(Status.INFO, "Verified Trends Tab" );
		Thread.sleep(2000);
		verifyElementPresent(ObjectRepository.cashflow_tab );
		Thread.sleep(2000);
		test.log(Status.INFO, "Verified Cashflow Tab" );
		verifyElementPresent(ObjectRepository.netwrth_tab );
		test.log(Status.INFO, "Verified networth Tab" );
		verifyElementPresent(ObjectRepository.debts_tab );
		test.log(Status.INFO, "Verified Debts tab" );
		
		
			
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify WidgetMenu working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}


}


