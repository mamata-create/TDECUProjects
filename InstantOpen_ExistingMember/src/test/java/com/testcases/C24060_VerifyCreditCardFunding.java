package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.interactions.Actions;
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

public class C24060_VerifyCreditCardFunding extends GenericKeywords{
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
  public void C24060_VerifyCreditCardFunding() throws InterruptedException, MessagingException, IOException {
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
					String fundingAmt= excl.getCellData(sheetName, 6, startIter);
					String errorMsg= excl.getCellData(sheetName, 30, startIter);
					String letters= excl.getCellData(sheetName, 7, startIter);
					String specialChar= excl.getCellData(sheetName, 8, startIter);
					String seventeenDig= excl.getCellData(sheetName, 9, startIter);
					String ccNum= excl.getCellData(sheetName, 10, startIter);
					String errorMsg2= excl.getCellData(sheetName, 31, startIter);
					String jan= excl.getCellData(sheetName, 11, startIter);
					String feb= excl.getCellData(sheetName, 12, startIter);
					String mar= excl.getCellData(sheetName, 13, startIter);
					String apr= excl.getCellData(sheetName, 14, startIter);
					String may= excl.getCellData(sheetName, 15, startIter);
					String jun= excl.getCellData(sheetName, 16, startIter);
					String jul= excl.getCellData(sheetName, 17, startIter);
					String aug= excl.getCellData(sheetName, 18, startIter);
					String sep= excl.getCellData(sheetName, 19, startIter);
					String oct= excl.getCellData(sheetName, 20, startIter);
					String nov= excl.getCellData(sheetName, 21, startIter);
					String dec= excl.getCellData(sheetName, 22, startIter);
					String ccYear= excl.getCellData(sheetName, 23, startIter);
					String fiveDig= excl.getCellData(sheetName, 24, startIter);
					String cvv= excl.getCellData(sheetName, 25, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic Checking account selected");
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					String fname = getElement(ObjectRepository.fname).getAttribute("value");
					String lname = getElement(ObjectRepository.lname).getAttribute("value");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Member and Applicant Info Verified");
					//Confirm Accounts
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
					getElement(ObjectRepository.fundProdInput1).sendKeys(fundingAmt);
					getElement(ObjectRepository.debitCreditOptn).click();
					scrollToElement(ObjectRepository.cardNumber);
					Actions action = new Actions(driver);	
					action.moveToElement(getElement(ObjectRepository.cvvQuestion)).build().perform();
					verifyElementPresent(ObjectRepository.cvvTooltip);
					getElement(ObjectRepository.submitBtn).click();
					scrollToElement(ObjectRepository.errorMsg);
					verifyText(ObjectRepository.errorMsg,errorMsg);
					getElement(ObjectRepository.cardNumber).sendKeys(letters);
					verifyTxtFieldValue(ObjectRepository.cardNumber,"");
					getElement(ObjectRepository.cardNumber).sendKeys(specialChar);
					getElement(ObjectRepository.cvvInput).click();
					verifyTxtFieldValue(ObjectRepository.cardNumber,"");
					getElement(ObjectRepository.cardNumber).sendKeys(seventeenDig);
					verifyTxtFieldValue(ObjectRepository.cardNumber,ccNum);
					test.log(Status.INFO, "Card Number field validated");
					getElement(ObjectRepository.submitBtn).click();
					scrollToElement(ObjectRepository.errorMsg);
					verifyText(ObjectRepository.errorMsg,errorMsg2);
					selectDropdownOptContain(ObjectRepository.ccMonth,jan);
					selectDropdownOptContain(ObjectRepository.ccMonth,feb);
					selectDropdownOptContain(ObjectRepository.ccMonth,mar);
					selectDropdownOptContain(ObjectRepository.ccMonth,apr);
					selectDropdownOptContain(ObjectRepository.ccMonth,may);
					selectDropdownOptContain(ObjectRepository.ccMonth,jun);
					selectDropdownOptContain(ObjectRepository.ccMonth,jul);
					selectDropdownOptContain(ObjectRepository.ccMonth,aug);
					selectDropdownOptContain(ObjectRepository.ccMonth,sep);
					selectDropdownOptContain(ObjectRepository.ccMonth,oct);
					selectDropdownOptContain(ObjectRepository.ccMonth,nov);
					selectDropdownOpt(ObjectRepository.ccMonth,dec);
					verifyYearDropdown(ObjectRepository.ccYear);
					selectDropdownOpt(ObjectRepository.ccYear,ccYear);
					test.log(Status.INFO, "Card Number expiration fields");
					getElement(ObjectRepository.cvvInput).sendKeys(letters);
					verifyTxtFieldValue(ObjectRepository.cvvInput,"");
					getElement(ObjectRepository.cvvInput).sendKeys(specialChar);
					getElement(ObjectRepository.cardNumber).click();
					verifyTxtFieldValue(ObjectRepository.cvvInput,"");
					getElement(ObjectRepository.cvvInput).sendKeys(fiveDig);
					verifyTxtFieldValue(ObjectRepository.cvvInput,cvv);
					test.log(Status.INFO, "CVV field validated");
					verifyTxtFieldValue(ObjectRepository.ccFname,fname);
					verifyTxtFieldValue(ObjectRepository.ccLname,lname);
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
			test.log(Status.PASS, "Verify credit card funding method for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
