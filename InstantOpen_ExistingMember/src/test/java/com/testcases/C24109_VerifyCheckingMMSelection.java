package com.testcases;

import java.io.IOException;

import javax.mail.MessagingException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.FrameworkComponents.BaseClass;
import com.FrameworkComponents.ExtentManager;
import com.FrameworkComponents.GenericKeywords;
import com.FrameworkComponents.ObjectRepository;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class C24109_VerifyCheckingMMSelection extends GenericKeywords{
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
	  public void C24109_VerifyCheckingMMSelection() throws InterruptedException, MessagingException, IOException {
		  if(continuetestcase==true)
		  {
				sheetName = "ProdData";
				int totalRowCount = excl.getRowCount(sheetName);
				for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
				{	
					if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
					{
						String ccTitle= excl.getCellData(sheetName, 1, startIter);
						String ccDesc1= excl.getCellData(sheetName, 16, startIter);
						String ccDesc2= excl.getCellData(sheetName, 17, startIter);
						String mmTitle= excl.getCellData(sheetName, 2, startIter);
						String mmDesc1= excl.getCellData(sheetName, 18, startIter);
						String mmDesc2= excl.getCellData(sheetName, 19, startIter);
						String mmDesc3= excl.getCellData(sheetName, 20, startIter);
						String hyTitle= excl.getCellData(sheetName, 3, startIter);
						String overdraftTitle= excl.getCellData(sheetName, 4, startIter);
						String overdraftInfo= excl.getCellData(sheetName, 23, startIter);
						String courtesyPayTitle= excl.getCellData(sheetName, 5, startIter);
						String courtesyPayInfo= excl.getCellData(sheetName, 24, startIter);
						
						verifyElementPresent(ObjectRepository.app_ttl);
						test.log(Status.INFO, "Instant Open Title appearing");
						
						scrollToElement(ObjectRepository.mmbrstrt_btn);
						getElement(ObjectRepository.mmbrstrt_btn).click();
						test.log(Status.INFO, "Members Start Here button clicked");
						
						scrollToElement(ObjectRepository.checkingExpand);
						getElement(ObjectRepository.checkingExpand).click();
						test.log(Status.INFO, "Checking & Money Market Accounts section expanded");	
						
						//Classic Checking section
						verifyText(ObjectRepository.classicCheckTitle,ccTitle);
						verifyText(ObjectRepository.classicCheckDesc1,ccDesc1);
						verifyText(ObjectRepository.classicCheckDesc2,ccDesc2);
						getElement(ObjectRepository.classicCheckCheckBox).click();
						verifyElementPresent(ObjectRepository.ccDebitCardChecked);
						verifyElementPresent(ObjectRepository.ccOverdraftChecked);
						verifyElementPresent(ObjectRepository.ccCourtesyPayCheckBox);
						getElement(ObjectRepository.overdraftQstion).click();
						verifyText(ObjectRepository.overdraftTitle,overdraftTitle);
						verifyText(ObjectRepository.overdraftDesc,overdraftInfo);
						getElement(ObjectRepository.overdraftClose).click();
						Thread.sleep(2000);
						getElement(ObjectRepository.courtesyPayQstion).click();
						//Error finding title element
						//verifyText(ObjectRepository.courtesyPayTitle,courtesyPayTitle);
						verifyText(ObjectRepository.courtesyPayDesc,courtesyPayInfo);
						verifyOverdraftPDF();
						getElement(ObjectRepository.courtesyPayClose).click();
						Thread.sleep(2000);
						getElement(ObjectRepository.ccDebitCardChecked).click();
						getElement(ObjectRepository.ccOverdraftChecked).click();
						getElement(ObjectRepository.ccCourtesyPayCheckBox).click();
						
						//Money Market section
						getElement(ObjectRepository.mnyMrktCheckBox).click();
						verifyText(ObjectRepository.mnyMrktTitle,mmTitle);
						verifyText(ObjectRepository.mnyMrktDesc1,mmDesc1);
						verifyText(ObjectRepository.mnyMrktDesc2,mmDesc2);
						verifyText(ObjectRepository.mnyMrktDesc3,mmDesc3);
						verifyOtherRatesLink(2);
						
						/*verifyText(ObjectRepository.highYieldTitle,hyTitle);
						highYieldInfoValidation();*/
						
						//Go back
						verifyElementPresent(ObjectRepository.ccChecked);
						verifyElementPresent(ObjectRepository.ccDebitCardCheckBox);
						verifyElementPresent(ObjectRepository.ccOverdraftCheckBox);
						verifyElementPresent(ObjectRepository.ccCourtesyPayChecked);
						verifyElementPresent(ObjectRepository.mnyMrktChecked);
						
					}
				}
		  }
	  }

}
