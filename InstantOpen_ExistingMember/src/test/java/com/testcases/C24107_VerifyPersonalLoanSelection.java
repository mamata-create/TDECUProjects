package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.By;
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

public class C24107_VerifyPersonalLoanSelection extends GenericKeywords {
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
  public void C24107_VerifyPersonalLoanSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String my4000Title= excl.getCellData(sheetName, 1, startIter);
					String termNum;
					String monthTerm= excl.getCellData(sheetName, 16, startIter);
					String noCollatReq= excl.getCellData(sheetName, 17, startIter);
					String myWayAPR= excl.getCellData(sheetName, 18, startIter);
					String min4000= excl.getCellData(sheetName, 11, startIter);
					String my6000Title= excl.getCellData(sheetName, 2, startIter);
					String min6000= excl.getCellData(sheetName, 12, startIter);
					String my7000Title= excl.getCellData(sheetName, 3, startIter);
					String min7000= excl.getCellData(sheetName, 13, startIter);
					String personalTitle= excl.getCellData(sheetName, 4, startIter);
					String personalDesc1= excl.getCellData(sheetName, 19, startIter);
					String ratesDesc= excl.getCellData(sheetName, 20, startIter);
					String min1000= excl.getCellData(sheetName, 14, startIter);
					String homeAdvTitle= excl.getCellData(sheetName, 5, startIter);
					String cash$tashLOCTitle= excl.getCellData(sheetName, 6, startIter);
					String cash$tashWrongTitle= excl.getCellData(sheetName, 9, startIter);
					String cdLoanTitle= excl.getCellData(sheetName, 7, startIter);
					String ssLoanTitle= excl.getCellData(sheetName, 8, startIter);
					String ssLoanDesc1= excl.getCellData(sheetName, 21, startIter);
					String ssLoanDesc2= excl.getCellData(sheetName, 22, startIter);
					String min500= excl.getCellData(sheetName, 15, startIter);
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.personalLoanExpand).click();
					test.log(Status.INFO, "Personal Loan section expanded");
					
					//Verify My Way Loan:$4,000 section					
					verifyText(ObjectRepository.myWay4000Title,my4000Title);
					getElement(ObjectRepository.myWay4000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$4,000 selected");
					termNum = "48";
					verifyText(ObjectRepository.myWay48Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay4000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay4000APR,myWayAPR);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my4000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min4000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay4000CheckedBox);
					
					//Verify My Way Loan:$6,000 section					
					verifyText(ObjectRepository.myWay6000Title,my6000Title);
					getElement(ObjectRepository.myWay6000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$6,000 selected");
					termNum = "60";
					verifyText(ObjectRepository.myWay60Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay6000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay6000APR,myWayAPR);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my6000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min6000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay6000CheckedBox);
					
					//Verify My Way Loan:$7,000 section					
					verifyText(ObjectRepository.myWay7000Title,my7000Title);
					getElement(ObjectRepository.myWay7000CheckBox).click();
					test.log(Status.INFO, "My Way Loan:$7,000 selected");
					termNum = "72";
					verifyText(ObjectRepository.myWay72Term,(termNum+" "+monthTerm));
					verifyText(ObjectRepository.myWay7000Collat,noCollatReq);
					verifyText(ObjectRepository.myWay7000APR,myWayAPR);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,my7000Title);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min7000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.myWay7000CheckedBox);
					
					//Verify Personal Loan section					
					verifyText(ObjectRepository.personalTitle,personalTitle);
					getElement(ObjectRepository.personalCheckBox).click();
					test.log(Status.INFO, "Personal Loan selected");
					verifyText(ObjectRepository.personalDesc1,personalDesc1);
					verifyText(ObjectRepository.personalDesc2,ratesDesc);
					verifyRatesLink(11);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,personalTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.personalCheckedBox);
					
					//Verify Home Advantage Personal Loan section
					scrollToElement(ObjectRepository.homeAdvTitle);
					verifyText(ObjectRepository.homeAdvTitle,homeAdvTitle);
					getElement(ObjectRepository.homeAdvCheckBox).click();
					test.log(Status.INFO, "Home Advantage Personal Loan selected");
					homeAdvLoanInfoValidation();
					verifyRatesLink(12);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,homeAdvTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.homeAdvCheckedBox);
					
					//Verify Cash $tash LOC section
					scrollToElement(ObjectRepository.cash$tashTitle);
					verifyText(ObjectRepository.cash$tashTitle,cash$tashLOCTitle);
					getElement(ObjectRepository.cash$tashCheckBox).click();
					test.log(Status.INFO, "Cash $tash Line of Credit selected");
					cash$tashLOCInfoValidation();
					verifyRatesLink(13);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cash$tashWrongTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.cash$tashCheckedBox);
					
					//Verify CD Secured Loan section
					scrollToElement(ObjectRepository.cdSecuredTitle);
					verifyText(ObjectRepository.cdSecuredTitle,cdLoanTitle);
					getElement(ObjectRepository.cdSecuredCheckBox).click();
					test.log(Status.INFO, "Certificate of Deposit Secured Loan selected");
					CDsecuredLoanInfoValidation();
					verifyRatesLink(14);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cdLoanTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min1000);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.cdSecuredCheckedBox);
					
					//Verify Share Secured Loan section
					scrollToElement(ObjectRepository.shareSecuredTitle);
					verifyText(ObjectRepository.shareSecuredTitle,ssLoanTitle);
					getElement(ObjectRepository.shareSecuredCheckBox).click();
					test.log(Status.INFO, "Share Secured Loan selected");
					verifyText(ObjectRepository.shareSecuredDesc1,ssLoanDesc1);
					verifyText(ObjectRepository.shareSecuredDesc2,ssLoanDesc2);
					verifyText(ObjectRepository.shareSecuredDesc3,ratesDesc);
					verifyRatesLink(15);
					getElement(ObjectRepository.continue_btn).click();
					test.log(Status.INFO, "Continue button clicked");
					//Personal Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,ssLoanTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,min500);
					//Back to Product Selection Page
					getElement(ObjectRepository.ccInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.shareSecuredCheckedBox);
					getElement(ObjectRepository.shareSecuredCheckBox).click();
					test.log(Status.INFO, "Share Secured Loan deselected");
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
