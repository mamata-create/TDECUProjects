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

public class C24314_VerifyCheckingAccountSelection2 extends GenericKeywords{
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
  public void C24314_VerifyCheckingAccountSelection2() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String prodName1= excl.getCellData(sheetName, 1, startIter);
					String prodName2= excl.getCellData(sheetName, 2, startIter);
					String loanAmount= excl.getCellData(sheetName, 11, startIter);
					String prodAmount= excl.getCellData(sheetName, 12, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idTypeDD= excl.getCellData(sheetName, 16, startIter);
					String idNumber= excl.getCellData(sheetName, 17, startIter);
					String issueDt= excl.getCellData(sheetName, 18, startIter);
					String expireDt= excl.getCellData(sheetName, 19, startIter);
					String housePymt= excl.getCellData(sheetName, 20, startIter);
					String addrYears= excl.getCellData(sheetName, 21, startIter);
					String addrMonths= excl.getCellData(sheetName, 22, startIter);
					String currentEmp= excl.getCellData(sheetName, 23, startIter);
					String curIncome= excl.getCellData(sheetName, 24, startIter);
					String empYears= excl.getCellData(sheetName, 25, startIter);
					String empMonths= excl.getCellData(sheetName, 26, startIter);
					String confirmProd2= excl.getCellData(sheetName, 3, startIter);
					String errorMsg1= excl.getCellData(sheetName, 30, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.highYieldCheckBox).click();
					test.log(Status.INFO, "Checking accounts selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					//Your Information
					verifyElementPresent(ObjectRepository.yourInfoTtl);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,prodName1);
					verifyText(ObjectRepository.prodWOptionsTwo,prodName2);
					test.log(Status.INFO, "High Yield checking is not displayed");
					getElement(ObjectRepository.changeBtn).click();
					test.log(Status.INFO, "Change button clicked");
					//Select another product
					verifyElementPresent(ObjectRepository.ccChecked);
					verifyElementNotPresent(ObjectRepository.highYieldTitle);
					test.log(Status.INFO, "High Yield section is not displayed");
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.camperLoanCheckBox).click();
					test.log(Status.INFO, "Vehicle Loan selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.carPurchPrice).sendKeys(prodAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan amount entered");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNext).click();
					test.log(Status.INFO, "Member Verified");
					//Your Information
					selectDropdownOpt(ObjectRepository.idType,idTypeDD);
					getElement(ObjectRepository.idNum).sendKeys(idNumber);
					getElement(ObjectRepository.issueDate).sendKeys(issueDt);
					getElement(ObjectRepository.expDate).sendKeys(expireDt);
					getElement(ObjectRepository.housePymt).sendKeys(housePymt);
					getElement(ObjectRepository.addrYears).sendKeys(addrYears);
					getElement(ObjectRepository.addrMonths).sendKeys(addrMonths);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(empYears);
					getElement(ObjectRepository.empMonths).sendKeys(empMonths);
					test.log(Status.INFO, "Applicant information entered");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,prodName1);
					verifyText(ObjectRepository.prodWOptionsTwo,confirmProd2);
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Account selections confirmed");
					//Agreements and Disclosures
					getElement(ObjectRepository.termsAndCondCheckBox).click();
					getElement(ObjectRepository.agreeAndSignCheckBox).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Terms and conditions accepted");
					//Identity Verification
					getElement(ObjectRepository.questionOne).click();
					getElement(ObjectRepository.questionTwo).click();
					getElement(ObjectRepository.questionThree).click();
					getElement(ObjectRepository.questionFour).click();
					getElement(ObjectRepository.confirmBtn).click();
					test.log(Status.INFO, "Identity Verification questions answered");
					//Account Funding
					verifyElementPresent(ObjectRepository.acctFundTitle);
					getElement(ObjectRepository.submitBtn).click();
					verifyText(ObjectRepository.errorMsg1,errorMsg1);
					test.log(Status.INFO, "Enter amount message displayed");
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
			test.log(Status.PASS, "Verify checking account selection for existing member with high yield checking");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }
}

