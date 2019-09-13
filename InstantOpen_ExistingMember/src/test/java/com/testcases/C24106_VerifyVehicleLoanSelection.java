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

public class C24106_VerifyVehicleLoanSelection extends GenericKeywords {
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
  public void C24106_VerifyVehicleLoanSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "LoanData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("LoanData", 0, startIter)))
				 {
					String autoTitle=excl.getCellData(sheetName, 1, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.carLoanExpand).click();
					test.log(Status.INFO, "Vehicle Loan secion expanded");
					
					verifyText(ObjectRepository.autoLoanTitle,autoTitle);
					autoLoanInfoValidation();
					
					getElement(ObjectRepository.autoLoanRates).click();
					String parentWindow = driver.getWindowHandle();
					for(String winHandle : driver.getWindowHandles()){
					    driver.switchTo().window(winHandle);
					}
					driver.close();
					driver.switchTo().window(parentWindow);
					
				 }
			 }
		}
  }
 /* @AfterMethod
  public void afterMethod(ITestResult result) throws Throwable {
	  if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Failed-" + result.getThrowable());

			takescreenshot(this.getClass().getSimpleName(), test);
		} else {
			test.log(Status.PASS, "Verify credit card selection for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }*/

}
