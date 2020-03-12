package HomePage;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com.github.javafaker.Faker;

public class C26854_VerifyCheckingSavingsAndCDsSection extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * As an applicant, I would like to know what information I need to have available to apply for a deposit account.
	 * Creation Date: 03/12/2020
	 * Created By: Ashish
	 */
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		
		System.out.println("Test Started");
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}
	
	@Test
	public void C26854_VerifyCheckingSavingsAndCDsSection() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
		
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
						
					verifyElementPresent(ObjectRepository.for_CheckingSavings_Cds);
					test.log(Status.INFO, "For checking, savings and CDs Section Displayed");
					
					verifyElementPresent(ObjectRepository.ssn_CheckingSavings_Cds);
					test.log(Status.INFO, "Social Security Number Displayed");
					
					
					verifyElementPresent(ObjectRepository.ssn_CheckingSavings_Cds);
					test.log(Status.INFO, "Government issued identification Displayed");
					
					verifyElementPresent(ObjectRepository.ssn_CheckingSavings_Cds);
					test.log(Status.INFO, "Credit/debit card or existing bank account details to fund your new account Displayed");
					
					
				 
			 }
		
				
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "As an applicant, I would like to know what information I need to have available to apply for a deposit account.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
