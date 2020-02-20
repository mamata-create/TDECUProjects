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

public class C25185_VerifyFinancialToolsOptions  extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify financial tools options
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
	public void C25185_VerifyFinancialToolsOptions() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
					
				Thread.sleep(15000);		
			verifyElementPresent(ObjectRepository.spndng_tab);
			test.log(Status.INFO, "Spending tab appeared");
			
			verifyElementPresent(ObjectRepository.budget_tab);
			test.log(Status.INFO, "Budget tab appeared");
			
			verifyElementPresent(ObjectRepository.trends_tab);
			test.log(Status.INFO, "Trends tab appeared");
			
			verifyElementPresent(ObjectRepository.cashflow_tab);
			test.log(Status.INFO, "Cash flow tab appeared");
			
			verifyElementPresent(ObjectRepository.netwrth_tab);
			test.log(Status.INFO, "Net Worth tab appeared");
			
			verifyElementPresent(ObjectRepository.debts_tab);
			test.log(Status.INFO, "Debts tab appeared");
			
			
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify financial tools options scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
