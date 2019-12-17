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

public class C24301_VerifyBeneficiaryReqFields extends GenericKeywords{
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
  public void C24301_VerifyBeneficiaryReqFields() throws InterruptedException, MessagingException, IOException {
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
					String beneFname= excl.getCellData(sheetName, 23, startIter);
					String beneLname= excl.getCellData(sheetName, 24, startIter);
					String beneDOB= excl.getCellData(sheetName, 25, startIter);
					String beneSSN= excl.getCellData(sheetName, 26, startIter);
					String textError= excl.getCellData(sheetName, 30, startIter);
					String addrError= excl.getCellData(sheetName, 31, startIter);
					String dobError= excl.getCellData(sheetName, 32, startIter);
					String phoneError= excl.getCellData(sheetName, 33, startIter);
					String emailError= excl.getCellData(sheetName, 34, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Club account selected");
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
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,textError);
					verifyText(ObjectRepository.errorMsg2,addrError);
					test.log(Status.INFO, "Error messages displayed for Applicant info required fields");
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.productPageNext).click();
					verifyText(ObjectRepository.errorMsg1,dobError);
					verifyText(ObjectRepository.errorMsg2,textError);
					test.log(Status.INFO, "Error messages displayed for Identification info required fields");
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addButton).click();
					verifyText(ObjectRepository.errorMsg1,phoneError);
					verifyText(ObjectRepository.errorMsg2,emailError);
					test.log(Status.INFO, "Error messages displayed for Contact info required fields");
					
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
			test.log(Status.PASS, "Verify beneficiary required fields for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
