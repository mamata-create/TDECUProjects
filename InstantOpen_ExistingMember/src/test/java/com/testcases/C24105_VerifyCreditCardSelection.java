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
					String fuelDesc=excl.getCellData(sheetName, 16, startIter);
					String footNote2="2";
					String classicCardMinText=excl.getCellData(sheetName, 17, startIter);
					String otherCardsMinText=excl.getCellData(sheetName, 18, startIter);
					String noFeeDesc=excl.getCellData(sheetName, 19, startIter);
					String zeroAPR=excl.getCellData(sheetName, 20, startIter);
					String footNote3="3";
					String onyxRebate=excl.getCellData(sheetName, 21, startIter);			
					String ccInfoPageMessage=excl.getCellData(sheetName, 23, startIter);
					String ccInfoTypeLabel=excl.getCellData(sheetName, 24, startIter);
					String ccInfoLimitLabel=excl.getCellData(sheetName, 25, startIter);		
					String ccInfoClassicLim=excl.getCellData(sheetName, 11, startIter);
					String ccInfoOtherLim=excl.getCellData(sheetName, 12, startIter);
					String ccAmount=excl.getCellData(sheetName, 13, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idTypeDD= excl.getCellData(sheetName, 5, startIter);
					String idNumber= excl.getCellData(sheetName, 6, startIter);
					String issueDt= excl.getCellData(sheetName, 7, startIter);
					String expireDt= excl.getCellData(sheetName, 8, startIter);
					String housePymt= excl.getCellData(sheetName, 9, startIter);
					String addrYears= excl.getCellData(sheetName, 10, startIter);
					String addrMonths= excl.getCellData(sheetName, 14, startIter);
					String currentEmp= excl.getCellData(sheetName, 15, startIter);
					String curIncome= excl.getCellData(sheetName, 26, startIter);
					String empYears= excl.getCellData(sheetName, 30, startIter);
					String empMonths= excl.getCellData(sheetName, 31, startIter);
					String OnyxName= excl.getCellData(sheetName, 32, startIter);
					String CDName= excl.getCellData(sheetName, 33, startIter);
					
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
					verifyText(ObjectRepository.classicDesc1,fuelDesc);
					verifyText(ObjectRepository.classicFoot2,footNote2);
					verifyText(ObjectRepository.classicDesc2,classicCardMinText);
					verifyText(ObjectRepository.classicDesc3,noFeeDesc);
					verifyText(ObjectRepository.classicDesc4,zeroAPR);
					verifyText(ObjectRepository.classicFoot3,footNote3);
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,classicCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoClassicLim);
					
					//Credit Card Info Display Elements
					verifyElementPresent(ObjectRepository.crdtcrdinf_ttl);
					test.log(Status.INFO, "Credit Card Info Title appearing");	
					verifyText(ObjectRepository.prodInfoMsg,ccInfoPageMessage);
					verifyText(ObjectRepository.prodTypeLabel,ccInfoTypeLabel);
					verifyText(ObjectRepository.prodLimitLabel,ccInfoLimitLabel);
					//Back to Product Page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.classicCheckedBox);
					
					//Buc-ee's MasterCard Validation
					getElement(ObjectRepository.buceesCheckBox).click();
					test.log(Status.INFO, "Buc-ee's MasterCard Selected");
					verifyElementPresent(ObjectRepository.buceesTitle);
					verifyText(ObjectRepository.buceesDesc1,fuelDesc);
					verifyText(ObjectRepository.buceesFoot2,footNote2);
					verifyText(ObjectRepository.buceesDesc2,otherCardsMinText);
					verifyText(ObjectRepository.buceesDesc3,noFeeDesc);
					verifyText(ObjectRepository.buceesDesc4,zeroAPR);
					verifyText(ObjectRepository.bucceesFoot3,footNote3);					
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,buceesCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);
					//Back to Product page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.buceesCheckedBox);
					
					//Platinum MasterCard Validation
					getElement(ObjectRepository.platinumCheckBox).click();
					test.log(Status.INFO, "Platinum MasterCard Selected");					
					verifyElementPresent(ObjectRepository.platinumTitle);
					verifyText(ObjectRepository.platinumDesc1,fuelDesc);
					verifyText(ObjectRepository.platinumFoot2,footNote2);
					verifyText(ObjectRepository.platinumDesc2,otherCardsMinText);
					verifyText(ObjectRepository.platinumDesc3,noFeeDesc);
					verifyText(ObjectRepository.platinumDesc4,zeroAPR);
					verifyText(ObjectRepository.platinumFoot3,footNote3);					
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,platinumCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);
					//Back to Product page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.platinumCheckedBox);
					
					//Onyx MasterCard Validation
					getElement(ObjectRepository.OnyxCheckBox).click();	
					test.log(Status.INFO, "Onyx MasterCard Selected");
					verifyElementPresent(ObjectRepository.OnyxTitle);
					verifyText(ObjectRepository.OnyxDesc1,fuelDesc);
					verifyText(ObjectRepository.OnyxFoot2,footNote2);
					verifyText(ObjectRepository.OnyxDesc2,otherCardsMinText);
					verifyText(ObjectRepository.OnyxDesc3,noFeeDesc);
					verifyText(ObjectRepository.OnyxDesc4,zeroAPR);
					verifyText(ObjectRepository.OnyxFoot3,footNote3);
					verifyText(ObjectRepository.OnyxDesc5,onyxRebate);
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Credit Card Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,OnyxCardName);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,ccInfoOtherLim);
					//Back to Product page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.OnyxCheckedBox);
					getElement(ObjectRepository.cdExpand).click();
					selectDropdownOpt(ObjectRepository.selectTermDropdown,"24");
					getElement(ObjectRepository.visibleCD24).click();
					test.log(Status.INFO, "Credit card and 24 Month CD selected");
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Prod Info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(ccAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Credit card amount entered");
					getElement(ObjectRepository.mmbrVerifyNum).sendKeys(mmbrNum);
					getElement(ObjectRepository.mmbrVerifySSN).sendKeys(SSN);
					getElement(ObjectRepository.mmbrVerifyDOB).sendKeys(DOB);
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
					verifyText(ObjectRepository.prodOne,OnyxName);
					verifyText(ObjectRepository.prodTwo,CDName);
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
			test.log(Status.PASS, "Verify Credit Card product section for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
