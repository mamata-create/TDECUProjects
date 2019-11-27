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

public class C24162_VerifyPersonalLoanMinMax extends GenericKeywords{
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
  public void C24162_VerifyPersonalLoanMinMax() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String selectMyway6=excl.getCellData(sheetName, 1, startIter);
					String selectMyway7=excl.getCellData(sheetName, 2, startIter);
					String selectPersonal=excl.getCellData(sheetName, 3, startIter);
					String selectHomeAdv=excl.getCellData(sheetName, 4, startIter);
					String selectCashLOC=excl.getCellData(sheetName, 5, startIter);
					String selectCD=excl.getCellData(sheetName, 6, startIter);
					String selectShare=excl.getCellData(sheetName, 7, startIter);
					String oneDigit=excl.getCellData(sheetName, 11, startIter);
					String popup1=excl.getCellData(sheetName, 23, startIter);
					String popup2=excl.getCellData(sheetName, 24, startIter);
					String popup3=excl.getCellData(sheetName, 25, startIter);
					String popup4=excl.getCellData(sheetName, 26, startIter);
					String popup5=excl.getCellData(sheetName, 30, startIter);
					String popup6=excl.getCellData(sheetName, 31, startIter);
					String popup7=excl.getCellData(sheetName, 32, startIter);
					String popup8=excl.getCellData(sheetName, 33, startIter);
					String loanAmt=excl.getCellData(sheetName, 12, startIter);
					String loanAmtFormat=excl.getCellData(sheetName, 13, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//select loan
					getElement(ObjectRepository.personalLoanExpand).click();
					getElement(ObjectRepository.myWay4000CheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Personal loan selected");
					//4000
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup1);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$4,000-$4,000 popup appeared");
					//6000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectMyway6);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup2);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$6,000-$6,000 popup appeared");
					//7000
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectMyway7);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup3);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$7,000-$7,000 popup appeared");
					//personal
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectPersonal);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup4);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$1,000-$15,000 popup appeared");
					//home advantage
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectHomeAdv);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup5);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$1,000-$35,000 popup appeared");
					//cash $tash
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectCashLOC);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup6);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$1,000-$1,000 popup appeared");
					//CD secured loan
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectCD);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup7);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$1,000-$250,000 popup appeared");
					//share secured loan
					selectDropdownOpt(ObjectRepository.prodTypeDropdown,selectShare);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneDigit);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popup8);
					getElement(ObjectRepository.prodLimitTextbox).clear();
					test.log(Status.INFO, "$500-$250,000 popup appeared");
					//enter valid amount
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmt);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyElementPresent(ObjectRepository.prodLimCorrect);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,loanAmtFormat);
					test.log(Status.INFO, "Amount formatted correctly");
					//click continue
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
			test.log(Status.PASS, "Verify personal loans min and max for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
