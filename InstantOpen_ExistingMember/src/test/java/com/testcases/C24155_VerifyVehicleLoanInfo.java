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

public class C24155_VerifyVehicleLoanInfo extends GenericKeywords{
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
  public void C24155_VerifyVehicleLoanInfo() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String loanInfoMsg= excl.getCellData(sheetName, 24, startIter);
					String typeLbl=excl.getCellData(sheetName, 16, startIter);
					String amountLbl= excl.getCellData(sheetName, 17, startIter);
					String prchPriceLbl= excl.getCellData(sheetName, 18, startIter);
					String makeLbl = excl.getCellData(sheetName, 19, startIter);
					String modelLbl= excl.getCellData(sheetName, 20, startIter);
					String yearLbl = excl.getCellData(sheetName, 21, startIter);
					String milesLbl = excl.getCellData(sheetName, 22, startIter);
					String VINlbl = excl.getCellData(sheetName, 23, startIter);
					String backBtn = excl.getCellData(sheetName, 25, startIter);
					String continueBtn = excl.getCellData(sheetName, 26, startIter);
					String oneNumber = excl.getCellData(sheetName, 11, startIter);
					String popupMsg = excl.getCellData(sheetName, 30, startIter);
					String carDdown= excl.getCellData(sheetName, 1, startIter);
					String boatDdown=excl.getCellData(sheetName, 2, startIter);
					String rvDdown= excl.getCellData(sheetName, 3, startIter);
					String jetskiDdown= excl.getCellData(sheetName, 4, startIter);
					String cycleDdown = excl.getCellData(sheetName, 5, startIter);
					String carRefDdown= excl.getCellData(sheetName, 6, startIter);
					String cycleRefDdown = excl.getCellData(sheetName, 7, startIter);
					String rvRefDdown = excl.getCellData(sheetName, 8, startIter);
					String boatRefDdown = excl.getCellData(sheetName, 9, startIter);
					String atvDdown = excl.getCellData(sheetName, 10, startIter);
					String loanAmount = excl.getCellData(sheetName, 12, startIter);
					String loanFormat = excl.getCellData(sheetName, 13, startIter);
					String purchPrice = excl.getCellData(sheetName, 14, startIter);
					String priceFormat = excl.getCellData(sheetName, 15, startIter);
					String make = excl.getCellData(sheetName, 31, startIter);
					String model = excl.getCellData(sheetName, 32, startIter);
					String year = excl.getCellData(sheetName, 33, startIter);
					String mileage = excl.getCellData(sheetName, 34, startIter);
					String vin = excl.getCellData(sheetName, 35, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					//select loan
					getElement(ObjectRepository.carLoanExpand).click();
					getElement(ObjectRepository.cycleRefinCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Vehicle loan selected");
					//verify elements
					verifyElementPresent(ObjectRepository.carLoanInfoTtl);
					verifyText(ObjectRepository.prodInfoMsg,loanInfoMsg);
					verifyText(ObjectRepository.prodTypeLabel,typeLbl);
					verifyText(ObjectRepository.prodLimitLabel,amountLbl);
					verifyText(ObjectRepository.carPriceLbl,prchPriceLbl);
					verifyText(ObjectRepository.carMakeLbl,makeLbl);
					verifyText(ObjectRepository.carModelLbl,modelLbl);
					verifyText(ObjectRepository.carYearLbl,yearLbl);
					verifyText(ObjectRepository.carMilesLbl,milesLbl);
					verifyText(ObjectRepository.carVINLbl,VINlbl);
					verifyTxtFieldValue(ObjectRepository.prodInfoBackButton,backBtn);
					verifyTxtFieldValue(ObjectRepository.prodInfoNextButton,continueBtn);
					test.log(Status.INFO, "Labels verified");
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,carDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,boatDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,rvDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,jetskiDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,cycleDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,carRefDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,cycleRefDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,rvRefDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,boatRefDdown);
					selectDropdownOptContain(ObjectRepository.prodTypeDropdown,atvDdown);
					test.log(Status.INFO, "Dropdown values verified");
					//enter values
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(oneNumber);
					verifyElementPresent(ObjectRepository.prodLimIncorrect);
					verifyText(ObjectRepository.prodLimPopup,popupMsg);
					test.log(Status.INFO, "Amount popup message displayed");
					getElement(ObjectRepository.prodLimitTextbox).clear();
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.prodLimitTextbox,loanFormat);
					getElement(ObjectRepository.carPurchPrice).sendKeys(purchPrice);
					getElement(ObjectRepository.carPurchPrice).sendKeys(Keys.TAB);
					verifyTxtFieldValue(ObjectRepository.carPurchPrice,priceFormat);
					getElement(ObjectRepository.carMake).sendKeys(make);
					getElement(ObjectRepository.carModel).sendKeys(model);
					getElement(ObjectRepository.carYear).sendKeys(year);
					getElement(ObjectRepository.carMiles).clear();
					getElement(ObjectRepository.carMiles).sendKeys(mileage);
					getElement(ObjectRepository.carVIN).sendKeys(vin);
					test.log(Status.INFO, "Vehicle info entered");
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Continue button clicked");
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
			test.log(Status.PASS, "Verify Vehicle Loan Info page for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
