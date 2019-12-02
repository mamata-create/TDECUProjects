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

public class C24070_VerifyMemberVerification extends GenericKeywords{
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
  public void C24070_VerifyMemberVerification() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String ccAmount= excl.getCellData(sheetName, 6, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String SSNformat= excl.getCellData(sheetName, 30, startIter);
					String DOBformat= excl.getCellData(sheetName, 31, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select credit card and enter amount
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Platinum credit card selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					//Member Verification fields
					verifyElementPresent(ObjectRepository.mmbrNumLabel);
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyNum,mmbrNum);
					test.log(Status.INFO, "Member number entered");
					verifyElementPresent(ObjectRepository.mmbrSSNlabel);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifySSN,SSNformat);
					test.log(Status.INFO, "SSN entered");
					verifyElementPresent(ObjectRepository.mmbrDOBlabel);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,DOBformat);
					test.log(Status.INFO, "DOB entered");
					getElement(ObjectRepository.mmbrVerifyNext).click();
					verifyElementPresent(ObjectRepository.yourInfoTtl);					
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
			test.log(Status.PASS, "Verify Member Verification fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }
}
