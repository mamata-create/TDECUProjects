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

public class C26855_VerifyLoanCreditCardCriteriaDetails extends GenericKeywords  {
	ExtentReports extent;
	ExtentTest test;
	/*
	 * IO: As an applicant, I would like to know what information I need to have available to apply for a loan or credit card.
	 * @author: apandey
	 * @created: 12March2020
	 */
	@BeforeTest
	public void setUp() throws InterruptedException, MessagingException, IOException {
		
		extent = ExtentManager.GetExtent();
		test = extent.createTest(this.getClass().getSimpleName());
		BaseClass iDriver = new BaseClass();
		iDriver.myTestCaseName = this.getClass().getSimpleName();
		executeDriverScript();
		test.log(Status.INFO, "Application url navigated");
		
	}
	
	@Test
	public void C26855_VerifyLoanCreditCardCriteriaDetails() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			String page_header= "Are You Ready to Experience the TDECU Difference?";
			String [] criteria = {"Social Security Number","Government issued identification","Employment information","Income details"};
			
			// VERIFY IF PAGE IS LOADED PROPERLY
			verifyElementPresent(ObjectRepository.app_ttl);
			test.log(Status.INFO, "Instant Open Title appearing");
			
			verifyText(ObjectRepository.page_header_locator,page_header);
			
			// VERIFY IF LOAN, CREDIT CARD SECTION AS WELL ITS CRITERIA IS VISIBLE
			verifyElementPresent(ObjectRepository.loanCreditCard_sectn_locator);
			test.log(Status.INFO, "For loans and credit cards section is visible");
			
			for(int criteriaIndex=0; criteriaIndex<4; criteriaIndex++){
				verifyText(ObjectRepository.lcc_criteria(criteriaIndex+1), criteria[criteriaIndex]);
				test.log(Status.INFO, criteria[criteriaIndex]+ " visible");
				}
			}	
			
		}
				
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "IO: As an applicant, I would like to know what information I need to have available to apply for a loan or credit card.");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
