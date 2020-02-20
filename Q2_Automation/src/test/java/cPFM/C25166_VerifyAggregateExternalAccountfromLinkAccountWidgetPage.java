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

public class C25166_VerifyAggregateExternalAccountfromLinkAccountWidgetPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify aggregate external account from link account
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
	public void C25166_VerifyAggregateExternalAccountfromLinkAccountWidgetPage() throws InterruptedException, MessagingException, IOException
	{

		if(continuetestcase==true)
		{
				Thread.sleep(15000);
			
			//Verify Link Account section
			verifyElementPresent(ObjectRepository.spndng_tab);
			test.log(Status.INFO, "Financial tool-spending tab available");
			
			//Click spending tab
			getElement(ObjectRepository.spndng_tab).click();
			test.log(Status.INFO, "Financial tool-spending tab clicked");
			
			//Click link account from spending page
			getElement(ObjectRepository.extrnlacnt_lnk).click();
			test.log(Status.INFO, "Link Account button clicked from spending page");
			
			//Verify Link account page displayed		
			verifyElementPresent(ObjectRepository.lnkacnt_ttl);
			test.log(Status.INFO, "Link account page appeared");
					
					
		}
				
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify aggregate external account from link account from Widget page scenario working fine");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
