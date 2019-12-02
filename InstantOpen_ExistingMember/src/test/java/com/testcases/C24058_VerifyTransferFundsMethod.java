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

public class C24058_VerifyTransferFundsMethod extends GenericKeywords{
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
  public void C24058_VerifyTransferFundsMethod() throws InterruptedException, MessagingException, IOException {
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
					String confirmProd= excl.getCellData(sheetName, 1, startIter);
					String validAmt= excl.getCellData(sheetName, 11, startIter);
					String dDownLbl= excl.getCellData(sheetName, 6, startIter);
					String error= excl.getCellData(sheetName, 7, startIter);
					String dDown1= excl.getCellData(sheetName, 2, startIter);
					String dDown2= excl.getCellData(sheetName, 3, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic Checking account selected");
					//Member info
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Member and Applicant Info Verified");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd);
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selection confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.discCheckBox).click();
					getElement(ObjectRepository.agreeCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Agreements and Disclosures accepted");
					//Identity Questions
					getElement(ObjectRepository.qstnOneOptnOne).click();
					getElement(ObjectRepository.qstnTwoOptnTwo).click();
					getElement(ObjectRepository.qstnThreeOptnThree).click();
					getElement(ObjectRepository.qstnFourOptnFour).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Identity questions answered");
					//Account Funding
					getElement(ObjectRepository.fundProdInput1).sendKeys(validAmt);
					getElement(ObjectRepository.transferOptn).click();
					test.log(Status.INFO, "Transfer Funds method selected");
					verifyText(ObjectRepository.accountDdownLbl,dDownLbl);
					getElement(ObjectRepository.submitBtn).click();
					verifyText(ObjectRepository.errorMsg1,error);
					verifyElementPresent(ObjectRepository.accountDdownError);
					fundingDropdownContains(ObjectRepository.accountDdown, dDown1);
					fundingDropdownContains(ObjectRepository.accountDdown, dDown2);
					test.log(Status.INFO, "Avaialble listed accounts verified");
					getElement(ObjectRepository.submitBtn).click();
					verifyElementPresent(ObjectRepository.submitApp);
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
			test.log(Status.PASS, "Verify transfer funds method for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}