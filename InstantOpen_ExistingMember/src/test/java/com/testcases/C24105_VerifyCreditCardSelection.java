package com.testcases;

import org.testng.annotations.Test;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.io.IOException;

import javax.mail.MessagingException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class C24105_VerifyCreditCardSelection extends GenericKeywords {

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
  public void C24105_VerifyCreditCardSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String classicCardName=excl.getCellData(sheetName, 1, startIter);
					String buceesCardName=excl.getCellData(sheetName, 2, startIter);
					String platinumCardName=excl.getCellData(sheetName, 3, startIter);
					String OnyxCardName=excl.getCellData(sheetName, 4, startIter);				
					String classicCardMinText=excl.getCellData(sheetName, 16, startIter);
					String otherCardsMinText=excl.getCellData(sheetName, 17, startIter);
					String ccInfoPageMessage=excl.getCellData(sheetName, 23, startIter);
					String ccInfoTypeLabel=excl.getCellData(sheetName, 24, startIter);
					String ccInfoLimitLabel=excl.getCellData(sheetName, 25, startIter);
					String ccInfoClassicLim=excl.getCellData(sheetName, 11, startIter);
					String ccInfoOtherLim=excl.getCellData(sheetName, 12, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					scrollToElement(ObjectRepository.creditCardExpand);
					getElement(ObjectRepository.creditCardExpand).click();
					test.log(Status.INFO, "Credit Cards section expanded");
					
					//Classic MasterCard Validation
					getElement(ObjectRepository.classicCheckBox).click();	
					test.log(Status.INFO, "Classic MasterCard selected");
					verifyElementPresent(ObjectRepository.classicTitle);
					verifyText(ObjectRepository.classicCardMin,classicCardMinText);
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,classicCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoClassicLim);
					
					//Credit Card Info Display Elements
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					test.log(Status.INFO, "Classic Credit Card Title appearing");	
					verifyText(ObjectRepository.ccInfoContent,ccInfoPageMessage);
					verifyText(ObjectRepository.cardTypeLabel,ccInfoTypeLabel);
					verifyText(ObjectRepository.cardLimitLabel,ccInfoLimitLabel);
					verifyElementPresent(ObjectRepository.ccInfoBackButton);
					verifyElementPresent(ObjectRepository.ccInfoNextButton);
					
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					
					//Buc-ee's MasterCard Validation
					getElement(ObjectRepository.buceesCheckBox).click();
					test.log(Status.INFO, "Buc-ee's MasterCard Selected");
					verifyElementPresent(ObjectRepository.buceesTitle);
					verifyText(ObjectRepository.buceesCardMin,otherCardsMinText);
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,buceesCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					
					//Platinum MasterCard Validation
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Platinum MasterCard Selected");					
					verifyElementPresent(ObjectRepository.platinumTitle);
					verifyText(ObjectRepository.platinumCardMin,otherCardsMinText);
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,platinumCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);
					
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					
					//Onyx MasterCard Validation
					getElement(ObjectRepository.OnyxCheckBox).click();	
					test.log(Status.INFO, "Onyx MasterCard Selected");
					verifyElementPresent(ObjectRepository.OnyxTitle);
					verifyText(ObjectRepository.OnyxCardMin,otherCardsMinText);
					
					scrollToElement(ObjectRepository.continue_btn);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,OnyxCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);				
				 
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
			test.log(Status.PASS, "Verify credit card selection for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
