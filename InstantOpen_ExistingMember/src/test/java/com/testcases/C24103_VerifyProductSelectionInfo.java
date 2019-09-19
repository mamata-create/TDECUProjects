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

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;



public class C24103_VerifyProductSelectionInfo extends GenericKeywords{
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
  public void C23835_VerifyProductSelectionInfo() {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			 {	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				{
					String informationHeader=excl.getCellData(sheetName, 23, startIter);
					String informationContent = excl.getCellData(sheetName, 24, startIter);
					String groupOneTitle = excl.getCellData(sheetName, 1, startIter);
					String ccTitle = excl.getCellData(sheetName, 2, startIter);
					String carLoanTitle = excl.getCellData(sheetName, 3, startIter);
					String carLoanTitle2 = excl.getCellData(sheetName, 4, startIter);
					String personalLoanTitle = excl.getCellData(sheetName, 5, startIter);
					String groupTwoTitle = excl.getCellData(sheetName, 6, startIter);
					String cdTitle = excl.getCellData(sheetName, 7, startIter);
					String checkingAndMMTitle = excl.getCellData(sheetName, 8, startIter);
					String savingsTitle = excl.getCellData(sheetName, 9, startIter);
					String addServiceTitle = excl.getCellData(sheetName, 10, startIter);					
					
					verifyElementPresent(ObjectRepository.app_ttl);
					test.log(Status.INFO, "Instant Open Title appearing");
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					verifyText(ObjectRepository.msgHeader,informationHeader);
					verifyText(ObjectRepository.msgContent,informationContent);
					verifyText(ObjectRepository.CCandLoanTitle,groupOneTitle);
					verifyText(ObjectRepository.ccTitle,ccTitle);
					verifyText(ObjectRepository.carLoanTitle,carLoanTitle);
					verifyText(ObjectRepository.carLoanTitle2,carLoanTitle2);
					verifyText(ObjectRepository.persoalLoanTitle,personalLoanTitle);
					verifyText(ObjectRepository.addWaystoSaveTitle,groupTwoTitle);
					verifyText(ObjectRepository.cdTitle,cdTitle);
					verifyText(ObjectRepository.checkingTitle,checkingAndMMTitle);
					verifyText(ObjectRepository.savingsTitle,savingsTitle);
					verifyText(ObjectRepository.additionalTitle,addServiceTitle);
					
					disclaimerValidation();	
					
					verifyElementPresent(ObjectRepository.productPageBack);
					verifyElementPresent(ObjectRepository.productPageNext);
					
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
	  	test.log(Status.PASS, "Verify existing member product selection information");
	  }
  }

	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
}
