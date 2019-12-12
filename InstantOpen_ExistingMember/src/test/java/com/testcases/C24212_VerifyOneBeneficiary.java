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

public class C24212_VerifyOneBeneficiary extends GenericKeywords{
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
  public void C24212_VerifyOneBeneficiary() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String beneFname= excl.getCellData(sheetName, 11, startIter);
					String beneMname= excl.getCellData(sheetName, 12, startIter);
					String beneLname= excl.getCellData(sheetName, 13, startIter);
					String beneStreet= excl.getCellData(sheetName, 14, startIter);
					String beneZip= excl.getCellData(sheetName, 15, startIter);
					String beneDOB= excl.getCellData(sheetName, 16, startIter);
					String beneSSN= excl.getCellData(sheetName, 17, startIter);
					String beneIdType= excl.getCellData(sheetName, 18, startIter);
					String beneIdNum= excl.getCellData(sheetName, 19, startIter);
					String beneIssueDt= excl.getCellData(sheetName, 20, startIter);
					String beneExpDt= excl.getCellData(sheetName, 21, startIter);
					String benePhone= excl.getCellData(sheetName, 22, startIter);
					String benePhoneType= excl.getCellData(sheetName, 23, startIter);
					String beneEmail= excl.getCellData(sheetName, 24, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Money Market account selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries checkbox selected");
					//Beneficiary
					verifyElementPresent(ObjectRepository.addBeneTtl);
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addMname).sendKeys(beneMname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.addStreet).sendKeys(beneStreet);
					getElement(ObjectRepository.addZip).sendKeys(beneZip);
					test.log(Status.INFO, "Applicant Information entered for Beneficiary");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					selectDropdownOpt(ObjectRepository.idType,beneIdType);
					getElement(ObjectRepository.idNum).sendKeys(beneIdNum);
					getElement(ObjectRepository.issueDate).sendKeys(beneIssueDt);
					getElement(ObjectRepository.expDate).sendKeys(beneExpDt);
					test.log(Status.INFO, "Identification Information entered for Beneficiary");
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Contact Information entered for Beneficiary");
					getElement(ObjectRepository.productPageNext).click();
					verifyElementPresent(ObjectRepository.confirmTtl);
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
			test.log(Status.PASS, "Verify one beneficiary added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
