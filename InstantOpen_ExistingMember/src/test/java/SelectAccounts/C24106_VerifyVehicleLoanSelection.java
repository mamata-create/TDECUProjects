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

public class C24106_VerifyVehicleLoanSelection extends GenericKeywords {
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
  public void C24106_VerifyVehicleLoanSelection() throws InterruptedException, MessagingException, IOException {
	  if(continuetestcase==true)
	  {
			sheetName = "ProdData";
			int totalRowCount = excl.getRowCount(sheetName);
			for(startIter=1;startIter<=totalRowCount;startIter++) //It is mandatory to have this for loop in every test case
			{	
				if(this.getClass().getSimpleName().equals(excl.getCellData("ProdData", 0, startIter)))
				 {
					String autoTitle=excl.getCellData(sheetName, 1, startIter);
					String loanMinOne= excl.getCellData(sheetName, 11, startIter);
					String autoRefinTitle= excl.getCellData(sheetName, 2, startIter);
					String cycleTitle = excl.getCellData(sheetName, 3, startIter);
					String loanRatesDesc= excl.getCellData(sheetName, 16, startIter);
					String refinCycleTitle = excl.getCellData(sheetName, 4, startIter);
					String boatSectionTitle = excl.getCellData(sheetName, 5, startIter);
					String boatRefinTitle = excl.getCellData(sheetName, 6, startIter);
					String camperSectionTitle = excl.getCellData(sheetName, 7, startIter);
					String camperRefinTitle = excl.getCellData(sheetName, 8, startIter);
					String watercraftTitle = excl.getCellData(sheetName, 9, startIter);
					String atvSectionTitle = excl.getCellData(sheetName, 10, startIter);
					String loanMinTwo= excl.getCellData(sheetName, 12, startIter);
					String jetSkiInfo= excl.getCellData(sheetName, 17, startIter);
					String loanAmount= excl.getCellData(sheetName, 13, startIter);
					String prodAmount= excl.getCellData(sheetName, 14, startIter);
					String mmbrNum= excl.getCellData(sheetName, 27, startIter);
					String SSN= excl.getCellData(sheetName, 28, startIter);
					String DOB= excl.getCellData(sheetName, 29, startIter);
					String idTypeDD= excl.getCellData(sheetName, 18, startIter);
					String idNumber= excl.getCellData(sheetName, 19, startIter);
					String issueDt= excl.getCellData(sheetName, 20, startIter);
					String expireDt= excl.getCellData(sheetName, 21, startIter);
					String housePymt= excl.getCellData(sheetName, 22, startIter);
					String addrYears= excl.getCellData(sheetName, 23, startIter);
					String addrMonths= excl.getCellData(sheetName, 24, startIter);
					String currentEmp= excl.getCellData(sheetName, 25, startIter);
					String curIncome= excl.getCellData(sheetName, 26, startIter);
					String empYears= excl.getCellData(sheetName, 30, startIter);
					String empMonths= excl.getCellData(sheetName, 31, startIter);
					String confirmProd= excl.getCellData(sheetName, 32, startIter);
					
					scrollToElement(ObjectRepository.mmbrstrt_btn);
					getElement(ObjectRepository.mmbrstrt_btn).click();
					test.log(Status.INFO, "Members Start Here button clicked");
					
					getElement(ObjectRepository.carLoanExpand).click();
					test.log(Status.INFO, "Vehicle Loan section expanded");
					
					//Verify Auto Loan section
					verifyText(ObjectRepository.autoLoanTitle,autoTitle);
					autoLoanInfoValidation();
					verifyHereLink(1);
					getElement(ObjectRepository.autoLoanCheckBox).click();
					test.log(Status.INFO, "Auto Loan(New or Used) selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Vehicle Loan Info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,autoTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.autoLoanCheckedBox);
					
					//Verify Refinance Auto Loan section
					verifyText(ObjectRepository.autoRefinTitle,autoRefinTitle);
					autoRefinInfoValidation();
					verifyHereLink(2);
					getElement(ObjectRepository.autoRefinCheckBox).click();
					test.log(Status.INFO, "Refinance your Auto Loan selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,autoRefinTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.autoRefinCheckedBox);
					
					//Verify Motorcycle Loan section
					verifyText(ObjectRepository.motorcycleTitle,cycleTitle);
					verifyText(ObjectRepository.motorcycleRatesInfo,loanRatesDesc);
					verifyHereLink(3);
					getElement(ObjectRepository.motorcycleCheckBox).click();
					test.log(Status.INFO, "Motorcycle Loans(New or Used) selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,cycleTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.motorcycleCheckedBox);
					
					//Verify Refinance Motorcycle Loan section
					verifyText(ObjectRepository.cycleRefinTitle,refinCycleTitle);
					verifyText(ObjectRepository.cycleRefinRatesInfo,loanRatesDesc);
					verifyHereLink(4);
					getElement(ObjectRepository.cycleRefinCheckBox).click();
					test.log(Status.INFO, "Refinance your Motorcycle Loan selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,refinCycleTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.cycleRefinCheckedBox);
					
					//Verify Boat Loan section
					scrollToElement(ObjectRepository.boatLoanTitle);
					verifyText(ObjectRepository.boatLoanTitle,boatSectionTitle);
					verifyText(ObjectRepository.boatLoanRatesInfo,loanRatesDesc);
					verifyHereLink(5);
					getElement(ObjectRepository.boatLoanCheckBox).click();
					test.log(Status.INFO, "Boat Loans(New or Used) selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,boatSectionTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.boatLoanCheckedBox);
					
					//Verify Refinance Boat Loan section
					scrollToElement(ObjectRepository.boatRefinTitle);
					verifyText(ObjectRepository.boatRefinTitle,boatRefinTitle);
					verifyText(ObjectRepository.boatRefinRatesInfo,loanRatesDesc);
					verifyHereLink(6);
					getElement(ObjectRepository.boatRefinCheckBox).click();
					test.log(Status.INFO, "Refinance your Boat Loan selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,boatRefinTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinOne);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.boatRefinCheckedBox);
					
					//Verify RV/Camper Loan section
					scrollToElement(ObjectRepository.camperLoanTitle);
					verifyText(ObjectRepository.camperLoanTitle,camperSectionTitle);
					verifyText(ObjectRepository.camperRatesInfo,loanRatesDesc);
					verifyHereLink(7);
					getElement(ObjectRepository.camperLoanCheckBox).click();
					test.log(Status.INFO, "R/V Camper Loan selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,camperSectionTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinTwo);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.camperLoanCheckedBox);
					
					//Verify Refinance RV/Camper Loan section
					scrollToElement(ObjectRepository.camperRefinTitle);
					verifyText(ObjectRepository.camperRefinTitle,camperRefinTitle);
					verifyText(ObjectRepository.camperRefinRatesInfo,loanRatesDesc);
					verifyHereLink(8);
					getElement(ObjectRepository.camperRefinCheckBox).click();
					test.log(Status.INFO, "Refinance R/V Camper Loan selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,camperRefinTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinTwo);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.camperRefinCheckedBox);
					
					//Verify Personal Watercraft Loan section
					scrollToElement(ObjectRepository.watercraftTitle);
					verifyText(ObjectRepository.watercraftTitle,watercraftTitle);
					verifyText(ObjectRepository.jetSkiInfo,jetSkiInfo);
					verifyText(ObjectRepository.jetSkiRatesInfo,loanRatesDesc);
					verifyHereLink(9);
					getElement(ObjectRepository.watercraftCheckBox).click();
					test.log(Status.INFO, "Personal Watercraft(New or Used) selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,watercraftTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinTwo);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.watercraftCheckedBox);
					
					//Verify ATV/UTV Loan section
					scrollToElement(ObjectRepository.atvLoanTitle);
					verifyText(ObjectRepository.atvLoanTitle,atvSectionTitle);
					verifyText(ObjectRepository.atvRatesInfo,loanRatesDesc);
					verifyHereLink(10);
					getElement(ObjectRepository.atvLoanCheckBox).click();
					test.log(Status.INFO, "ATV/UTV Loan(New or Used) selected");
					scrollToElement(ObjectRepository.productPageNext);
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Continue button clicked");					
					//Vehicle Loan info page
					verifyDropdownSelection(ObjectRepository.prodTypeDropdown,atvSectionTitle);
					verifyPlaceholder(ObjectRepository.prodLimitTextbox,loanMinTwo);
					//Back to product selection page
					getElement(ObjectRepository.prodInfoBackButton).click();
					test.log(Status.INFO, "Back Button clicked");
					verifyElementPresent(ObjectRepository.atvLoanCheckedBox);
					getElement(ObjectRepository.atvLoanCheckedBox).click();
					//verifyElementPresent(ObjectRepository.atvLoanCheckBox);
					getElement(ObjectRepository.atvLoanCheckBox).click();
					getElement(ObjectRepository.savingsExpand).click();
					getElement(ObjectRepository.clubCheckBox).click();
					getElement(ObjectRepository.productPageNext).click();
					test.log(Status.INFO, "Loan and club account selected");
					//Prod Info
					getElement(ObjectRepository.prodLimitTextbox).sendKeys(loanAmount);
					getElement(ObjectRepository.carPurchPrice).sendKeys(prodAmount);
					getElement(ObjectRepository.prodInfoNextButton).click();
					test.log(Status.INFO, "Loan info entered");
					//Member Verification
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
					verifyText(ObjectRepository.prodOne,atvSectionTitle);
					verifyText(ObjectRepository.prodTwo,confirmProd);
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
			test.log(Status.PASS, "Verify Vehicle Loan product section for existing member");
		}
	}

  @AfterTest
  public void tearDown() {
	 extent.flush();
	 driver.quit();
  }

}
