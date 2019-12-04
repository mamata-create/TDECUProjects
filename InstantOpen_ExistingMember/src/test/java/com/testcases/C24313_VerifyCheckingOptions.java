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

public class C24313_VerifyCheckingOptions extends GenericKeywords{
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
  public void C24313_VerifyCheckingOptions() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String option1=excl.getCellData(sheetName, 5, startIter);
					String option3=excl.getCellData(sheetName, 7, startIter);
					String option4=excl.getCellData(sheetName, 8, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.checkingExpand).click();
					getElement(ObjectRepository.classicCheckCheckBox).click();
					verifyText(ObjectRepository.checkingOpt1,option1);
					verifyText(ObjectRepository.checkingOpt3,option3);
					verifyText(ObjectRepository.checkingOpt4,option4);
					test.log(Status.INFO, "Classic Checking Options in correct order");
					getElement(ObjectRepository.ccCourtesyPayCheckBox).click();
					test.log(Status.INFO, "All options selected");
					getElement(ObjectRepository.ccDebitCardChecked).click();
					getElement(ObjectRepository.ccOverdraftChecked).click();
					getElement(ObjectRepository.ccCourtesyPayChecked).click();
					test.log(Status.INFO, "All options deselected");
					getElement(ObjectRepository.ccChecked).click();
					scrollToElement(ObjectRepository.highYieldCheckBox);
					getElement(ObjectRepository.highYieldCheckBox).click();
					verifyText(ObjectRepository.checkingOpt5,option1);
					verifyText(ObjectRepository.checkingOpt7,option3);
					verifyText(ObjectRepository.checkingOpt8,option4);
					test.log(Status.INFO, "High Yield Checking Options in correct order");
					getElement(ObjectRepository.hyCourtesyPayCheckBox).click();
					test.log(Status.INFO, "All options selected");
					getElement(ObjectRepository.hyDebitCardChecked).click();
					getElement(ObjectRepository.hyOverdraftChecked).click();
					getElement(ObjectRepository.hyCourtesyPayChecked).click();								
					test.log(Status.INFO, "All options deselected");
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
			test.log(Status.PASS, "Verify checking account options for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
