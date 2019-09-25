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

public class C24260_VerifyBackButton extends GenericKeywords{
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
  public void C24260_VerifyBackButton() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String amount1= excl.getCellData(sheetName, 11, startIter);
					String amount2= excl.getCellData(sheetName, 12, startIter);
					String amount3= excl.getCellData(sheetName, 13, startIter);
					String amount4= excl.getCellData(sheetName, 14, startIter);
					String ccValue = "$2,000";
					String carLoanValue = "$5,000";
					String carPrice = "$10,000";
					String personalLoan = "$500";
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Credit Card selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount1);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
					getElement(ObjectRepository.mmbrVerifyBack).click();
					test.log(Status.INFO, "Back button clicked");
					//Back button navigation currently not working
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.platinumCheckedBox);
					
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatLoanCheckBox).click();
					test.log(Status.INFO, "Vehicle Loan selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);					
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,ccValue);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount2);
					getElement(ObjectRepository.carPurchPrice).sendKeys(amount3);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
					
					getElement(ObjectRepository.mmbrVerifyBack).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,carLoanValue);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,carPrice);
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);					
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,ccValue);
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.boatLoanCheckedBox);
					getElement(ObjectRepository.creditCardExpand).click();
					verifyElementPresent(ObjectRepository.platinumCheckedBox);
					
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.shareSecuredCheckBox).click();
					test.log(Status.INFO, "Personal Loan selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);					
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,ccValue);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,carLoanValue);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,carPrice);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount4);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
					
					getElement(ObjectRepository.mmbrVerifyBack).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.psnlLoanInfTtl);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,personalLoan);
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,carLoanValue);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,carPrice);
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);					
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,ccValue);
					
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back button clicked");
					verifyElementPresent(ObjectRepository.shareSecuredCheckedBox);
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.boatLoanCheckedBox).click();
					getElement(ObjectRepository.creditCardExpand).click();
					verifyElementPresent(ObjectRepository.platinumCheckedBox);
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
			test.log(Status.PASS, "Verify back button functionality for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}

