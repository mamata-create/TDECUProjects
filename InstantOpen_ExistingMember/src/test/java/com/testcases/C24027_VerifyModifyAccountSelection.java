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

public class C24027_VerifyModifyAccountSelection extends GenericKeywords{
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
  public void C24027_VerifyModifyAccountSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String selectCD1= excl.getCellData(sheetName, 1, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String selectCD2= excl.getCellData(sheetName, 2, startIter);
					String confirmProd1= excl.getCellData(sheetName, 3, startIter);
					String confirmProd2= excl.getCellData(sheetName, 4, startIter);
					String confirmProd3= excl.getCellData(sheetName, 5, startIter);
					String confirmProd4= excl.getCellData(sheetName, 6, startIter);
					String confirmProd5= excl.getCellData(sheetName, 7, startIter);
					String confirmProd6= excl.getCellData(sheetName, 8, startIter);
					String confirmProd7= excl.getCellData(sheetName, 9, startIter);
					String SSNformat= excl.getCellData(sheetName, 30, startIter);
					String DOBformat= excl.getCellData(sheetName, 31, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//Select Products
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,selectCD1);
					getElement(ObjectRepository.visibleCD60).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Checking account and CD selected");
					//Member Verification
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member Verified");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					String maturity = cdMaturityDate(60);					
					String concatProd = confirmProd1+" "+maturity+")";
					verifyText(ObjectRepository.prodOne,concatProd);
					verifyText(ObjectRepository.prodWOptions,confirmProd2);
					verifyText(ObjectRepository.prodWOptionsOne,confirmProd3);
					verifyText(ObjectRepository.prodWOptionsTwo,confirmProd4);
					verifyText(ObjectRepository.prodWOptionsThree,confirmProd7);
					getElement(ObjectRepository.changeBtn).click();
					test.log(Status.INFO, "Change button clicked");
					//Modify accounts
					getElement(ObjectRepository.visibleCD60).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,selectCD2);
					getElement(ObjectRepository.visibleCD6).click();
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.ccDebitCardChecked).click();
					getElement(ObjectRepository.ccMobileChecked).click();
					getElement(ObjectRepository.ccCourtesyPayCheckBox).click();										
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Checking account and CD modified");
					//Member verification
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyNum,mmbrNum);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifySSN,SSNformat);
					verifyTxtFieldValue(ObjectRepository.mmbrVerifyDOB,DOBformat);
					getElement(ObjectRepository.mmbrVerifyNext).click();					
					test.log(Status.INFO, "Member information retained");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Confirm Accounts
					verifyText(ObjectRepository.prodOne,confirmProd2);
					String CDmaturity = cdMaturityDate(6);					
					String concatCD = confirmProd5+" "+CDmaturity+")";
					verifyText(ObjectRepository.prodWOptionsTwo,concatCD);
					verifyText(ObjectRepository.prodWOptionsOne,confirmProd6);
					verifyText(ObjectRepository.prodWOptions,confirmProd4);
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
			test.log(Status.PASS, "Verify product selection modified for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
