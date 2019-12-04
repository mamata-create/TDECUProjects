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

public class C24157_VerifyVehicleLoanMinMax extends GenericKeywords{
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
  public void C24157_VerifyVehicleLoanMinMax() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String popupMsg=excl.getCellData(sheetName, 23, startIter);
					String loanAmt=excl.getCellData(sheetName, 12, startIter);
					String loanAmtFormat=excl.getCellData(sheetName, 13, startIter);
					String selectRV=excl.getCellData(sheetName, 1, startIter);
					String selectCycle=excl.getCellData(sheetName, 2, startIter);
					String selectRefRV=excl.getCellData(sheetName, 3, startIter);
					String selectRefBoat=excl.getCellData(sheetName, 4, startIter);
					String selectAuto=excl.getCellData(sheetName, 5, startIter);
					String amount1=excl.getCellData(sheetName, 6, startIter);
					String amount2=excl.getCellData(sheetName, 7, startIter);
					String amount3=excl.getCellData(sheetName, 8, startIter);
					String amount4=excl.getCellData(sheetName, 9, startIter);
					String amount5=excl.getCellData(sheetName, 10, startIter);
					String amount6=excl.getCellData(sheetName, 11, startIter);
					String popupMsg2=excl.getCellData(sheetName, 24, startIter);
					String popupMsg3=excl.getCellData(sheetName, 25, startIter);
					String popupMsg4=excl.getCellData(sheetName, 26, startIter);
					String popupMsg5=excl.getCellData(sheetName, 30, startIter);
					String popupMsg6=excl.getCellData(sheetName, 31, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					//Select loan
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.cycleRefinCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Refinance Motorcycle Loan selected");
					//1000-100000
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount1);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);					
					test.log(Status.INFO, "$1,000-$100,000 popup appeared");
					//5000-100000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectRV);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount2);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg2);
					test.log(Status.INFO, "$5,000-$100,000 popup appeared");
					//1000-125000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectCycle);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount3);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg3);
					test.log(Status.INFO, "$1,000-$125,000 popup appeared");
					//5000-150000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectRefRV);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount4);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg4);
					test.log(Status.INFO, "$5,000-$150,000 popup appeared");
					//1000-150000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectRefBoat);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount5);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg5);
					test.log(Status.INFO, "$1,000-$150,000 popup appeared");
					//1000-1000000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectAuto);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(amount6);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.BACK_SPACE);
					verifyText(ObjectRepository.prodLimPopup,popupMsg6);
					test.log(Status.INFO, "$1,000-$1,000,000 popup appeared");
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,loanAmtFormat);
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
			test.log(Status.PASS, "Verify vehicle loans min and max for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
