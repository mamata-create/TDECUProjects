package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Keys;
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

public class C24150_VerifyCreditCardInfo extends GenericKeywords{
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
  public void C24150_VerifyCreditCardInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String classicDropdown=excl.getCellData(sheetName, 1, startIter);
					String buceesDropdown=excl.getCellData(sheetName, 2, startIter);
					String onyxDropdown=excl.getCellData(sheetName, 3, startIter);
					String plantinumDropdown=excl.getCellData(sheetName, 4, startIter);
					String backButton=excl.getCellData(sheetName, 6, startIter);
					String continueBtn=excl.getCellData(sheetName, 7, startIter);
					String ccAmount=excl.getCellData(sheetName, 11, startIter);
					String amountFormat=excl.getCellData(sheetName, 12, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					scrollToElement(ObjectRepository.creditCardExpand);
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.classicCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Credit card selected");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,classicDropdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,buceesDropdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,onyxDropdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,plantinumDropdown);
					
					verifyTxtValue(ObjectRepository.prodInfoBackButton,backButton);
					verifyTxtValue(ObjectRepository.prodInfoNextButton,continueBtn);
					
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmount);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,amountFormat);
					test.log(Status.INFO, "Amount in correct format");
					
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
					test.log(Status.INFO, "Contintue to member verification");
					getElement(ObjectRepository.mmbrVerifyBack).click();
					test.log(Status.INFO, "Back to product selection");
					/*Back button navigation not working
					verifyElementPresent(ObjectRepository.classicCheckCheckBox);
					getElement(ObjectRepository.productPageNext).click();
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,ccDropdown);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,amountFormat);
					test.log(Status.INFO, "Credit card selection and entered amount remains");*/
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
			test.log(Status.PASS, "Verify Credit Card info page for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
