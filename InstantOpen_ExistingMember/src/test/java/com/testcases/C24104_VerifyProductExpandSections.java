package com.testcases;

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

public class C24104_VerifyProductExpandSections extends GenericKeywords {
	ExtentReports extent;
	ExtentTest test;
	
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
	  public void C24104_VerifyProductExpandSections() {
		  if(continuetestcase==true)
		  {
				sheetName = "ProdSelection";
				int totalRowCount = excl.getRowCount(sheetName);
				for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
				 {	
					if(this.getClass().getSimpleName().equals(excl.getCellData("ProdSelection", 0, startIter)))
					{
						verifyElementPresent(ObjectRepository.app_ttl);
						test.log(Status.INFO, "Instant Open Title appearing");
						
						scrollToElement(ObjectRepository.mmbrstrt_btn);
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						
						scrollToElement(ObjectRepository.creditCardExpand);
						getElement(ObjectRepository.creditCardExpand).click();
						test.log(Status.INFO, "Credit Card section expanded");
						getElement(ObjectRepository.creditCardExpand).click();
						test.log(Status.INFO, "Credit Card section collapsed");
						
						getElement(ObjectRepository.carLoanExpand).click();
						test.log(Status.INFO, "Vehicle Loan section expanded");
						getElement(ObjectRepository.carLoanExpand).click();
						test.log(Status.INFO, "Vehicle Loan section collapsed");
						
						getElement(ObjectRepository.personalLoanExpand).click();
						test.log(Status.INFO, "Personal Loan section expanded");
						getElement(ObjectRepository.personalLoanExpand).click();
						test.log(Status.INFO, "Personal Loan section collapsed");
						
						scrollToElement(ObjectRepository.cdExpand);
						getElement(ObjectRepository.cdExpand).click();
						test.log(Status.INFO, "Certificate of Deposit section expanded");
						getElement(ObjectRepository.cdExpand).click();
						test.log(Status.INFO, "Certificate of Deposit section collapsed");
						
						getElement(ObjectRepository.checkingExpand).click();
						test.log(Status.INFO, "Checking and Money Market section expanded");
						getElement(ObjectRepository.checkingExpand).click();
						test.log(Status.INFO, "Checking and Money Market section collapsed");
						
						getElement(ObjectRepository.savingsExpand).click();
						test.log(Status.INFO, "Savings Account section expanded");
						getElement(ObjectRepository.savingsExpand).click();
						test.log(Status.INFO, "Savings Account section collapsed");
						
						getElement(ObjectRepository.addtionalExpand).click();
						test.log(Status.INFO, "Additional Services and Feautures section expanded");
						getElement(ObjectRepository.addtionalExpand).click();
						test.log(Status.INFO, "Additional Services and Feautures section collapsed");
						
						
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
		  	test.log(Status.PASS, "Verify existing member product selection information");
		  }
	  }

		@AfterTest
		public void tearDown() {
			extent.flush();
			driver.quit();
		}
	  
}
