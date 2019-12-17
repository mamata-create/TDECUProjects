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

public class C24322_VerifyBeneficiaryRoles extends GenericKeywords{
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
  public void C24322_VerifyBeneficiaryRoles() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String cdSelection= excl.getCellData(sheetName, 1, startIter);
					String cdTitle= excl.getCellData(sheetName, 2, startIter);
					String cdConfirm= excl.getCellData(sheetName, 3, startIter);
					String ccTitle= excl.getCellData(sheetName, 4, startIter);
					String vehicleTitle= excl.getCellData(sheetName, 5, startIter);
					String loanTitle= excl.getCellData(sheetName, 6, startIter);
					String moneyMarketTitle= excl.getCellData(sheetName, 7, startIter);
					String checkingTitle= excl.getCellData(sheetName, 8, startIter);
					String savingsTitle= excl.getCellData(sheetName, 9, startIter);
					String prodAmt= excl.getCellData(sheetName, 10, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idType= excl.getCellData(sheetName, 11, startIter);
					String idNum= excl.getCellData(sheetName, 12, startIter);
					String issueDt= excl.getCellData(sheetName, 13, startIter);
					String expDt= excl.getCellData(sheetName, 14, startIter);
					String housePymt= excl.getCellData(sheetName, 15, startIter);
					String howLong= excl.getCellData(sheetName, 16, startIter);
					String currentEmp= excl.getCellData(sheetName, 17, startIter);
					String curIncome= excl.getCellData(sheetName, 18, startIter);
					String beneFname= excl.getCellData(sheetName, 19, startIter);
					String beneLname= excl.getCellData(sheetName, 20, startIter);
					String beneDOB= excl.getCellData(sheetName, 21, startIter);
					String beneSSN= excl.getCellData(sheetName, 22, startIter);
					String benePhone= excl.getCellData(sheetName, 23, startIter);
					String benePhoneType= excl.getCellData(sheetName, 24, startIter);
					String beneEmail= excl.getCellData(sheetName, 25, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.OnyxCheckBox).click();
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.watercraftCheckBox).click();
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.homeAdvCheckBox).click();
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,cdSelection);
					getElement(ObjectRepository.visibleCD48).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.mnyMrktCheckBox).click();
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Products selected");
					//Product info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(prodAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(prodAmt);
					getElement(ObjectRepository.carPurchPrice).sendKeys(prodAmt);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Vehicle loan info entered");
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(prodAmt);
					getElement(ObjectRepository.prodLimitTextbox).click();
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Personal loan amount entered");
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
					getElement(ObjectRepository.addrMonths).sendKeys(howLong);
					getElement(ObjectRepository.currentEmp).sendKeys(currentEmp);
					getElement(ObjectRepository.monIncome).sendKeys(curIncome);
					getElement(ObjectRepository.empYears).sendKeys(howLong);
					test.log(Status.INFO, "Applicant Information entered");
					getElement(ObjectRepository.addBeneCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Add Beneficiaries checkbox selected");
					//Beneficiary
					getElement(ObjectRepository.addFname).sendKeys(beneFname);
					getElement(ObjectRepository.addLname).sendKeys(beneLname);
					getElement(ObjectRepository.sameAddrCbox).click();
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(beneDOB);
					getElement(ObjectRepository.addSSN).sendKeys(beneSSN);
					getElement(ObjectRepository.addPhone).sendKeys(benePhone);
					selectDropdownOpt(ObjectRepository.addPhoneType,benePhoneType);
					getElement(ObjectRepository.addEmail).sendKeys(beneEmail);
					test.log(Status.INFO, "Beneficiary information entered");
					getElement(ObjectRepository.productPageNext).click();
					//Account Roles	
					verifyText(ObjectRepository.rolesProdOne,ccTitle);
					verifyElementPresent(ObjectRepository.primaryRoleOne);
					verifyElementPresent(ObjectRepository.roleDisabledOne);
					verifyText(ObjectRepository.rolesProdTwo,vehicleTitle);
					verifyElementPresent(ObjectRepository.primaryRoleTwo);
					verifyElementPresent(ObjectRepository.roleDisabledTwo);
					verifyText(ObjectRepository.rolesProdThree,loanTitle);
					verifyElementPresent(ObjectRepository.primaryRoleThree);
					verifyElementPresent(ObjectRepository.roleDisabledThree);
					test.log(Status.INFO, "Account Roles for credit card and loans read only");
					verifyText(ObjectRepository.rolesProdFour,cdTitle);
					verifyElementPresent(ObjectRepository.primaryRoleFour);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdFive,moneyMarketTitle);
					verifyElementPresent(ObjectRepository.primaryRoleFive);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdSix,checkingTitle);
					verifyElementPresent(ObjectRepository.primaryRoleSix);
					getElement(ObjectRepository.jointRoleChecked).click();
					verifyText(ObjectRepository.rolesProdSeven,savingsTitle);
					verifyElementPresent(ObjectRepository.primaryRoleSeven);
					getElement(ObjectRepository.jointRoleChecked).click();
					test.log(Status.INFO, "Account Roles deselected");
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.jointRoleNotChecked).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Account Roles selected");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,ccTitle);
					verifyText(ObjectRepository.prodTwo,vehicleTitle);
					verifyText(ObjectRepository.prodWOptionsThree,loanTitle);
					String maturity = cdMaturityDate(48);					
					String concatProd = cdConfirm+" "+maturity+")";
					verifyText(ObjectRepository.prodFour,concatProd);
					verifyText(ObjectRepository.prodFive,moneyMarketTitle);
					verifyText(ObjectRepository.prodSix, checkingTitle);
					verifyText(ObjectRepository.prodSeven,savingsTitle);
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
			test.log(Status.PASS, "Verify beneficiary account roles for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
