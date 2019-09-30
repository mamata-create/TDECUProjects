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

public class C24153_VerifyCreditCardLimit extends GenericKeywords{
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
  public void C24153_VerifyCreditCardLimit() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String oneNum=excl.getCellData(sheetName, 6, startIter);
					String classicPopup=excl.getCellData(sheetName, 23, startIter);
					String classicLim=excl.getCellData(sheetName, 7, startIter);
					String classicFormat=excl.getCellData(sheetName, 8, startIter);
					String onyxName=excl.getCellData(sheetName, 1, startIter);
					String onyxLim=excl.getCellData(sheetName, 11, startIter);
					String otherPopup=excl.getCellData(sheetName, 24, startIter);
					String otherLim=excl.getCellData(sheetName, 9, startIter);
					String otherLimFormat=excl.getCellData(sheetName, 10, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//select classic mastercard
					scrollToElement(ObjectRepository.creditCardExpand);
					getElement(ObjectRepository.creditCardExpand).click();
					getElement(ObjectRepository.classicCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Classic MasterCard selected");
					//verify credit limit requested field
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneNum);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,classicPopup);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(classicLim);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,classicFormat);
					test.log(Status.INFO, "Classic MasterCard amount in correct format");
					//select onyx mastercard
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,onyxName);
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,onyxName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,onyxLim);
					test.log(Status.INFO, "Onyx MasterCard selected");
					//verify credit limit requested field
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneNum);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,otherPopup);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(otherLim);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,otherLimFormat);
					test.log(Status.INFO, "Onyx MasterCard amount in correct format");
					getElement(ObjectRepository.prodInfoNextButton).click();
					verifyElementPresent(ObjectRepository.mmbrVerifyTile);
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
			test.log(Status.PASS, "Verify Credit Card amounts for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
