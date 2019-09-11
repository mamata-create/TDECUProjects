package com.testcases;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class C24249_VerifyUserNeedsToCheckAccountOptionToProccedNextPage extends GenericKeywords {

	ExtentReports extent;
	ExtentTest test;
	/*
	 * Verify User needs to check account option to procced next page
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
	public void C24249_VerifyUserNeedsToCheckAccountOptionToProccedNextPage() throws InterruptedException, MessagingException, IOException
	{
		
		if(continuetestcase==true)
		{
			sheetName = "Data";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("Data", 0, startIter)))
				 {
					
					//String mname=excl.getCellData(sheetName, 2, startIter);
					String serviceOption = " Debit Card, Mobile Check Deposit, Overdraft Protection Plan, Opt into Courtesy Pay";
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.nonmmbrstrt_btn);
					getElement(ObjectRepository.nonmmbrstrt_btn).click();
					test.log(Status.INFO, "Non Member Start here button clicked");
					
					Thread.sleep(3000);
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					
					List<WebElement>errors = driver.findElements(By.xpath("//span[@id='ErrorSummary1']//li"));
					for(int count=1;count<=errors.size();count++){
						String eachErrorLocator = "//span[@id='ErrorSummary1']//li["+count+"]";
						String eachErrorValue = driver.findElement(By.xpath(eachErrorLocator)).getAttribute("innerText");
						verifyText(eachErrorLocator,eachErrorValue);
						
					}
					
					scrollToElement(ObjectRepository.nochkacnt_rdbtn);
					serviceOptionValidation("Classic Checking",serviceOption);
					
					
					getElement(ObjectRepository.othrprdctno_rdbtn).click();
					test.log(Status.INFO, "Other products no radio button clicked");
					
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					Thread.sleep(3500);
					verifyText(ObjectRepository.primaryApplicantInfoPageTitle,"Primary Applicant Information");
					
					
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
			test.log(Status.PASS, "Verify user needs to check an account option to procced next page");
		}
	}

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}

}
