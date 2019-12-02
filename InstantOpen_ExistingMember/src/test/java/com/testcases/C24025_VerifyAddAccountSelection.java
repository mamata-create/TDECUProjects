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

public class C24025_VerifyAddAccountSelection extends GenericKeywords{
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
  public void C24025_VerifyAddAccountSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String ccAmt= excl.getCellData(sheetName, 6, startIter);
					String ccAmtFormat= excl.getCellData(sheetName, 7, startIter);
					String loanAmt= excl.getCellData(sheetName, 8, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 16, startIter);
					String idNum= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrMonths= excl.getCellData(sheetName, 21, startIter);
					String currentEmp= excl.getCellData(sheetName, 22, startIter);
					String curIncome= excl.getCellData(sheetName, 23, startIter);
					String empYears= excl.getCellData(sheetName, 24, startIter);
					String confirmProd1= excl.getCellData(sheetName, 1, startIter);
					String confirmProd2= excl.getCellData(sheetName, 2, startIter);
					String SSNformat= excl.getCellData(sheetName, 30, startIter);
					String DOBformat= excl.getCellData(sheetName, 31, startIter);
					String issueDtFormat= excl.getCellData(sheetName, 32, startIter);
					String expDtFormat= excl.getCellData(sheetName, 33, startIter);
					String pymtFormat= excl.getCellData(sheetName, 34, startIter);
					String incomeFormat= excl.getCellData(sheetName, 35, startIter);
					String confirmProd3= excl.getCellData(sheetName, 3, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.OnyxCheckBox).click();								
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Products selected");
					//Loan info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					//Applicant Info
					selectDropdownOpt(ObjectRepository.idType,idType);
					getElement(ObjectRepository.idNum).sendKeys(idNum);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information entered");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd1);
					verifyText(ObjectRepository.prodTwo,confirmProd2);
					getElement(ObjectRepository.changeBtn).click();
					test.log(Status.INFO, "Change button clicked");
					//Add account with amount
					verifyElementPresent(ObjectRepository.OnyxCheckedBox);
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay4000CheckBox).click();								
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Product added");
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,ccAmtFormat);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount retained");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");
					//Member verification
					verifyElementPresent(ObjectRepository.mmbrNumRO);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyNum,mmbrNum);
					verifyElementPresent(ObjectRepository.mmbrSSNRO);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifySSN,SSNformat);
					verifyElementPresent(ObjectRepository.mmbrDOBRO);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,DOBformat);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member information retained");
					//Applicant information
					verifyDropdownSelection(ObjectRepository.idType,idType);
					verifyTxtFieldValue(ObjectRepository.idNum,idNum);
					verifyTxtFieldValue(ObjectRepository.issueDate,issueDtFormat);
					verifyTxtFieldValue(ObjectRepository.expDate,expDtFormat);
					verifyTxtFieldValue(ObjectRepository.housePymt,pymtFormat);
					//months not retained
					//verifyTxtFieldValue(ObjectRepository.addrMonths,addrMonths);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					verifyTxtFieldValue(ObjectRepository.currentEmp,currentEmp);
					verifyTxtFieldValue(ObjectRepository.monIncome,incomeFormat);
					verifyTxtFieldValue(ObjectRepository.empYears,empYears);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Applicant Information retained");
					//Verify added account
					verifyText(ObjectRepository.prodOne,confirmProd1);
					verifyText(ObjectRepository.prodTwo,confirmProd3);
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
			test.log(Status.PASS, "Verify product successfully added for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
